package mars.wordpal.interfaces.shopinstore;

import mars.wordpal.application.payment.IabHelper;
import mars.wordpal.application.payment.IabResult;
import mars.wordpal.application.payment.Inventory;
import mars.wordpal.application.payment.Purchase;
import mars.wordpal.domain.model.WordCollection;
import mars.wordpal.infrastructure.DatabaseManager;
import mars.wordpal.infrastructure.WordCollectionsInMemory;
import mars.wordpal.interfaces.SingleFragmentActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

public class ShopInStoreActivity extends SingleFragmentActivity {

  private static final String TAG = "ShopInStoreActivity";
  public static final String SKU_WORDPAL = "SKU_WORDPAL";
  static final int RC_REQUEST = 10002;
  private DatabaseManager databaseManager;

  IabHelper iabHelper;

  @Override
  protected void onCreate(Bundle arg) {
    super.onCreate(arg);
    databaseManager = new DatabaseManager(this);

    String base64EncodedPublicKey = "TEMPORARY_TEXT";
    Log.d(TAG, "Creating IAB helper.");
    iabHelper = new IabHelper(this, base64EncodedPublicKey);

    // Remember to disable logging for production.
    iabHelper.enableDebugLogging(true);

    Log.d(TAG, "iabHelper starting setup.");
    iabHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
      @Override
      public void onIabSetupFinished(IabResult result) {
        Log.d(TAG, "iabHelper setup finished.");

        if (!result.isSuccess()) {
          complain("Problem setting up in-app billing: " + result);
          return;
        }
        // Have we been disposed of in the meantime? if so, quit.
        if (iabHelper == null) return;

        // IAB is fully set up. Now, let's get an inventory of stuff we own.
        Log.d(TAG, "Setup successful. Querying inventory.");
        iabHelper.queryInventoryAsync(gotInventoryListener);
      }
    });
  }

  @Override
  protected Fragment createFragment() {
    return new ShopInStoreFragment();
  }

  public void viewCollection(View v) {
    Intent i = new Intent(this, ViewCollectionActivity.class);
    i.putExtra(ViewCollectionFragment.COLLECTION_NAME, (String) v.getTag());
    startActivity(i);
  }

  public void buyCollection(View v) {
    WordCollection alreadyExist = databaseManager.selectCollection((String) v.getTag());
    if (alreadyExist != null) {
      alert("This collection already exist.");
    }
    else {
      Log.d(TAG, "Launching purchase flow for buying new WordCollection.");
      String payload = (String) v.getTag();

      iabHelper.launchPurchaseFlow(this, SKU_WORDPAL, RC_REQUEST, purchaseFinishedListener, payload);
    }
  }

  // Listener that's called when we finsih querying the items and subscriptions we own
  IabHelper.QueryInventoryFinishedListener gotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
    @Override
    public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
      Log.d(TAG, "Query inventory finished.");

      // Have we been disposed of in the meantime? if so, quit.
      if (iabHelper == null) return;

      if (result.isFailure()) {
        complain("Failed to query inventory: " + result);
        return;
      }

      Log.d(TAG, "Query inventory was successful.");

      // Check for unused paid WordCollection
      Purchase wcPurchase = inventory.getPurchase(SKU_WORDPAL);
      if (wcPurchase != null && getDeveloperPayload(wcPurchase) != null) {
        Log.d(TAG, "We have unused payment. Let's consuming it.");
        iabHelper.consumeAsync(inventory.getPurchase(SKU_WORDPAL), consumeFinishedListener);
      }
      Log.d(TAG, "Initial inventory query finished.");
    }
  };

  IabHelper.OnConsumeFinishedListener consumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
    public void onConsumeFinished(Purchase purchase, IabResult result) {
      Log.d(TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);

      // if we were disposed of in the meantime, quit.
      if (iabHelper == null) return;

      // We know this is the SKU_WORDPAL, so we don't check which sku was consumed.
      if (result.isSuccess()) {
        // successfully consumed, so we insert corresponded collection to database.
        WordCollection wc = WordCollectionsInMemory.get(getDeveloperPayload(purchase));
        if (wc == null) {
          complain("Collection not found, sorry."); // This really should not happen!
        }
        else {
          databaseManager.insertCollection(wc);
          alert("Collection ["+ wc.name() +"] stored in your phone.");
        }
      }
      else {
        complain("Error while consuming: " + result);
      }
      Log.d(TAG, "End consumption flow.");
    }
  };

  // Callback for when purchase is finished
  IabHelper.OnIabPurchaseFinishedListener purchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
    public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
      Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);

      // if we were disposed of in the meantime, quit.
      if (iabHelper == null) return;

      if (result.isFailure()) {
        complain("Error purchasing: " + result);
        return;
      }
      if (getDeveloperPayload(purchase) == null) {
        complain("Error purchasing. Authenticity verification failed.");
        return;
      }

      Log.d(TAG, "Purchase successful.");

      if (purchase.getSku().equals(SKU_WORDPAL)) {
        Log.d(TAG, "Purchase is SKU_WORDPAL. Starting consumption.");
        iabHelper.consumeAsync(purchase, consumeFinishedListener);
      }
    }
  };

  // We're being destroyed. It's important to dispose of the helper here!
  public void onDestroy() {
    super.onDestroy();

    // very important:
    Log.d(TAG, "Destroying helper.");
    if (iabHelper != null) {
      iabHelper.dispose();
      iabHelper = null;
    }
  }

  private String getDeveloperPayload(Purchase p) {
    String payload = p.getDeveloperPayload();
    if (payload.trim().length() == 0) {
      return null;
    }
    return payload;
  }

  void complain(String message) {
    Log.e(TAG, "**** ShopInStore Error: " + message);
    alert("Error: " + message);
  }

  void alert(String message) {
    AlertDialog.Builder bld = new AlertDialog.Builder(this);
    bld.setMessage(message);
    bld.setNeutralButton("OK", null);
    bld.create().show();
  }

}