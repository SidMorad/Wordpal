package mars.wordpal.infrastructure;

import java.util.ArrayList;
import java.util.TreeSet;

import mars.wordpal.application.comparator.WordComparator;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;

public class WordCollectionsInMemory {

  public static WordCollection get(String collectionName) {
    for (WordCollection wc : originalCollections()) {
      if (wc.name().equalsIgnoreCase(collectionName)) {
        return wc;
      }
    }
    return null;
  }

  public static ArrayList<WordCollection> originalCollections() {
    ArrayList<WordCollection> originalCollections = new ArrayList<WordCollection>();
    originalCollections.add(wordTrainerLesson1());
    originalCollections.add(wordTrainerLesson2());
    originalCollections.add(wordTrainerLesson3());
    originalCollections.add(wordTrainerLesson4());
    originalCollections.add(wordTrainerLesson5());
    originalCollections.add(wordTrainerLesson6());
    originalCollections.add(wordTrainerLesson7());
    originalCollections.add(wordTrainerLesson8());
    originalCollections.add(wordTrainerLesson9());
    originalCollections.add(wordTrainerLesson10());
    originalCollections.add(wordTrainerLesson11());
    originalCollections.add(wordTrainerLesson12());
    originalCollections.add(wordTrainerLesson13());
    originalCollections.add(wordTrainerLesson14());
    originalCollections.add(wordTrainerLesson15());
    originalCollections.add(wordTrainerLesson16());
    originalCollections.add(wordTrainerLesson17());
    originalCollections.add(wordTrainerLesson18());
    originalCollections.add(wordTrainerLesson19());
    return originalCollections;
  }

  public static WordCollection wordTrainerLesson19() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Do you have a new kitchen?", "Hast du eine neue Küche?", "آیا آشپزخانه شما جدید است؟", 0));
    w.add(new Word("What do you want to cook today?", "Was willst du heute kochen?", "امروز می‌خواهی چی بپزی؟", 0));
    w.add(new Word("Do you cook on an electric or a gas stove?", "Kochst du elektrisch oder mit Gas?", "با اجاق الکترونیکی آشپزی می‌کنی یا گازی؟", 0));
    w.add(new Word("Shall I cut the onions?", "Soll ich die Zwiebeln abschneiden?", "باید پیازها رو خرد کنم؟", 0));
    w.add(new Word("Shall I peel the potatoes?", "Soll ich die Kartoffeln schälen?", "باید سیب‌زمینی رو پست بکنم؟", 0));
    w.add(new Word("Shall I wash the lettuce?", "Soll ich den Salat waschen?", "باید کاهو رو بشویم؟", 0));
    w.add(new Word("Where are the glasses?", "Wo sind die Gläsern?", "لیوان‌ها کجا هستند؟", 0));
    w.add(new Word("Where are the dishes?", "Wo ist das Geschirr?", "ظروف کجا هستند؟", 0));
    w.add(new Word("Where is the kinfe?", "Wo ist der kinfe?", "چاقو کجاست؟", 0));
    w.add(new Word("Do you have a can opener?", "Hast du einen Dose Öffner?", "آیا دربازکن قوطی داری؟", 0));
    w.add(new Word("Do you have a bottle opener?", "Hast du einen Flaschenöffner?", "آیا دربازکن بطری داری؟", 0));
    w.add(new Word("Do you have a pot?", "Hast du einen Topf?", "آیا قابلمه داری؟", 0));
    w.add(new Word("Are you cooking the soup in this pot?", "Kochst du die Suppe in diesem Topf?", "آیا سوپ را در قابلمه می‌پزی؟", 0));
    w.add(new Word("Are you frying the fish in this pan?", "Braten Sie den Fisch in dieser Pfanne?", "آیا ماهی را در ماهی‌تابه سرخ می‌کنی؟", 0));
    w.add(new Word("Are you grilling the vegetables on this grill ?", "Grillst du das Gemüse auf diesem Grill?", "آی سبزیجات را در ماهی‌تابه سرخ می‌کنی؟", 0));
    w.add(new Word("I am setting the table.", "Ich setze den Tisch.", "من میز را می‌چینم.", 0));
    w.add(new Word("Here are the knives, the forks and the spoons.", "Hier sind die Messer, die Gabeln und die Löffel.", "اینجا چاقو، چنگال و قاشق هستند", 0));
    w.add(new Word("Here are the glasses, the plates and the napkins.", "Hier sind die Gläse, die Teller und die Servientten.", "اینجا لیوان‌ها، بشقاب‌ها و دستمال‌سفره هستند.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 19: In the kitchen - In der Küche", w, true);
  }

  public static WordCollection wordTrainerLesson18() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Today is Saturday.", "Heute ist Samstag.", "امروز شنبه است.", 0));
    w.add(new Word("We have time today.", "Heute haben wir Zeit.", "ما امروز زمان داریم.", 0));
    w.add(new Word("We are cleaning the apartment today.", "Heute putzen wir die Wohnung.", "ما امروز آپارتمان رو تمیز می‌کنیم.", 0));
    w.add(new Word("I am cleaning the bathroom.", "Ich putze das Badezimmer.", "من حمام رو تمیز می‌کنم.", 0));
    w.add(new Word("My husband is washing the car.", "Mein mann wäscht das Auto.", "شوهر من در حال شستن ماشین است.", 0));
    w.add(new Word("The children are cleaning the bicycles.", "Die Kinder putzen die Fahrräder.", "بچه‌ها در حال شستن دوچرخه‌ها هستند.", 0));
    w.add(new Word("Grandma is watering the flowers.", "Oma Gießt die Blumen.", "مادر بزرگ به گل‌ها آب می‌دهد.", 0));
    w.add(new Word("The children are cleaning up the children-s room.", "Die Kinder Reinigung das Kinderzimmer auf.", "بچه‌ها در حال تمیز کردن اتاقشون هستند.", 0));
    w.add(new Word("My husband is tidying up his desk.", "Mein Mann fräumen seinen Schreibtisch auf.", "شوهر من در حال مرتب کردن میزش است.", 0));
    w.add(new Word("I am putting the laundry in the washing machine.", "Ich setze die Wäsche in der Waschmaschine.", "من در حال گذاشتن لباس‌های در ماشین لباسشویی هستم.", 0));
    w.add(new Word("I am hanging up the laundry.", "Ich hänge die Wäsche auf.", "من لباس‌ها را آویزان می‌کنم.", 0));
    w.add(new Word("I am ironing the cloths.", "Ich bügle die Wäsche.", "من لباس‌ها را اتو می‌کنم.", 0));
    w.add(new Word("The windows are dirty.", "Die Fenster sind schmutzig.", "پنجره‌ها کثیف هستند.", 0));
    w.add(new Word("The floor is dirty.", "Der Fußboden ist schmutzig.", "طبقه کثیف است.", 0));
    w.add(new Word("The dishes are dirty.", "Das Geschirr ist schmutzig.", "ظرف‌ها کثیف هستند.", 0));
    w.add(new Word("Who washes the windows?", "Wer putzt die Fenster?", "چه کسی پنجره‌ها رو پاک می‌کند؟", 0));
    w.add(new Word("Who does the vacuuming?", "Wer saugt staub?", "چه کسی جارو می‌کشد؟", 0));
    w.add(new Word("Who does the dishes?", "Wer tut Das Geschirr?", "چه کسی ظرف‌ها رو پاک می‌کند؟", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 18: House cleaning - Hausputz", w, true);
  }

  public static WordCollection wordTrainerLesson17() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Our house is here.", "Hier ist unser Haus.", "خانه ما اینجاست.", 0));
    w.add(new Word("The roof is on top.", "Oben ist das Dach.", "سقف آن بالا است.", 0));
    w.add(new Word("The basement is below.", "Unten ist der Keller.", "زیرزمین پایین است.", 0));
    w.add(new Word("There is a garden behind the house.", "Hinter dem hause ist ein Garten.", "پشت خانه یک باغچه هست..", 0));
    w.add(new Word("There is no street in front of the house.", "Vor dem Haus ist keine Straße.", "در جلوی خانه هیچ خیابانی نیست.", 0));
    w.add(new Word("There are trees next to the house.", "Neben dem Haus sind Bäume.", "درخت‌ها در کنار خانه هستند.", 0));
    w.add(new Word("My apartment is here.", "Hier ist meine Wohnung.", "آپارتمان من در اینجاست.", 0));
    w.add(new Word("The kitchen and bathroom are here.", "Hier sind die Küche und das Bad.", "آشپزخانه و حمام اینجا هستند. ", 0));
    w.add(new Word("The living room and bedroom are here.", "Dort sind Das Wohnzimmer und Das Schlafzimmer. ", "اتاق نشیمن و اتاق خواب اینجا هستند.", 0));
    w.add(new Word("The front door is closed.", "Die Haus tür ist geschlossen.", "در جلویی بسته است.", 0));
    w.add(new Word("But the windows are open.", "Aber die Fenster sind offen.", "اما پنجره‌ها باز هستند.", 0));
    w.add(new Word("It is hot today.", "Es ist heiß heute.", "امروز هوا خیلی گرم است. ", 0));
    w.add(new Word("We are going to the living room.", "Wir gehen im das Wohnzimmer.", "ما در حال رفتن به اتاق نشیمن هستیم.", 0));
    w.add(new Word("There is a sofa and an armchair there.", "Dort sind ein Sofa und ein Sessel.", "آنجا یک مبل و صندلی راحتی وجود دارد.", 0));
    w.add(new Word("Please sit down.", "Setzen Sie sich bitte.", "لطفا بشینید.", 0));
    w.add(new Word("My computer is there.", "Mein Computer ist dort.", "کامپیوتر من آنجاست.", 0));
    w.add(new Word("My stereo is there.", "Meine Stereo ist dort.", "استریو من آنجاست.", 0));
    w.add(new Word("The TV set is brand new.", "Der Fernseher ist ganz neu.", "تلویزیون جدید است. ", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 17: Around the house - Im Haus", w, true);
  }

  public static WordCollection wordTrainerLesson16() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("These are the seasons:", "Das sind die Jahreszeiten:", "اینها فصل‌ها هستند:", 0));
    w.add(new Word("Spring, summer", "Der Frühling, der Sommer", "بهار، تابستان", 0));
    w.add(new Word("autumn and winter", "der Herbst und der Winter.", "پاییز، زمستان", 0));
    w.add(new Word("The summer is warm.", "Der Sommer ist warm.", "تابستان گرم است.", 0));
    w.add(new Word("The sun shines in summer.", "Im Sommer scheint die Sonne.", "خورشید در تابستان می‌درخشد.", 0));
    w.add(new Word("We like to go for a walk in summer.", "Im Sommer wir gehen gern Spaziergang.", "در تابستان ما دوست داریم قدم بزنیم. ", 0));
    w.add(new Word("The winter is cold.", "Der Winter ist kalt.", "زمستان سرد است.", 0));
    w.add(new Word("It snows or rains in winter.", "Im Winter schneit oder regnet es.", "در زمستان برف یا باران می‌بارد.", 0));
    w.add(new Word("We like stay at home in winter.", "Im Winter bleiben Wir gern zu Hause.", "در زمستان ما دوست داریم در خانه بمانیم.", 0));
    w.add(new Word("It is cold.", "Es ist kalt.", "سرد است.", 0));
    w.add(new Word("It is raining.", "Es regnet.", "بارانی است.", 0));
    w.add(new Word("It is windy.", "Es ist windig.", "بادی است.", 0));
    w.add(new Word("It is warm.", "Es ist warm.", "گرم است.", 0));
    w.add(new Word("It is sunny.", "Es ist sonnig.", "آفتابی است.", 0));
    w.add(new Word("It is pleasant.", "Es ist angenehm.", "خوشایند است.", 0));
    w.add(new Word("What is the weather like today?", "Wie ist das Wetter heute?", "هوا امروز چطوره؟", 0));
    w.add(new Word("It is cold today.", "Es ist kalt heute.", "امروز سرد است.", 0));
    w.add(new Word("It is warm today.", "Es ist warm heute.", "امروز گرم است.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 16: Seasons and Weather - Jahreszeiten und Wetter", w, true);
  }

  public static WordCollection wordTrainerLesson15() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("I have a strawberry.", "Ich habe eine Erdbeere.", "من یک توت‌فرنگی دارم.", 0));
    w.add(new Word("I have a kiwi and a melon.", "Ich habe eine Kiwi und eine Melone.", "من یک کیوی و یک خربزه دارم. ", 0));
    w.add(new Word("I have an orange and a grapefruit.", "Ich habe eine Orange und eine Grapefruit.", "من یک پرتقال و یک گریپ‌فروت دارم.", 0));
    w.add(new Word("I have an apple and a mango.", "Ich habe einen Apfel und eine Mango.", "من یک سیب و یک انبه دارم. ", 0));
    w.add(new Word("I have a banana and a pineapple.", "Ich habe eine Banane und eine Ananas.", "من یک موز و یک آناناس دارم.", 0));
    w.add(new Word("I am making a fruit salad.", "Ich mache einen Obst Salat.", "من دارم سالاد میوه درست می‌کنم.", 0));
    w.add(new Word("I am eating toast.", "Ich esse einen Toast.", "من نان تست می‌خورم.", 0));
    w.add(new Word("I am eating toast with butter.", "Ich esse einen Toast mit Butter.", "من نان تست با کره می‌خورم.", 0));
    w.add(new Word("I am eating toast with butter and jam.", "Iche esse einen Toast mit Butter und Marmelade.", "من نان تست با کره و مربا می‌خورم.", 0));
    w.add(new Word("I am eating a sandwich.", "Ich esse ein Sandwich.", "من در حال خوردن ساندویج هستم.", 0));
    w.add(new Word("I am eating a sandwich with margarine.", "Ich esse ein Sandwich mit Margarine.", "من در حال خوردن ساندویج با مارگارین هستم. ", 0));
    w.add(new Word("I am eating a sandwich with margarine and tomatoes.", "Ich esse ein Sandwich mit Margarine und Tomaten.", "من در حال خوردن ساندویج با مارگارین و گوجه هستم", 0));
    w.add(new Word("We need bread and rice.", "Wir brauchen Brot und Reis.", "ما نان و برنج نیاز داریم.", 0));
    w.add(new Word("We need fish and steaks.", "Wir brauchen fisch und Steaks.", "ما ماهی و استیک نیاز داریم. ", 0));
    w.add(new Word("We need pitza and spaghetti.", "Wir brauchen pitza und spagetti.", "ما پیتزا و ماکارونی نیاز داریم. ", 0));
    w.add(new Word("What else do we need?", "Was brauchen wir noch?", "ما چه چیز دیگری نیاز داریم؟", 0));
    w.add(new Word("We need carrots and tomatoes for the soup.", "Wir brauchen Karotten und Tomaten für die Suppe.", "ما به هویج و گوجه برای سوپ نیاز داریم.", 0));
    w.add(new Word("Where is the supermarket?", "Wo ist ein Supermarkt?", "سوپرمارکت کجاست؟", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 15: Fruits and food - Früchte und Lebensmittel", w, true);
  }

  public static WordCollection wordTrainerLesson14() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Snow is white.", "Der Schnee ist weiß.", "برف سفید است.", 0));
    w.add(new Word("The sun is yellow.", "Die Sonne ist gelb.", "خورشید زرد است.", 0));
    w.add(new Word("The orange is orange.", "Die Orange is orange.", "پرتقال نارنجی است.", 0));
    w.add(new Word("The cherry is red.", "Die Kirsche ist rot.", "گیلاس قرمز است.", 0));
    w.add(new Word("The sky is blue.", "Der Himmel ist blau.", "آسمان آبی است.", 0));
    w.add(new Word("The grass is green.", "Das Gras ist grün.", "چمن سبز است.", 0));
    w.add(new Word("The earth is brown.", "Die Erde ist braun.", "زمین قهوه‌ای است.", 0));
    w.add(new Word("The cloud is gray.", "Die Wolke ist grau.", "ابر خاکستری است.", 0));
    w.add(new Word("The tires are black.", "Die Gummireifen sind schwarz.", "لاستیک‌ها سیاه هستند.", 0));
    w.add(new Word("What color is the snow? White", "Welche Farbe hat der Shnee? Weiß", "برف چه رنگی است؟ سفید", 0));
    w.add(new Word("What color is the sun? Yellow", "Welche Farbe hat die Sonne? Gelb", "خورشید چه رنگی است؟ زرد", 0));
    w.add(new Word("What color is the oragne? Orange", "Welche Farbe hat die orange? Orange", "پرتقال چه رنگی است؟ نارنجی", 0));
    w.add(new Word("What color is cherry? Red", "Welche Farbe hat die Kirsche? Rot", "گیلاس چه رنگی است؟ قرمز", 0));
    w.add(new Word("What color is the sky? Blue", "Welche Farbe hat der Himmel? Blau", "آسمان چه رنگی است؟ آبی", 0));
    w.add(new Word("What color is the grass? Green", "Welche Farbe hat das Gras? Grün", "چمن چه رنگی است؟ سبز", 0));
    w.add(new Word("What color is the earth? Brown", "Welche Farbe hat die Erde? Braun", "زمین چه رنگی است؟ قهوه‌ای", 0));
    w.add(new Word("What color is the cloud? Gray", "Welche Farbe hat die Wolke? Grau", "ابر چه رنگی است؟ خاکستری", 0));
    w.add(new Word("What color are the tires? Black", "Welche Farbe haben die Gummireifen? Schwarz", "لاستیک‌های اتومبیل چه رنگی هستند؟ سیاه", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 14: Colors - Farben", w, true);
  }

  public static WordCollection wordTrainerLesson13() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("What does Martha do?", "Was macht Martha?", "مارتا چه کاری انجام می‌دهد؟", 0));
    w.add(new Word("She works at an office.", "Sie arbeitet im Büro.", "مارتا در اداره کار می‌کند.", 0));
    w.add(new Word("She works on the computer.", "Sie arbeitet am Computer.", "او با کامپیوتر کار می‌کند.", 0));
    w.add(new Word("Where is Martha?", "Wo ist Martha?", "مارتا کجاست؟", 0));
    w.add(new Word("At the cinema.", "Ins Kino", "در سینما", 0));
    w.add(new Word("She is watching a film.", "Sie beobacktet einen Film.", "او در حال تماشای فیلم است.", 0));
    w.add(new Word("What does Peter do?", "Was macht Peter?", "پیتر چه کاری انجام می‌دهد؟", 0));
    w.add(new Word("He studies at the university.", "Er studiert an der Universität.", "او در دانشگاه تحصیل می‌کند.", 0));
    w.add(new Word("He studies languages.", "Er studiert Sprachen.", "او در رشته زبان‌ها تحصیل می‌کند.", 0));
    w.add(new Word("Where is Peter?", "Wo ist Peter?", "پیتر کجاست؟", 0));
    w.add(new Word("At the café.", "Im café.", "در کافه.", 0));
    w.add(new Word("He is drinking coffee.", "Er trinkt Kaffee.", "او در حال نوشیدن قهوه می‌باشد.", 0));
    w.add(new Word("Where do they like to go?", "Wohin gehen sie gern?", "آنها کجا دوست دارن بروند؟", 0));
    w.add(new Word("To a concert.", "Ins Konzert.", "به کنسرت", 0));
    w.add(new Word("They like to listen to music.", "Sie hören gern Musik.", "آنها دوست دارند به موزیک گوش بدهند.", 0));
    w.add(new Word("Where do they not like to go?", "Wohin gehen sie nicht gern?", "آنها به چه جاهایی دوست ندارند بروند؟", 0));
    w.add(new Word("To the disco.", "In die Disko", "به دیسکو", 0));
    w.add(new Word("They do not like to dance.", "Sie tanzen nicht gern.", "آنها به رقصیدن تمایل ندارند.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 13: Activities - Tätigkeiten", w, true);
  }

  public static WordCollection wordTrainerLesson12() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("I drink tea.", "Ich trinke Tee.", "من چای می‌نوشم.", 0));
    w.add(new Word("I drink coffee.", "Ich trinke Kaffee.", "من قهوه می‌نوشم.", 0));
    w.add(new Word("I drink mineral water.", "Ich trinke Mineralwasser.", "من آب معدنی می‌نوشم.", 0));
    w.add(new Word("Do you drink tea with lemon?", "Trinkst du Tee mit Zitrone?", "آیا شما چای رو با لیمو می‌نوشید؟", 0));
    w.add(new Word("Do you drink coffee with sugar?", "Trinkst du Kaffee mit Zucker?", "آیا شما قهوه رو با شکر می‌نوشید؟", 0));
    w.add(new Word("Do you drink watter with ice?", "Trinkst du wasser mit Eis?", "آیا شما آب رو با یخ می‌نوشید؟", 0));
    w.add(new Word("There is a party here.", "Hier ist eine Partei.", "اینجا یک جشن داریم.", 0));
    w.add(new Word("People are drinking champagne.", "Die Leute trinken Sekt.", "افراد در حال نوشیدن شامپاین هستند.", 0));
    w.add(new Word("People are drinking wine and beer.", "Die Leute trinken Wein und Bier.", "افراد در حال نوشیدن شراب و آبجو هستند.", 0));
    w.add(new Word("Do you drink alcohol?", "Trinkst du Alkohol?", "آیا شما نوشیدنی الکلی می‌نوشید؟", 0));
    w.add(new Word("Do you drink whisky?", "Trinkst du Whisky?", "آیا شما ویسکی می‌نوشید؟", 0));
    w.add(new Word("Do you drink cock with rum?", "Trinkst du kola mit rum?", "آیا شما کوک با رام می‌نوشید؟", 0));
    w.add(new Word("I do not like champagne.", "Ich mag Sekt nicht.", "من شامپاین دوست ندارم.", 0));
    w.add(new Word("I do not like wine.", "Ich mag Wein nicht.", "من شراب دوست ندارم.", 0));
    w.add(new Word("I do not like beer.", "Ich mag Bier nicht.", "من آبجو دوست ندارم.", 0));
    w.add(new Word("The baby likes milk.", "Das Baby mag Milch.", "کودک شیر دوست دارد.", 0));
    w.add(new Word("The child likes cocoa and apple juice.", "Das Kind mag Kakao und Apfel saft.", "بچه کاکائو و آب سیب دوست دارد.", 0));
    w.add(new Word("The woman likes orange and grapefruit juice.", "Die Frau mag Orangen saft und Grapefruit saft.", "آن خانم آب پرتقال و گریپ‌فروت دوست دارد. ", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 12: Beverages - Getränke", w, true);
  }

  public static WordCollection wordTrainerLesson11() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("January", "der Januar", "ژانویه", 0));
    w.add(new Word("February", "der Februar", "فوریه", 0));
    w.add(new Word("March", "der März", "مارس", 0));
    w.add(new Word("April", "der April", "آوریل", 0));
    w.add(new Word("May", "der Mai", "می", 0));
    w.add(new Word("June", "der Juni", "ژوئن", 0));
    w.add(new Word("These are six months.", "Diese sind sechs Monate.", "اینها شش ماه هستند.", 0));
    w.add(new Word("January, February, March", "Januar, Februar, März", "ژانویه، فوریه، مارس", 0));
    w.add(new Word("April, May, June", "April, Mai, Juni", "آوریل، می، ژوئن", 0));
    w.add(new Word("July", "der Juli", "جولای", 0));
    w.add(new Word("August", "der August", "آگوست", 0));
    w.add(new Word("September", "der September", "سپتامبر", 0));
    w.add(new Word("October", "der Oktober", "اکتبر", 0));
    w.add(new Word("November", "der November", "نوامبر", 0));
    w.add(new Word("December", "der Dezember", "دسامبر", 0));
    w.add(new Word("These are also six months.", "Diese sind auch sechs Monate.", "اینها هم شش ماه هستند.", 0));
    w.add(new Word("July, August, September", "Juli, August, September", "جولای، آگوست، سپتامبر", 0));
    w.add(new Word("October, November, December", "Oktober, November, Dezember", "اکتبر، نوامبر، دسامبر", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 11: Months - Monate", w, true);
  }

  public static WordCollection wordTrainerLesson10() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Yesterday was Saturday.", "Gestern war Samstag.", "دیروز شنبه بود.", 0));
    w.add(new Word("I was at the cinema yesterday.", "Gestern war ich im Kino.", "دیروز من در سینما بودم.", 0));
    w.add(new Word("The film was interesting.", "Der Film war interessant.", "فیلمش جالب بود.", 0));
    w.add(new Word("Today is Sunday.", "Heute ist Sonntag.", "امروز یکشنبه است.", 0));
    w.add(new Word("I am not working today.", "Heute arbeite ich nicht.", "من امروز کار نمی‌کنم.", 0));
    w.add(new Word("I am staying at home.", "Ich bleibe zu Hause.", "من در خانه می‌مانم.", 0));
    w.add(new Word("Tomorrow is Monday.", "Morgen ist Montag.", "فردا دوشنبه است.", 0));
    w.add(new Word("Tomorrow I will work again.", "Morgen arbeite ich wieder.", "من دوباره فردا کار می‌کنم.", 0));
    w.add(new Word("I work at an office.", "Ich arbeite im Büro.", "من در دفتر کار می‌کنم.", 0));
    w.add(new Word("Who is that?", "Wer ist das?", "اون کیه؟", 0));
    w.add(new Word("That is Peter.", "Das ist Peter.", "آن پیتر است.", 0));
    w.add(new Word("Peter is a student.", "Peter ist Student.", "پیتر یک دانش‌آموز است.", 0));
    w.add(new Word("That is Martha.", "Das ist Martha.", "آن مارتا است.", 0));
    w.add(new Word("Martha is a secretary.", "Martha ist Sekretärin.", "مارتا یک منشی است.", 0));
    w.add(new Word("Peter and Martha are friends.", "Peter und Martha sind Freunde.", "پیتر و مارتا با هم دوست هستند.", 0));
    w.add(new Word("Peter is Martha-s friend.", "Peter ist der Freund von Martha.", "پیتر دوست مارتا است.", 0));
    w.add(new Word("Martha is Peter-s friend.", "Martha ist die Freundin von Peter.", "مارتا دوست پیتر است.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 10: Yesterday, today, tomorrow - Gestern, heute, morgen", w, true);
  }

  public static WordCollection wordTrainerLesson9() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Monday", "der Montag", "دوشنبه", 0));
    w.add(new Word("Tuesday", "der Dienstag", "سه‌شنبه", 0));
    w.add(new Word("Wednesday", "der Mittwoch", "چهارشنبه", 0));
    w.add(new Word("Thursday", "der Donnerstag", "پنجشنبه", 0));
    w.add(new Word("Friday", "der Freitag", "جمعه", 0));
    w.add(new Word("Saturday", "der Samstag", "شنبه", 0));
    w.add(new Word("Sunday", "der Sonntag", "یکشنبه", 0));
    w.add(new Word("the week", "die Woche", "هفته", 0));
    w.add(new Word("from Monday to Sunday", "von Montag bis Sonntag", "از دوشنبه تا یک‌شنبه", 0));
    w.add(new Word("The first day is Monday.", "Der erste Tag ist Montag.", "دوشنبه روز اول است.", 0));
    w.add(new Word("The second day is Tuesday.", "Der zweite Tag ist Dienstag.", "سه‌‌شنبه روز دوم است.", 0));
    w.add(new Word("The third day is Wednesday.", "Der dritte Tag ist Mittwoch.", "چهارشنبه روز سوم است.", 0));
    w.add(new Word("The fourth day is Thursday.", "Der vierte Tag ist Donnerstag.", "پنجشنبه روز چهارم است.", 0));
    w.add(new Word("The fifth day is Friday.", "Der fünfte Tag ist Freitag.", "جمعه روز پنجم است.", 0));
    w.add(new Word("The sixth day is Saturday.", "Der sechste Tag ist Samstag.", "شنبه روز ششم است.", 0));
    w.add(new Word("The seventh day is Sunday.", "Der siebte Tag ist Sonntag.", "یکشنبه روز هفتم است.", 0));
    w.add(new Word("The week has seven days.", "Die Woche hat sieben Tage.", "یک هفته هفت روز دارد.", 0));
    w.add(new Word("We only work for five days.", "Wir arbeiten nur fünf Tage.", "ما فقط برای پنج روز کار می‌کنیم.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 9: Days of the week - Wochentage", w, true);
  }

  public static WordCollection wordTrainerLesson8() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Excuse me!", "Entschuldigen Sie!", "ببخشید!", 0));
    w.add(new Word("What time is it, please?", "Wie viel Uhr ist es, bitte?", "ساعت چند است، لطفا؟", 0));
    w.add(new Word("Thank you very much.", "Danke vielmals.", "خیلی ممنونم.", 0));
    w.add(new Word("It is one o'clock.", "Es ist ein Uhr.", "ساعت یک است.", 0));
    w.add(new Word("It is two o'clock.", "Es ist zwei Uhr.", "ساعت دو است.", 0));
    w.add(new Word("It is three o'clock.", "Es ist drei Uhr.", "ساعت سه است.", 0));
    w.add(new Word("It is four o'clock.", "Es ist vier Uhr.", "ساعت چهار است.", 0));
    w.add(new Word("It is five o'clock.", "Es ist fünf Uhr.", "ساعت پنج است.", 0));
    w.add(new Word("It is six o'clock.", "Es ist sechs Uhr.", "ساعت شش است.", 0));
    w.add(new Word("It is seven o'clock.", "Es ist sieben Uhr.", "ساعت هفت است.", 0));
    w.add(new Word("It is eight o'clock.", "Es ist acht Uhr.", "ساعت هشت است.", 0));
    w.add(new Word("It is nine o'clock.", "Es ist neun Uhr.", "ساعت نه است.", 0));
    w.add(new Word("It is ten o'clock.", "Es ist zehn Uhr.", "ساعت ده است.", 0));
    w.add(new Word("It is eleven o'clock.", "Es ist elf Uhr.", "ساعت یازده است.", 0));
    w.add(new Word("It is twelve o'clock.", "Es ist zwölf Uhr.", "ساعت دوازده است.", 0));
    w.add(new Word("A minute has sixty seconds.", "Eine Minute hat sechzig Sekunden.", "هر دقیقه شصد ثانیه دارد.", 0));
    w.add(new Word("An hour has sixty minutes.", "Eine Stunde hat sechzig Minuten.", "هر ساعت شصد دقیقه دارد.", 0));
    w.add(new Word("A day has twenty-four hours.", "Ein Tag hat vierundzwanzig Stunden.", "هر روز بیست و چهار ساعت دارد.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 8: The time - Uhrzeiten", w, true);
  }

  public static WordCollection wordTrainerLesson7() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("I count:", "Ich zähle:", "من می‌شمرم.", 0));
    w.add(new Word("one, two, three", "eins, zwei, drei", "یک، دو، سه", 0));
    w.add(new Word("I count to three", "Ich zähle bis drei.", "من تا سه می‌شمرم.", 0));
    w.add(new Word("I count further:", "Ich  zähle weiter:", "من بیشتر می‌شمرم.", 0));
    w.add(new Word("four, five, six,", "vier, fünf, sechs,", "چهار، پنج، شش", 0));
    w.add(new Word("seven, eight, nine", "sieben, acht, neun", "هفت، هشت، نه", 0));
    w.add(new Word("You count.", "Du zählst.", "تو می‌شماری.", 0));
    w.add(new Word("He counts.", "Er zählt.", "او می‌شمارد.", 0));
    w.add(new Word("One. The first.", "Eins. Der Erste.", "یک. اول.", 0));
    w.add(new Word("Two. The second.", "Zwei. Der Zweite.", "دو. دوم.", 0));
    w.add(new Word("Three. The third.", "Drei. Der Dritte.", "سه. سوم.", 0));
    w.add(new Word("Four. The fourth.", "Vier. Der Vierte.", "چهار. چهارم.", 0));
    w.add(new Word("Five. The fifth.", "Fünf. Der Fünfte.", "‍‍‍‍‍پنج. پنجم.", 0));
    w.add(new Word("Six. The sixth.", "Sechs. Der Sechste.", "شش. ششم.", 0));
    w.add(new Word("Seven. The seventh.", "Sieben. Der Siebte.", "هفت. هفتم.", 0));
    w.add(new Word("Eight. The eighth.", "Acht. Der Achte.", "هشت. هشتم.", 0));
    w.add(new Word("Nine. The ninth.", "Neun. Der Neunte.", "نه. نهم.", 0));
    return new WordCollection(0
      , "Wordtrainer Lesson 7: Numbers - Zahlen", w, true);
  }

  public static WordCollection wordTrainerLesson6() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("I read.", "Ich lese.", "من خواندم.", 0));
    w.add(new Word("I read a letter.", "Ich lese einen Buchstaben.", "من یک نامه خواندم.", 0));
    w.add(new Word("I read a word.", "Ich lese ein Wort.", "من یک کلمه خواندم.", 0));
    w.add(new Word("I read a sentence.", "Ich lese einen Satz.", "من یک جمله خواندم.", 0));
    w.add(new Word("I read a letter.", "Ich lese einen Brief.", "من یک نامه خواندم.", 0));
    w.add(new Word("I read a book.", "Ich lese ein Buch.", "من یک کتاب خواندم.", 0));
    w.add(new Word("You read.", "Du liest.", "تو خواندی.", 0));
    w.add(new Word("He reads.", "Er liest.", "او خواند.", 0));
    w.add(new Word("I write.", "Ich schreibe.", "من نوشتم.", 0));
    w.add(new Word("I write a letter.", "Ich schreibe einen Buchstaben.", "من یک نامه نوشتم.", 0));
    w.add(new Word("I write a word.", "Ich schreibe ein Wort.", "من یک کلمه نوشتم.", 0));
    w.add(new Word("I write a sentence.", "Ich schreibe einen Satz.", "من یک جمله نوشتم.", 0));
    w.add(new Word("I write a letter.", "Ich schreibe einen Brief.", "من یک نامه نوشتم.", 0));
    w.add(new Word("I write a book.", "Ich schreibe ein Buch.", "من یک کتاب نوشتم.", 0));
    w.add(new Word("You write.", "Du schreibst.", "تو نوشتی.", 0));
    w.add(new Word("He writes.", "Er schreibt.", "او نوشت.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 6: Reading and writing - Lesen und schreiben", w, true);
  }

  public static WordCollection wordTrainerLesson5() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("John is from London.", "John ist aus London.", "جان اهل لندن است", 0));
    w.add(new Word("London is in Great Britain.", "London liegt in Großbritannien.", "لندن در انگلستان کبیر است.", 0));
    w.add(new Word("He speaks English.", "Er spricht Englisch.", "او انگلیسی صحبت می‌کند.", 0));
    w.add(new Word("Maria is from Madrid.", "Maria ist aus Madrid.", "ماریا اهل مادرید است.", 0));
    w.add(new Word("Madrid is in Spain.", "Madrid liegt in Spanien.", "مادرید در اسپانیا است.", 0));
    w.add(new Word("She speaks Spanish.", "Sie spricht Spanisch.", "او اسپانیایی صحبت می‌کند.", 0));
    w.add(new Word("Peter and Martha are from Berlin.", "Peter und Martha sind aus Berlin.", "پیتر و مارتا اهل برلین هستند.", 0));
    w.add(new Word("Berlin is in Germany.", "Berlin liegt in Deutschland.", "برلین در آلمان است.", 0));
    w.add(new Word("Do both of you speak German?", "Sprecht ihr beide Deutsch?", "آیا هر دو شما آلمانی صحبت می‌کنید؟", 0));
    w.add(new Word("London is a capital city.", "London ist eine Hauptstadt.", "شهر لندن پایتخت است.", 0));
    w.add(new Word("Madrid and Berlin are also capital cities.", "Madrid und Berlin sind auch Hauptstädte.", "شهرهای مادرید و برلین هم پایتخت هستند.", 0));
    w.add(new Word("Capital cities are big and noisy.", "Die Hauptstädte sind groß und laut.", "شهرهای پایتخت بزرگ و پر سروصدا هستند.", 0));
    w.add(new Word("France is in Europe.", "Frankreich liegt in Europa.", "فرانسه در اروپا است.", 0));
    w.add(new Word("Egypt is in Africa.", "Ägypten liegt in Afrika.", "مصر در آفریقا است.", 0));
    w.add(new Word("Japan is in Asia", "Japan liegt in Asien.", "ژاپن در آسیا است.", 0));
    w.add(new Word("Canada is in North America.", "Kanada liegt in Nordamerika.", "کانادا در آمریکای شمالی است.", 0));
    w.add(new Word("Panama is in Central America.", "Panama liegt in Mittelamerika.", "پاناما در آمریکای مرکزی است.", 0));
    w.add(new Word("Brazil is in South America.", "Brasilien liegt in Südamerika.", "برزیل در آمریکای جنوبی است.", 0));
    return new WordCollection(0,
      "Wordtrainer Lessson 5: Countries and Languages - Länder und Sprachen", w, true);
  }
  public static WordCollection wordTrainerLesson4() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Where are we?", "Wo sind wir?", "ما کجاییم؟", 0));
    w.add(new Word("We are at school.", "Wir sind in der Schule.", "ما در مدرسه هستیم.", 0));
    w.add(new Word("We are having class/a lesson.", "Wir haben Unterricht.", "ما یک کلاس داریم", 0));
    w.add(new Word("Those are the school children.", "Das sind die Schüler.", "آنها بچه‌های مدرسه هستند. ", 0));
    w.add(new Word("That is the teacher", "Das ist die Lehrerin.", "آن یک معلم است.", 0));
    w.add(new Word("That is class.", "Das ist die Klasse.", "آن کلاس است.", 0));
    w.add(new Word("What are we doing?", "Was machen wir?", "ما چه کار می‌کنیم؟", 0));
    w.add(new Word("We are learning.", "Wir lernen.", "ما یاد می‌گیریم", 0));
    w.add(new Word("We are learning a language.", "Wir lernen eine Sprache.", "ما یک زبان یاد می‌گیریم.", 0));
    w.add(new Word("I learn English.", "Ich lerne Englisch.", "من انگلیسی یاد می‌گیرم.", 0));
    w.add(new Word("You learn Spanish.", "Du lernst Spanisch.", "تو اسپانیایی یاد می‌گیری.", 0));
    w.add(new Word("He learns German.", "Er lernt Deutsch.", "او آلمانی یاد می‌گیرد.", 0));
    w.add(new Word("We learn French.", "Wir lernen Französisch.", "ما فرانسه یاد می‌گیریم.", 0));
    w.add(new Word("You all learn Italian.", "Ihr lernt Italienisch.", "شما اتالیایی یاد می‌گیرید.", 0));
    w.add(new Word("They learn Russian.", "Sie lernen Russisch.", "آنها روسی یاد می‌گیرند.", 0));
    w.add(new Word("Learning languages is interesting.", "Sprachen lernen ist interessant.", "یادگیری زبان‌ها جالب است.", 0));
    w.add(new Word("We want to understand people.", "Wir wollen Menschen verstehen.", "ما می‌خواهیم مردم رو بفهمیم.", 0));
    w.add(new Word("We want to speak with people.", "Wir wollen mit Menschen sprechen.", "ما می‌خواهیم با مردم صحبت کنیم.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson4: At school - In der Schule", w, true);
  }

  public static WordCollection wordTrainerLesson3() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Hi!", "Hallo!", "سلام!", 0));
    w.add(new Word("Hello!", "Guten Tag!", "سلام!", 0));
    w.add(new Word("How are you?", "Wie geht's?", "چطوری؟", 0));
    w.add(new Word("Do you come from Europe?", "Kommen Sie aus Europa?", "شما از اروپا می‌آیید؟", 0));
    w.add(new Word("Do you come from America?", "Kommen Sie aus Amerika?", "شما از آمریکا می‌آیید؟", 0));
    w.add(new Word("Do you come from Asia?", "Kommen Sie aus Asien?", "شما از آسیا می‌آیید؟", 0));
    w.add(new Word("In which hotel are you staying?", "In welchem Hotel wohnen Sie?", "در کدام هتل اقامت دارید؟", 0));
    w.add(new Word("How long have you been here for?", "Wie lange sind Sie schon hier?", "چند وقته که اینجایید؟", 0));
    w.add(new Word("How long will you be staying?", "Wie lange bleiben Sie?", "چند وقت می‌خواهید اینجا بمانید؟", 0));
    w.add(new Word("Do you here on vacation?", "Machen Sie hier Urlaub?", "برای تعطیلات اینجا هستید؟", 0));
    w.add(new Word("Please do visit me sometime!", "Besuchen Sie mich mal!", "لطفا گاهی‌اوقات به دیدن من بیا!", 0));
    w.add(new Word("Here is my address.", "Hier ist meine Adresse.", "این آدرس من است.", 0));
    w.add(new Word("Shall we see each other tomorrow?", "Sehen wir uns morgen?", "فردا همدیگر رو ببینیم؟", 0));
    w.add(new Word("I am sorry, but I already have plans.", "Tut mir Leid, ich habe schon etwas vor.", "من متاسفم، برای فردا برنامه دیگری دارم.", 0));
    w.add(new Word("Bye!", "Tschüs!", "خداحافظ!", 0));
    w.add(new Word("Good bye!", "Auf Wiedersehen!", "خداحافظ!", 0));
    w.add(new Word("See you soon!", "Bis bald!", "زود می‌بینمت!", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson 3: Getting to know others - Kennen lernen", w, true);
  }

  public static WordCollection wordTrainerLesson2() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("the grandfather", "der Großvater", "پدربزرگ", 0));
    w.add(new Word("the grandmother", "die Großmutter", "مادربزرگ", 0));
    w.add(new Word("he and she", "er und sie", "او و او", 0));
    w.add(new Word("the father", "der Vater", "پدر", 0));
    w.add(new Word("the mother", "die Mutter", "مادر",0));
    w.add(new Word("the son", "der Sohn", "پسر", 0));
    w.add(new Word("the daughter", "die Tochter", "دختر", 0));
    w.add(new Word("the brother", "der Bruder", "برادر", 0));
    w.add(new Word("the sister", "die Schwester", "خواهر", 0));
    w.add(new Word("the uncle", "der Onkel","دایی یا عمو", 0));
    w.add(new Word("the aunt", "die Tante", "خاله یا عمه", 0));
    w.add(new Word("We are a family", "Wir sind eine Familie", "ما یک خانواده هستیم", 0));
    w.add(new Word("The family is not small", "Die Familie ist nicht klein", "خانواده کوچک نیست", 0));
    w.add(new Word("The family is big", "Die Familie ist groß", "خانواده بزرگ است", 0));
    return new WordCollection(0,
      "WordTrainer Lesson2: Family Members - Familie", w, true);
  }

  public static WordCollection wordTrainerLesson1() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("I", "Ich", "من", 0));
    w.add(new Word("I and you", "ich und du", "من و تو", 0));
    w.add(new Word("both of us", "wir beide", "هر دو ما", 0));
    w.add(new Word("he", "er", "او (مرد)", 0));
    w.add(new Word("he and she", "er und sie", "او (مرد) و او (زن)", 0));
    w.add(new Word("they both", "sie beide", "هر دو آنها", 0));
    w.add(new Word("the man", "der Mann", "مرد", 0));
    w.add(new Word("the woman", "die Frau", "زن", 0));
    w.add(new Word("the child", "das Kind", "بچه", 0));
    w.add(new Word("a family", "eine Familie", "یک خانواده", 0));
    w.add(new Word("my family", "meine Familie", "خانواده من", 0));
    w.add(new Word("My family is here", "Meine Familie ist hier", "خانوادم اینجاست", 0));
    w.add(new Word("I am here", "Ich bin hier", "من اینجا هستم", 0));
    w.add(new Word("You are here.", "Du bist hier", "تو اینجا هستی", 0));
    w.add(new Word("He is here and she is here", "Er ist hier und sie ist hier", "او اینجاست و او اینجاست", 0));
    w.add(new Word("We are here", "Wir sind hier", "ما اینجا هستیم", 0));
    w.add(new Word("You are here.", "Ihr seid hier", "شما اینجا هستید", 0));
    w.add(new Word("They are all here", "Sie sind alle hier", "آنها همه اینجا هستند", 0));
    return new WordCollection(0,
      "WordTrainer Lesson1: People - Personen", w, true);
  }

}