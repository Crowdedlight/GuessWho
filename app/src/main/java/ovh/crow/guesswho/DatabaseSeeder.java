package ovh.crow.guesswho;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Frederik Mazur Andersen on 28-04-2017.
 */

public class DatabaseSeeder {

    public static void seedDatabase(Context mContext) {
        //Get Session & daoMaster
        DaoSession daoSession = ((App) mContext.getApplicationContext()).getDaoSession();
        DaoMaster.DevOpenHelper helper = ((App) mContext.getApplicationContext()).getHelper();

        //test if tables are empty, if not terminate function as database is already seeded
        if (daoSession.getPersonAttributeDao().count() != 0) {
            Log.d("debug_db", "database already seeded, skipping seed");
            return;
        }
        //else clean and create database
        Log.d("debug_db", "database dropping tables");

        //clean database
        Database db = helper.getWritableDb();
        //DaoMaster dMaster = new DaoMaster(db);
        DaoMaster.dropAllTables(db, true);

        Log.d("debug_db", "database creating tables");
        DaoMaster.createAllTables(db, true);

        Log.d("debug_db", "database started seeding");
        //Get All tables
        final PersonDao personDao = daoSession.getPersonDao();
        final PersonAttributeDao personAttributeDao = daoSession.getPersonAttributeDao();
        final ModifiersDao modifiersDao = daoSession.getModifiersDao();
        final AttributeDao attributeDao = daoSession.getAttributeDao();
        final AreasDao areasDao = daoSession.getAreasDao();

        //Runs it all in tx mode for faster insert
        daoSession.runInTx(new Runnable() {

            @Override
            public void run() {

                //region // ----- SEED AREAS ------ //
                // ------------------------------------ //
                // ------------ SEED AREAS ------------ //
                // ------------------------------------ //

                //AREA 1
                Areas areaHair = new Areas();
                areaHair.setName("Hair");
                areasDao.insert(areaHair);

                //AREA 2
                Areas areaFacialHair = new Areas();
                areaFacialHair.setName("Facial Hair");
                areasDao.insert(areaFacialHair);

                //AREA 3
                Areas areaEyes = new Areas();
                areaEyes.setName("Eyes");
                areasDao.insert(areaEyes);

                //AREA 4
                Areas areaNose = new Areas();
                areaNose.setName("Nose");
                areasDao.insert(areaNose);

                //AREA 5
                Areas areaGender = new Areas();
                areaGender.setName("Gender");
                areasDao.insert(areaGender);

                //AREA 6
                Areas areaSkinTone = new Areas();
                areaSkinTone.setName("Skin tone");
                areasDao.insert(areaSkinTone);

                //AREA 7
                Areas areaAccessory = new Areas();
                areaAccessory.setName("Accessory");
                areasDao.insert(areaAccessory);


                //endregion

                //region // ----- SEED MODIFIERS ------ //
                // ------------------------------------ //
                // ---------- SEED MODIFIERS ---------- //
                // ------------------------------------ //

                //Modifier 1
                Modifiers modifierBlond = new Modifiers();
                modifierBlond.setName("Blond");
                modifiersDao.insert(modifierBlond);

                //Modifier 2
                Modifiers modifierBrown = new Modifiers();
                modifierBrown.setName("Brown");
                modifiersDao.insert(modifierBrown);

                //Modifier 3
                Modifiers modifierNoHair = new Modifiers();
                modifierNoHair.setName("No Hair");
                modifiersDao.insert(modifierNoHair);

                //Modifier 4
                Modifiers modifierHasHair = new Modifiers();
                modifierHasHair.setName("Has Hair");
                modifiersDao.insert(modifierHasHair);

                //Modifier 5
                Modifiers modifierHasFacialHair = new Modifiers();
                modifierHasFacialHair.setName("Has Facial hair");
                modifiersDao.insert(modifierHasFacialHair);

                //Modifier 6
                Modifiers modifierNoFacialHair = new Modifiers();
                modifierNoFacialHair.setName("No Facial hair");
                modifiersDao.insert(modifierNoFacialHair);

                //Modifier 7
                Modifiers modifierOrange = new Modifiers();
                modifierOrange.setName("Orange");
                modifiersDao.insert(modifierOrange);

                //Modifier 8
                Modifiers modifierBlack = new Modifiers();
                modifierBlack.setName("Black");
                modifiersDao.insert(modifierBlack);

                //Modifier 9
                Modifiers modifierBlue = new Modifiers();
                modifierBlue.setName("Blue");
                modifiersDao.insert(modifierBlue);

                //Modifier 10
                Modifiers modifierWhite = new Modifiers();
                modifierWhite.setName("White");
                modifiersDao.insert(modifierWhite);

                //Modifier 11
                Modifiers modifierGlasses = new Modifiers();
                modifierGlasses.setName("Glasses");
                modifiersDao.insert(modifierGlasses);

                //Modifier 12
                Modifiers modifierMask = new Modifiers();
                modifierMask.setName("Mask");
                modifiersDao.insert(modifierMask);

                //Modifier 13
                Modifiers modifierMale = new Modifiers();
                modifierMale.setName("Male");
                modifiersDao.insert(modifierMale);

                //Modifier 14
                Modifiers modifierFemale = new Modifiers();
                modifierFemale.setName("Female");
                modifiersDao.insert(modifierFemale);

                //Modifier 15
                Modifiers modifierLarge = new Modifiers();
                modifierLarge.setName("Large");
                modifiersDao.insert(modifierLarge);

                //Modifier 16
                Modifiers modifierSmall = new Modifiers();
                modifierSmall.setName("Small");
                modifiersDao.insert(modifierSmall);

                //Modifier 17
                Modifiers modifierNone = new Modifiers();
                modifierNone.setName("None");
                modifiersDao.insert(modifierNone);

                //endregion

                //region // ----- SEED ATTRIBUTES ----- //
                // ------------------------------------ //
                // --------- SEED ATTRIBUTES ---------- //
                // ------------------------------------ //

                //region // ----- HAIR ----- //

                //Attribute 1 - Brown
                Attribute hairAttBrown = new Attribute();
                hairAttBrown.setArea(areaHair);
                hairAttBrown.setModifier(modifierBrown);
                attributeDao.insert(hairAttBrown);

                //Attribute 2 - Blond
                Attribute hairAttBlond = new Attribute();
                hairAttBlond.setArea(areaHair);
                hairAttBlond.setModifier(modifierBlond);
                attributeDao.insert(hairAttBlond);

                //Attribute 3 - Black
                Attribute hairAttBlack = new Attribute();
                hairAttBlack.setArea(areaHair);
                hairAttBlack.setModifier(modifierBlue);
                attributeDao.insert(hairAttBlack);

                //Attribute 4 - Orange
                Attribute hairAttOrange = new Attribute();
                hairAttOrange.setArea(areaHair);
                hairAttOrange.setModifier(modifierOrange);
                attributeDao.insert(hairAttOrange);

                //Attribute 5 - No Hair
                Attribute hairAttNoHair = new Attribute();
                hairAttNoHair.setArea(areaHair);
                hairAttNoHair.setModifier(modifierNoHair);
                attributeDao.insert(hairAttNoHair);

                //Attribute 6 - Has Hair
                Attribute hairAttHasHair = new Attribute();
                hairAttHasHair.setArea(areaHair);
                hairAttHasHair.setModifier(modifierHasHair);
                attributeDao.insert(hairAttHasHair);

                //endregion

                //region // ----- FACIAL HAIR ----- //

                //Attribute 1 - No Hair
                Attribute facialAttNoHair = new Attribute();
                facialAttNoHair.setArea(areaFacialHair);
                facialAttNoHair.setModifier(modifierNoFacialHair);
                attributeDao.insert(facialAttNoHair);

                //Attribute 2 - Has Hair
                Attribute facialAttHasHair = new Attribute();
                facialAttHasHair.setArea(areaFacialHair);
                facialAttHasHair.setModifier(modifierHasFacialHair);
                attributeDao.insert(facialAttHasHair);

                //Attribute 3 - Orange
                Attribute facialAttOrange = new Attribute();
                facialAttOrange.setArea(areaFacialHair);
                facialAttOrange.setModifier(modifierOrange);
                attributeDao.insert(facialAttOrange);

                //Attribute 4 - Black
                Attribute facialAttBlack = new Attribute();
                facialAttBlack.setArea(areaFacialHair);
                facialAttBlack.setModifier(modifierBlack);
                attributeDao.insert(facialAttBlack);

                //Attribute 5 - Brown
                Attribute facialAttBrown = new Attribute();
                facialAttBrown.setArea(areaFacialHair);
                facialAttBrown.setModifier(modifierBrown);
                attributeDao.insert(facialAttBrown);

                //endregion

                //region // ----- EYES ----- //

                //Attribute 1 - Blue
                Attribute eyesAttBlue = new Attribute();
                eyesAttBlue.setArea(areaEyes);
                eyesAttBlue.setModifier(modifierBlue);
                attributeDao.insert(eyesAttBlue);

                //Attribute 2 - Brown
                Attribute eyesAttBrown = new Attribute();
                eyesAttBrown.setArea(areaEyes);
                eyesAttBrown.setModifier(modifierBrown);
                attributeDao.insert(eyesAttBrown);

                //endregion

                //region // ----- NOSE ----- //

                //Attribute 1 - Large
                Attribute noseAttLarge = new Attribute();
                noseAttLarge.setArea(areaNose);
                noseAttLarge.setModifier(modifierLarge);
                attributeDao.insert(noseAttLarge);

                //Attribute 2 - Small
                Attribute noseAttSmall = new Attribute();
                noseAttSmall.setArea(areaNose);
                noseAttSmall.setModifier(modifierSmall);
                attributeDao.insert(noseAttSmall);

                //endregion

                //region // ----- GENDER ----- //

                //Attribute 1 - Female
                Attribute genderAttFemale = new Attribute();
                genderAttFemale.setArea(areaGender);
                genderAttFemale.setModifier(modifierFemale);
                attributeDao.insert(genderAttFemale);

                //Attribute 2 - Male
                Attribute genderAttMale = new Attribute();
                genderAttMale.setArea(areaGender);
                genderAttMale.setModifier(modifierMale);
                attributeDao.insert(genderAttMale);

                //endregion

                //region // ----- SKIN TONE ----- //

                //Attribute 1 - Brown
                Attribute skinAttBrown = new Attribute();
                skinAttBrown.setArea(areaSkinTone);
                skinAttBrown.setModifier(modifierBrown);
                attributeDao.insert(skinAttBrown);

                //Attribute 2 - White
                Attribute skinAttWhite = new Attribute();
                skinAttWhite.setArea(areaSkinTone);
                skinAttWhite.setModifier(modifierWhite);
                attributeDao.insert(skinAttWhite);

                //endregion

                //region // ----- ACCESSORY ----- //

                //Attribute 1 - Glasses
                Attribute accessoryAttGlasses = new Attribute();
                accessoryAttGlasses.setArea(areaAccessory);
                accessoryAttGlasses.setModifier(modifierGlasses);
                attributeDao.insert(accessoryAttGlasses);

                //Attribute 2 - Mask
                Attribute accessoryAttMask = new Attribute();
                accessoryAttMask.setArea(areaAccessory);
                accessoryAttMask.setModifier(modifierMask);
                attributeDao.insert(accessoryAttMask);

                //Attribute 2 - None
                Attribute accessoryAttNone = new Attribute();
                accessoryAttNone.setArea(areaAccessory);
                accessoryAttNone.setModifier(modifierNone);
                attributeDao.insert(accessoryAttNone);

                //endregion
                //endregion

                //region // ----- SEED PERSONS ----- //
                // ------------------------------------ //
                // ----------- SEED PERSONS ----------- //
                // ------------------------------------ //

                Person paul = new Person();
                paul.setName("Paul");
                paul.setImgName("img_paul");
                personDao.insert(paul);

                Person jody = new Person();
                jody.setName("Jody");
                jody.setImgName("img_jody");
                personDao.insert(jody);

                Person marcellus = new Person();
                marcellus.setName("Marcellus");
                marcellus.setImgName("img_marcellus");
                personDao.insert(marcellus);

                Person jimmie = new Person();
                jimmie.setName("Jimmie");
                jimmie.setImgName("img_jimmie");
                personDao.insert(jimmie);


                Person esmeralda = new Person();
                esmeralda.setName("Esmeralda");
                esmeralda.setImgName("img_esmeralda");
                personDao.insert(esmeralda);

                Person captKoons = new Person();
                captKoons.setName("Captain Koons");
                captKoons.setImgName("img_captain_koons");
                personDao.insert(captKoons);

                Person jules = new Person();
                jules.setName("Jules");
                jules.setImgName("img_jules");
                personDao.insert(jules);

                Person buddy = new Person();
                buddy.setName("Buddy");
                buddy.setImgName("img_buddy");
                personDao.insert(buddy);

                Person gimp = new Person();
                gimp.setName("The Gimp");
                gimp.setImgName("img_the_gimp");
                personDao.insert(gimp);

                Person yolanda = new Person();
                yolanda.setName("Yolanda");
                yolanda.setImgName("img_yolanda");
                personDao.insert(yolanda);

                Person roger = new Person();
                roger.setName("Roger");
                roger.setImgName("img_roger");
                personDao.insert(roger);

                Person fabienne = new Person();
                fabienne.setName("Fabienne");
                fabienne.setImgName("img_fabienne");
                personDao.insert(fabienne);

                Person ringo = new Person();
                ringo.setName("Ringo");
                ringo.setImgName("img_ringo");
                personDao.insert(ringo);

                Person raquel = new Person();
                raquel.setName("Raquel");
                raquel.setImgName("img_raquel");
                personDao.insert(raquel);

                Person lance = new Person();
                lance.setName("Lance");
                lance.setImgName("img_lance");
                personDao.insert(lance);

                Person butch = new Person();
                butch.setName("Butch");
                butch.setImgName("img_butch");
                personDao.insert(butch);

                Person mia = new Person();
                mia.setName("Mia");
                mia.setImgName("img_mia");
                personDao.insert(mia);

                Person marvin = new Person();
                marvin.setName("Marvin");
                marvin.setImgName("img_marvin");
                personDao.insert(marvin);

                Person zed = new Person();
                zed.setName("Zed");
                zed.setImgName("img_zed");
                personDao.insert(zed);

                Person brett = new Person();
                brett.setName("Brett");
                brett.setImgName("img_brett");
                personDao.insert(brett);

                Person trudi = new Person();
                trudi.setName("Trudi");
                trudi.setImgName("img_trudi");
                personDao.insert(trudi);

                Person maynard = new Person();
                maynard.setName("Maynard");
                maynard.setImgName("img_maynard");
                personDao.insert(maynard);

                Person vincent = new Person();
                vincent.setName("Vincent");
                vincent.setImgName("img_vincent");
                personDao.insert(vincent);

                Person winston = new Person();
                winston.setName("Winston");
                winston.setImgName("img_winston");
                personDao.insert(winston);

                //endregion

                //region // ----- SEED PERSON ATTRIBUTES ----- //
                // ------------------------------------ //
                // ------ SEED PERSON ATTRIBUTES ------ //
                // ------------------------------------ //


                //region // ----- POUL ----- //

                //Attribute 1 - has hair
                PersonAttribute paulHair = new PersonAttribute();
                paulHair.setPerson(paul);
                paulHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(paulHair);

                //Attribute 1a - black hair
                PersonAttribute paulHairColor = new PersonAttribute();
                paulHairColor.setPerson(paul);
                paulHairColor.setAttribute(hairAttBlack);
                personAttributeDao.insert(paulHairColor);

                //Attribute 2 - has facial hair
                PersonAttribute paulFacial = new PersonAttribute();
                paulFacial.setPerson(paul);
                paulFacial.setAttribute(facialAttHasHair);
                personAttributeDao.insert(paulFacial);

                //Attribute 2a - black facial hair
                PersonAttribute paulFacialColor = new PersonAttribute();
                paulFacialColor.setPerson(paul);
                paulFacialColor.setAttribute(facialAttBlack);
                personAttributeDao.insert(paulFacialColor);

                //Attribute 3 - brown eyes
                PersonAttribute paulEyes = new PersonAttribute();
                paulEyes.setPerson(paul);
                paulEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(paulEyes);

                //Attribute 4 - large nose
                PersonAttribute paulNose = new PersonAttribute();
                paulNose.setPerson(paul);
                paulNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(paulNose);

                //Attribute 5 - no accessory
                PersonAttribute paulAccessory = new PersonAttribute();
                paulAccessory.setPerson(paul);
                paulAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(paulAccessory);

                //Attribute 6 - Male
                PersonAttribute paulGender = new PersonAttribute();
                paulGender.setPerson(paul);
                paulGender.setAttribute(genderAttMale);
                personAttributeDao.insert(paulGender);

                //Attribute 7 - Brown Skin
                PersonAttribute paulSkin = new PersonAttribute();
                paulSkin.setPerson(paul);
                paulSkin.setAttribute(skinAttBrown);
                personAttributeDao.insert(paulSkin);

                //endregion

                //region // ----- JODY ----- //

                //Attribute 1 - has hair
                PersonAttribute jodyHair = new PersonAttribute();
                jodyHair.setPerson(jody);
                jodyHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(jodyHair);

                //Attribute 1 - blond hair
                PersonAttribute jodyHairColor = new PersonAttribute();
                jodyHairColor.setPerson(jody);
                jodyHairColor.setAttribute(hairAttBlond);
                personAttributeDao.insert(jodyHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute jodyFacial = new PersonAttribute();
                jodyFacial.setPerson(jody);
                jodyFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(jodyFacial);

                //Attribute 3 - blue eyes
                PersonAttribute jodyEyes = new PersonAttribute();
                jodyEyes.setPerson(jody);
                jodyEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(jodyEyes);

                //Attribute 4 - small nose
                PersonAttribute jodyNose = new PersonAttribute();
                jodyNose.setPerson(jody);
                jodyNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(jodyNose);

                //Attribute 5 - no accessory
                PersonAttribute jodyAccessory = new PersonAttribute();
                jodyAccessory.setPerson(jody);
                jodyAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(jodyAccessory);

                //Attribute 6 - female
                PersonAttribute jodyGender = new PersonAttribute();
                jodyGender.setPerson(jody);
                jodyGender.setAttribute(genderAttFemale);
                personAttributeDao.insert(jodyGender);

                //Attribute 7 - white Skin
                PersonAttribute jodySkin = new PersonAttribute();
                jodySkin.setPerson(jody);
                jodySkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(jodySkin);

                //endregion

                //region // ----- MARCELLUS ----- //

                //Attribute 1 - no hair
                PersonAttribute marcellusHair = new PersonAttribute();
                marcellusHair.setPerson(marcellus);
                marcellusHair.setAttribute(hairAttNoHair);
                personAttributeDao.insert(marcellusHair);

                //Attribute 2 - facial hair
                PersonAttribute marcellusFacial = new PersonAttribute();
                marcellusFacial.setPerson(marcellus);
                marcellusFacial.setAttribute(facialAttHasHair);
                personAttributeDao.insert(marcellusFacial);

                //Attribute 2a - black facial hair
                PersonAttribute marcellusFacialColor = new PersonAttribute();
                marcellusFacialColor.setPerson(marcellus);
                marcellusFacialColor.setAttribute(facialAttBlack);
                personAttributeDao.insert(marcellusFacialColor);

                //Attribute 3 - brown eyes
                PersonAttribute marcellusEyes = new PersonAttribute();
                marcellusEyes.setPerson(marcellus);
                marcellusEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(marcellusEyes);

                //Attribute 4 - large nose
                PersonAttribute marcellusNose = new PersonAttribute();
                marcellusNose.setPerson(marcellus);
                marcellusNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(marcellusNose);

                //Attribute 5 - no accessory
                PersonAttribute marcellusAccessory= new PersonAttribute();
                marcellusAccessory.setPerson(marcellus);
                marcellusAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(marcellusAccessory);

                //Attribute 6 - male
                PersonAttribute marcellusGender = new PersonAttribute();
                marcellusGender.setPerson(marcellus);
                marcellusGender.setAttribute(genderAttMale);
                personAttributeDao.insert(marcellusGender);

                //Attribute 7 - brown Skin
                PersonAttribute marcellusSkin = new PersonAttribute();
                marcellusSkin.setPerson(marcellus);
                marcellusSkin.setAttribute(skinAttBrown);
                personAttributeDao.insert(marcellusSkin);

                //endregion

                //region // ----- JIMMIE ----- //

                //Attribute 1 - has hair
                PersonAttribute jimmieHair = new PersonAttribute();
                jimmieHair.setPerson(jimmie);
                jimmieHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(jimmieHair);

                //Attribute 1 - brown hair
                PersonAttribute jimmieHairColor = new PersonAttribute();
                jimmieHairColor.setPerson(jimmie);
                jimmieHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(jimmieHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute jimmieFacial = new PersonAttribute();
                jimmieFacial.setPerson(jimmie);
                jimmieFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(jimmieFacial);

                //Attribute 3 - brown eyes
                PersonAttribute jimmieEyes = new PersonAttribute();
                jimmieEyes.setPerson(jimmie);
                jimmieEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(jimmieEyes);

                //Attribute 4 - small nose
                PersonAttribute jimmieNose = new PersonAttribute();
                jimmieNose.setPerson(jimmie);
                jimmieNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(jimmieNose);

                //Attribute 5 - no accessory
                PersonAttribute jimmieAccessory = new PersonAttribute();
                jimmieAccessory.setPerson(jimmie);
                jimmieAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(jimmieAccessory);

                //Attribute 6 - male
                PersonAttribute jimmieGender = new PersonAttribute();
                jimmieGender.setPerson(jimmie);
                jimmieGender.setAttribute(genderAttMale);
                personAttributeDao.insert(jimmieGender);

                //Attribute 7 - white Skin
                PersonAttribute jimmieSkin = new PersonAttribute();
                jimmieSkin.setPerson(jimmie);
                jimmieSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(jimmieSkin);

                //endregion

                //region // ----- ESMERALDA ----- //

                //Attribute 1 - has hair
                PersonAttribute esmeraldaHair = new PersonAttribute();
                esmeraldaHair.setPerson(esmeralda);
                esmeraldaHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(esmeraldaHair);

                //Attribute 1 - brown hair
                PersonAttribute esmeraldaHairColor = new PersonAttribute();
                esmeraldaHairColor.setPerson(esmeralda);
                esmeraldaHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(esmeraldaHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute esmeraldaFacial = new PersonAttribute();
                esmeraldaFacial.setPerson(esmeralda);
                esmeraldaFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(esmeraldaFacial);

                //Attribute 3 - brown eyes
                PersonAttribute esmeraldaEyes = new PersonAttribute();
                esmeraldaEyes.setPerson(esmeralda);
                esmeraldaEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(esmeraldaEyes);

                //Attribute 4 - small nose
                PersonAttribute esmeraldaNose = new PersonAttribute();
                esmeraldaNose.setPerson(esmeralda);
                esmeraldaNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(esmeraldaNose);

                //Attribute 5 - no accessory
                PersonAttribute esmeraldaAccessory = new PersonAttribute();
                esmeraldaAccessory.setPerson(esmeralda);
                esmeraldaAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(esmeraldaAccessory);

                //Attribute 6 - female
                PersonAttribute esmeraldaGender = new PersonAttribute();
                esmeraldaGender.setPerson(esmeralda);
                esmeraldaGender.setAttribute(genderAttFemale);
                personAttributeDao.insert(esmeraldaGender);

                //Attribute 7 - white Skin
                PersonAttribute esmeraldaSkin = new PersonAttribute();
                esmeraldaSkin.setPerson(esmeralda);
                esmeraldaSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(esmeraldaSkin);

                //endregion

                //region // ----- CAPTAIN KOONS ----- //

                //Attribute 1 - has hair
                PersonAttribute captKoonsHair = new PersonAttribute();
                captKoonsHair.setPerson(captKoons);
                captKoonsHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(captKoonsHair);

                //Attribute 1 - brown hair
                PersonAttribute captKoonsHairColor = new PersonAttribute();
                captKoonsHairColor.setPerson(captKoons);
                captKoonsHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(captKoonsHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute captKoonsFacial = new PersonAttribute();
                captKoonsFacial.setPerson(captKoons);
                captKoonsFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(captKoonsFacial);

                //Attribute 3 - blue eyes
                PersonAttribute captKoonsEyes = new PersonAttribute();
                captKoonsEyes.setPerson(captKoons);
                captKoonsEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(captKoonsEyes);

                //Attribute 4 - small nose
                PersonAttribute captKoonsNose = new PersonAttribute();
                captKoonsNose.setPerson(captKoons);
                captKoonsNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(captKoonsNose);

                //Attribute 5 - no accessory
                PersonAttribute captKoonsAccessory = new PersonAttribute();
                captKoonsAccessory.setPerson(captKoons);
                captKoonsAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(captKoonsAccessory);

                //Attribute 6 - male
                PersonAttribute captKoonsGender = new PersonAttribute();
                captKoonsGender.setPerson(captKoons);
                captKoonsGender.setAttribute(genderAttMale);
                personAttributeDao.insert(captKoonsGender);

                //Attribute 7 - white Skin
                PersonAttribute captKoonsSkin = new PersonAttribute();
                captKoonsSkin.setPerson(captKoons);
                captKoonsSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(captKoonsSkin);

                //endregion

                //region // ----- JULES ----- //

                //Attribute 1 - has hair
                PersonAttribute julesHair = new PersonAttribute();
                julesHair.setPerson(jules);
                julesHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(julesHair);

                //Attribute 1a - black hair
                PersonAttribute julesHairColor = new PersonAttribute();
                julesHairColor.setPerson(jules);
                julesHairColor.setAttribute(hairAttBlack);
                personAttributeDao.insert(julesHairColor);

                //Attribute 2 - has facial hair
                PersonAttribute julesFacial = new PersonAttribute();
                julesFacial.setPerson(jules);
                julesFacial.setAttribute(facialAttHasHair);
                personAttributeDao.insert(julesFacial);

                //Attribute 2a - black facial hair
                PersonAttribute julesFacialColor = new PersonAttribute();
                julesFacialColor.setPerson(jules);
                julesFacialColor.setAttribute(facialAttBlack);
                personAttributeDao.insert(julesFacialColor);

                //Attribute 3 - brown eyes
                PersonAttribute julesEyes = new PersonAttribute();
                julesEyes.setPerson(jules);
                julesEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(julesEyes);

                //Attribute 4 - large nose
                PersonAttribute julesNose = new PersonAttribute();
                julesNose.setPerson(jules);
                julesNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(julesNose);

                //Attribute 5 - no accessory
                PersonAttribute julesAccessory = new PersonAttribute();
                julesAccessory.setPerson(jules);
                julesAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(julesAccessory);

                //Attribute 6 - Male
                PersonAttribute julesGender = new PersonAttribute();
                julesGender.setPerson(jules);
                julesGender.setAttribute(genderAttMale);
                personAttributeDao.insert(julesGender);

                //Attribute 7 - Brown Skin
                PersonAttribute julesSkin = new PersonAttribute();
                julesSkin.setPerson(jules);
                julesSkin.setAttribute(skinAttBrown);
                personAttributeDao.insert(julesSkin);

                //endregion

                //region // ----- BUDDY ----- //

                //Attribute 1 - has hair
                PersonAttribute buddyHair = new PersonAttribute();
                buddyHair.setPerson(buddy);
                buddyHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(buddyHair);

                //Attribute 1 - brown hair
                PersonAttribute buddyHairColor = new PersonAttribute();
                buddyHairColor.setPerson(buddy);
                buddyHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(buddyHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute buddyFacial = new PersonAttribute();
                buddyFacial.setPerson(buddy);
                buddyFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(buddyFacial);

                //Attribute 3 - blue eyes
                PersonAttribute buddyEyes = new PersonAttribute();
                buddyEyes.setPerson(buddy);
                buddyEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(buddyEyes);

                //Attribute 4 - small nose
                PersonAttribute buddyNose = new PersonAttribute();
                buddyNose.setPerson(buddy);
                buddyNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(buddyNose);

                //Attribute 5 - no accessory
                PersonAttribute buddyAccessory = new PersonAttribute();
                buddyAccessory.setPerson(buddy);
                buddyAccessory.setAttribute(accessoryAttGlasses);
                personAttributeDao.insert(buddyAccessory);

                //Attribute 6 - male
                PersonAttribute buddyGender = new PersonAttribute();
                buddyGender.setPerson(buddy);
                buddyGender.setAttribute(genderAttMale);
                personAttributeDao.insert(buddyGender);

                //Attribute 7 - white Skin
                PersonAttribute buddySkin = new PersonAttribute();
                buddySkin.setPerson(buddy);
                buddySkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(buddySkin);

                //endregion

                //region // ----- GIMP ----- //

                //Attribute 1 - has hair
                PersonAttribute gtmpHair = new PersonAttribute();
                gtmpHair.setPerson(gimp);
                gtmpHair.setAttribute(hairAttNoHair);
                personAttributeDao.insert(gtmpHair);


                //Attribute 2 - no facial hair
                PersonAttribute gimpFacial = new PersonAttribute();
                gimpFacial.setPerson(gimp);
                gimpFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(gimpFacial);

                //Attribute 3 - blue eyes
                PersonAttribute gimpEyes = new PersonAttribute();
                gimpEyes.setPerson(gimp);
                gimpEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(gimpEyes);

                //Attribute 4 - small nose
                PersonAttribute gimpNose = new PersonAttribute();
                gimpNose.setPerson(gimp);
                gimpNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(gimpNose);

                //Attribute 5 - no accessory
                PersonAttribute gimpAccessory = new PersonAttribute();
                gimpAccessory.setPerson(gimp);
                gimpAccessory.setAttribute(accessoryAttMask);
                personAttributeDao.insert(gimpAccessory);

                //Attribute 6 - male
                PersonAttribute gimpGender = new PersonAttribute();
                gimpGender.setPerson(gimp);
                gimpGender.setAttribute(genderAttMale);
                personAttributeDao.insert(gimpGender);

                //Attribute 7 - white Skin
                PersonAttribute gimpSkin = new PersonAttribute();
                gimpSkin.setPerson(gimp);
                gimpSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(gimpSkin);

                //endregion

                //region // ----- YOLANDA ----- //

                //Attribute 1 - has hair
                PersonAttribute yolandaHair = new PersonAttribute();
                yolandaHair.setPerson(yolanda);
                yolandaHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(yolandaHair);

                //Attribute 1 - orange hair
                PersonAttribute yolandaHairColor = new PersonAttribute();
                yolandaHairColor.setPerson(yolanda);
                yolandaHairColor.setAttribute(hairAttOrange);
                personAttributeDao.insert(yolandaHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute yolandaFacial = new PersonAttribute();
                yolandaFacial.setPerson(yolanda);
                yolandaFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(yolandaFacial);

                //Attribute 3 - brown eyes
                PersonAttribute yolandaEyes = new PersonAttribute();
                yolandaEyes.setPerson(yolanda);
                yolandaEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(yolandaEyes);

                //Attribute 4 - large nose
                PersonAttribute yolandaNose = new PersonAttribute();
                yolandaNose.setPerson(yolanda);
                yolandaNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(yolandaNose);

                //Attribute 5 - no accessory
                PersonAttribute yolandaAccessory = new PersonAttribute();
                yolandaAccessory.setPerson(yolanda);
                yolandaAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(yolandaAccessory);

                //Attribute 6 - female
                PersonAttribute yolandaGender = new PersonAttribute();
                yolandaGender.setPerson(yolanda);
                yolandaGender.setAttribute(genderAttFemale);
                personAttributeDao.insert(yolandaGender);

                //Attribute 7 - white Skin
                PersonAttribute yolandaSkin = new PersonAttribute();
                yolandaSkin.setPerson(yolanda);
                yolandaSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(yolandaSkin);

                //endregion

                //region // ----- ROGER ----- //

                //Attribute 1 - has hair
                PersonAttribute rogerHair = new PersonAttribute();
                rogerHair.setPerson(roger);
                rogerHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(rogerHair);

                //Attribute 1 - blond hair
                PersonAttribute rogerHairColor = new PersonAttribute();
                rogerHairColor.setPerson(roger);
                rogerHairColor.setAttribute(hairAttBlond);
                personAttributeDao.insert(rogerHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute rogerFacial = new PersonAttribute();
                rogerFacial.setPerson(roger);
                rogerFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(rogerFacial);

                //Attribute 3 - brown eyes
                PersonAttribute rogerEyes = new PersonAttribute();
                rogerEyes.setPerson(roger);
                rogerEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(rogerEyes);

                //Attribute 4 - small nose
                PersonAttribute rogerNose = new PersonAttribute();
                rogerNose.setPerson(roger);
                rogerNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(rogerNose);

                //Attribute 5 - no accessory
                PersonAttribute rogerAccessory = new PersonAttribute();
                rogerAccessory.setPerson(roger);
                rogerAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(rogerAccessory);

                //Attribute 6 - male
                PersonAttribute rogerGender = new PersonAttribute();
                rogerGender.setPerson(roger);
                rogerGender.setAttribute(genderAttMale);
                personAttributeDao.insert(rogerGender);

                //Attribute 7 - white Skin
                PersonAttribute rogerSkin = new PersonAttribute();
                rogerSkin.setPerson(roger);
                rogerSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(rogerSkin);

                //endregion

                //region // ----- FABIENNE ----- //

                //Attribute 1 - has hair
                PersonAttribute fabienneHair = new PersonAttribute();
                fabienneHair.setPerson(fabienne);
                fabienneHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(fabienneHair);

                //Attribute 1 - black hair
                PersonAttribute fabienneHairColor = new PersonAttribute();
                fabienneHairColor.setPerson(fabienne);
                fabienneHairColor.setAttribute(hairAttBlack);
                personAttributeDao.insert(fabienneHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute fabienneFacial = new PersonAttribute();
                fabienneFacial.setPerson(fabienne);
                fabienneFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(fabienneFacial);

                //Attribute 3 - blue eyes
                PersonAttribute fabienneEyes = new PersonAttribute();
                fabienneEyes.setPerson(fabienne);
                fabienneEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(fabienneEyes);

                //Attribute 4 - small nose
                PersonAttribute fabienneNose = new PersonAttribute();
                fabienneNose.setPerson(fabienne);
                fabienneNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(fabienneNose);

                //Attribute 5 - no accessory
                PersonAttribute fabienneAccessory = new PersonAttribute();
                fabienneAccessory.setPerson(fabienne);
                fabienneAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(fabienneAccessory);

                //Attribute 6 - female
                PersonAttribute fabienneGender = new PersonAttribute();
                fabienneGender.setPerson(fabienne);
                fabienneGender.setAttribute(genderAttFemale);
                personAttributeDao.insert(fabienneGender);

                //Attribute 7 - white Skin
                PersonAttribute fabienneSkin = new PersonAttribute();
                fabienneSkin.setPerson(fabienne);
                fabienneSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(fabienneSkin);

                //endregion

                //region // ----- RINGO ----- //

                //Attribute 1 - has hair
                PersonAttribute ringoHair = new PersonAttribute();
                ringoHair.setPerson(ringo);
                ringoHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(ringoHair);

                //Attribute 1 - blond hair
                PersonAttribute ringoHairColor = new PersonAttribute();
                ringoHairColor.setPerson(ringo);
                ringoHairColor.setAttribute(hairAttBlond);
                personAttributeDao.insert(ringoHairColor);

                //Attribute 2 - has facial hair
                PersonAttribute ringoFacial = new PersonAttribute();
                ringoFacial.setPerson(ringo);
                ringoFacial.setAttribute(facialAttHasHair);
                personAttributeDao.insert(ringoFacial);

                //Attribute 3 - blue eyes
                PersonAttribute ringoEyes = new PersonAttribute();
                ringoEyes.setPerson(ringo);
                ringoEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(ringoEyes);

                //Attribute 4 - large nose
                PersonAttribute ringoNose = new PersonAttribute();
                ringoNose.setPerson(ringo);
                ringoNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(ringoNose);

                //Attribute 5 - no accessory
                PersonAttribute ringoAccessory = new PersonAttribute();
                ringoAccessory.setPerson(ringo);
                ringoAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(ringoAccessory);

                //Attribute 6 - male
                PersonAttribute ringoGender = new PersonAttribute();
                ringoGender.setPerson(ringo);
                ringoGender.setAttribute(genderAttMale);
                personAttributeDao.insert(ringoGender);

                //Attribute 7 - white Skin
                PersonAttribute ringoSkin = new PersonAttribute();
                ringoSkin.setPerson(ringo);
                ringoSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(ringoSkin);

                //endregion

                //region // ----- RAQUEL ----- //

                //Attribute 1 - has hair
                PersonAttribute raquelHair = new PersonAttribute();
                raquelHair.setPerson(raquel);
                raquelHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(raquelHair);

                //Attribute 1 - orange hair
                PersonAttribute raquelHairColor = new PersonAttribute();
                raquelHairColor.setPerson(raquel);
                raquelHairColor.setAttribute(hairAttOrange);
                personAttributeDao.insert(raquelHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute raquelFacial = new PersonAttribute();
                raquelFacial.setPerson(raquel);
                raquelFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(raquelFacial);

                //Attribute 3 - blue eyes
                PersonAttribute raquelEyes = new PersonAttribute();
                raquelEyes.setPerson(raquel);
                raquelEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(raquelEyes);

                //Attribute 4 - small nose
                PersonAttribute raquelNose = new PersonAttribute();
                raquelNose.setPerson(raquel);
                raquelNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(raquelNose);

                //Attribute 5 - no accessory
                PersonAttribute raquelAccessory = new PersonAttribute();
                raquelAccessory.setPerson(raquel);
                raquelAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(raquelAccessory);

                //Attribute 6 - female
                PersonAttribute raquelGender = new PersonAttribute();
                raquelGender.setPerson(raquel);
                raquelGender.setAttribute(genderAttFemale);
                personAttributeDao.insert(raquelGender);

                //Attribute 7 - white Skin
                PersonAttribute raquelSkin = new PersonAttribute();
                raquelSkin.setPerson(raquel);
                raquelSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(raquelSkin);

                //endregion

                //region // ----- LANCE ----- //

                //Attribute 1 - has hair
                PersonAttribute lanceHair = new PersonAttribute();
                lanceHair.setPerson(lance);
                lanceHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(lanceHair);

                //Attribute 1a - orange hair
                PersonAttribute lanceHairColor = new PersonAttribute();
                lanceHairColor.setPerson(lance);
                lanceHairColor.setAttribute(hairAttOrange);
                personAttributeDao.insert(lanceHairColor);

                //Attribute 2 - has facial hair
                PersonAttribute lanceFacial = new PersonAttribute();
                lanceFacial.setPerson(lance);
                lanceFacial.setAttribute(facialAttHasHair);
                personAttributeDao.insert(lanceFacial);

                //Attribute 2a - orange facial hair
                PersonAttribute lanceFacialColor = new PersonAttribute();
                lanceFacialColor.setPerson(lance);
                lanceFacialColor.setAttribute(facialAttOrange);
                personAttributeDao.insert(lanceFacialColor);

                //Attribute 3 - blue eyes
                PersonAttribute lanceEyes = new PersonAttribute();
                lanceEyes.setPerson(lance);
                lanceEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(lanceEyes);

                //Attribute 4 - small nose
                PersonAttribute lanceNose = new PersonAttribute();
                lanceNose.setPerson(lance);
                lanceNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(lanceNose);

                //Attribute 5 - no accessory
                PersonAttribute lanceAccessory = new PersonAttribute();
                lanceAccessory.setPerson(lance);
                lanceAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(lanceAccessory);

                //Attribute 6 - Male
                PersonAttribute lanceGender = new PersonAttribute();
                lanceGender.setPerson(lance);
                lanceGender.setAttribute(genderAttMale);
                personAttributeDao.insert(lanceGender);

                //Attribute 7 - white Skin
                PersonAttribute lanceSkin = new PersonAttribute();
                lanceSkin.setPerson(lance);
                lanceSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(lanceSkin);

                //endregion

                //region // ----- BUTCH ----- //

                //Attribute 1 - has hair
                PersonAttribute butchHair = new PersonAttribute();
                butchHair.setPerson(butch);
                butchHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(butchHair);

                //Attribute 1 - blond hair
                PersonAttribute butchHairColor = new PersonAttribute();
                butchHairColor.setPerson(butch);
                butchHairColor.setAttribute(hairAttBlond);
                personAttributeDao.insert(butchHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute butchFacial = new PersonAttribute();
                butchFacial.setPerson(butch);
                butchFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(butchFacial);

                //Attribute 3 - blue eyes
                PersonAttribute butchEyes = new PersonAttribute();
                butchEyes.setPerson(butch);
                butchEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(butchEyes);

                //Attribute 4 - small nose
                PersonAttribute butchNose = new PersonAttribute();
                butchNose.setPerson(butch);
                butchNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(butchNose);

                //Attribute 5 - no accessory
                PersonAttribute butchAccessory = new PersonAttribute();
                butchAccessory.setPerson(butch);
                butchAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(butchAccessory);

                //Attribute 6 - male
                PersonAttribute butchGender = new PersonAttribute();
                butchGender.setPerson(butch);
                butchGender.setAttribute(genderAttMale);
                personAttributeDao.insert(butchGender);

                //Attribute 7 - white Skin
                PersonAttribute butchSkin = new PersonAttribute();
                butchSkin.setPerson(butch);
                butchSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(butchSkin);

                //endregion

                //region // ----- MIA ----- //

                //Attribute 1 - has hair
                PersonAttribute miaHair = new PersonAttribute();
                miaHair.setPerson(mia);
                miaHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(miaHair);

                //Attribute 1 - brown hair
                PersonAttribute miaHairColor = new PersonAttribute();
                miaHairColor.setPerson(mia);
                miaHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(miaHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute miaFacial = new PersonAttribute();
                miaFacial.setPerson(mia);
                miaFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(miaFacial);

                //Attribute 3 - blue eyes
                PersonAttribute miaEyes = new PersonAttribute();
                miaEyes.setPerson(mia);
                miaEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(miaEyes);

                //Attribute 4 - small nose
                PersonAttribute miaNose = new PersonAttribute();
                miaNose.setPerson(mia);
                miaNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(miaNose);

                //Attribute 5 - no accessory
                PersonAttribute miaAccessory = new PersonAttribute();
                miaAccessory.setPerson(mia);
                miaAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(miaAccessory);

                //Attribute 6 - female
                PersonAttribute miaGender = new PersonAttribute();
                miaGender.setPerson(mia);
                miaGender.setAttribute(genderAttFemale);
                personAttributeDao.insert(miaGender);

                //Attribute 7 - white Skin
                PersonAttribute miaSkin = new PersonAttribute();
                miaSkin.setPerson(mia);
                miaSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(miaSkin);

                //endregion

                //region // ----- MARVIN ----- //

                //Attribute 1 - has hair
                PersonAttribute marvinHair = new PersonAttribute();
                marvinHair.setPerson(marvin);
                marvinHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(marvinHair);

                //Attribute 1 - black hair
                PersonAttribute marvinHairColor = new PersonAttribute();
                marvinHairColor.setPerson(marvin);
                marvinHairColor.setAttribute(hairAttBlack);
                personAttributeDao.insert(marvinHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute marvinFacial = new PersonAttribute();
                marvinFacial.setPerson(marvin);
                marvinFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(marvinFacial);

                //Attribute 3 - brown eyes
                PersonAttribute marvinEyes = new PersonAttribute();
                marvinEyes.setPerson(marvin);
                marvinEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(marvinEyes);

                //Attribute 4 - large nose
                PersonAttribute marvinNose = new PersonAttribute();
                marvinNose.setPerson(marvin);
                marvinNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(marvinNose);

                //Attribute 5 - no accessory
                PersonAttribute marvinAccessory = new PersonAttribute();
                marvinAccessory.setPerson(marvin);
                marvinAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(marvinAccessory);

                //Attribute 6 - male
                PersonAttribute marvinGender = new PersonAttribute();
                marvinGender.setPerson(marvin);
                marvinGender.setAttribute(genderAttMale);
                personAttributeDao.insert(marvinGender);

                //Attribute 7 - brown Skin
                PersonAttribute marvinSkin = new PersonAttribute();
                marvinSkin.setPerson(marvin);
                marvinSkin.setAttribute(skinAttBrown);
                personAttributeDao.insert(marvinSkin);

                //endregion

                //region // ----- ZED ----- //

                //Attribute 1 - has hair
                PersonAttribute zedHair = new PersonAttribute();
                zedHair.setPerson(zed);
                zedHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(zedHair);

                //Attribute 1 - blond hair
                PersonAttribute zedHairColor = new PersonAttribute();
                zedHairColor.setPerson(zed);
                zedHairColor.setAttribute(hairAttBlond);
                personAttributeDao.insert(zedHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute zedFacial = new PersonAttribute();
                zedFacial.setPerson(zed);
                zedFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(zedFacial);

                //Attribute 3 - blue eyes
                PersonAttribute zedEyes = new PersonAttribute();
                zedEyes.setPerson(zed);
                zedEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(zedEyes);

                //Attribute 4 - large nose
                PersonAttribute zedNose = new PersonAttribute();
                zedNose.setPerson(zed);
                zedNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(zedNose);

                //Attribute 5 - no accessory
                PersonAttribute zedAccessory = new PersonAttribute();
                zedAccessory.setPerson(zed);
                zedAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(zedAccessory);

                //Attribute 6 - male
                PersonAttribute zedGender = new PersonAttribute();
                zedGender.setPerson(zed);
                zedGender.setAttribute(genderAttMale);
                personAttributeDao.insert(zedGender);

                //Attribute 7 - white Skin
                PersonAttribute zedSkin = new PersonAttribute();
                zedSkin.setPerson(zed);
                zedSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(zedSkin);

                //endregion

                //region // ----- BRETT ----- //

                //Attribute 1 - has hair
                PersonAttribute brettHair = new PersonAttribute();
                brettHair.setPerson(brett);
                brettHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(brettHair);

                //Attribute 1 - brown hair
                PersonAttribute brettHairColor = new PersonAttribute();
                brettHairColor.setPerson(brett);
                brettHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(brettHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute brettFacial = new PersonAttribute();
                brettFacial.setPerson(brett);
                brettFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(brettFacial);

                //Attribute 3 - brown eyes
                PersonAttribute brettEyes = new PersonAttribute();
                brettEyes.setPerson(brett);
                brettEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(brettEyes);

                //Attribute 4 - large nose
                PersonAttribute brettNose = new PersonAttribute();
                brettNose.setPerson(brett);
                brettNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(brettNose);

                //Attribute 5 - no accessory
                PersonAttribute brettAccessory = new PersonAttribute();
                brettAccessory.setPerson(brett);
                brettAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(brettAccessory);

                //Attribute 6 - male
                PersonAttribute brettGender = new PersonAttribute();
                brettGender.setPerson(brett);
                brettGender.setAttribute(genderAttMale);
                personAttributeDao.insert(brettGender);

                //Attribute 7 - white Skin
                PersonAttribute brettSkin = new PersonAttribute();
                brettSkin.setPerson(brett);
                brettSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(brettSkin);

                //endregion

                //region // ----- TRUDI ----- //

                //Attribute 1 - has hair
                PersonAttribute trudiHair = new PersonAttribute();
                trudiHair.setPerson(trudi);
                trudiHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(trudiHair);

                //Attribute 1 - brown hair
                PersonAttribute trudiHairColor = new PersonAttribute();
                trudiHairColor.setPerson(trudi);
                trudiHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(trudiHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute trudiFacial = new PersonAttribute();
                trudiFacial.setPerson(trudi);
                trudiFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(trudiFacial);

                //Attribute 3 - brown eyes
                PersonAttribute trudiEyes = new PersonAttribute();
                trudiEyes.setPerson(trudi);
                trudiEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(trudiEyes);

                //Attribute 4 - small nose
                PersonAttribute trudiNose = new PersonAttribute();
                trudiNose.setPerson(trudi);
                trudiNose.setAttribute(noseAttSmall);
                personAttributeDao.insert(trudiNose);

                //Attribute 5 - no accessory
                PersonAttribute trudiAccessory = new PersonAttribute();
                trudiAccessory.setPerson(trudi);
                trudiAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(trudiAccessory);

                //Attribute 6 - female
                PersonAttribute trudiGender = new PersonAttribute();
                trudiGender.setPerson(trudi);
                trudiGender.setAttribute(genderAttFemale);
                personAttributeDao.insert(trudiGender);

                //Attribute 7 - white Skin
                PersonAttribute trudiSkin = new PersonAttribute();
                trudiSkin.setPerson(trudi);
                trudiSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(trudiSkin);

                //endregion

                //region // ----- MAYNARD ----- //

                //Attribute 1 - has hair
                PersonAttribute maynardHair = new PersonAttribute();
                maynardHair.setPerson(maynard);
                maynardHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(maynardHair);

                //Attribute 1a - brown hair
                PersonAttribute maynardHairColor = new PersonAttribute();
                maynardHairColor.setPerson(maynard);
                maynardHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(maynardHairColor);

                //Attribute 2 - has facial hair
                PersonAttribute maynardFacial = new PersonAttribute();
                maynardFacial.setPerson(maynard);
                maynardFacial.setAttribute(facialAttHasHair);
                personAttributeDao.insert(maynardFacial);

                //Attribute 2a - brown facial hair
                PersonAttribute maynardFacialColor = new PersonAttribute();
                maynardFacialColor.setPerson(maynard);
                maynardFacialColor.setAttribute(facialAttBrown);
                personAttributeDao.insert(maynardFacialColor);

                //Attribute 3 - brown eyes
                PersonAttribute maynardEyes = new PersonAttribute();
                maynardEyes.setPerson(maynard);
                maynardEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(maynardEyes);

                //Attribute 4 - large nose
                PersonAttribute maynardNose = new PersonAttribute();
                maynardNose.setPerson(maynard);
                maynardNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(maynardNose);

                //Attribute 5 - no accessory
                PersonAttribute maynardAccessory = new PersonAttribute();
                maynardAccessory.setPerson(maynard);
                maynardAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(maynardAccessory);

                //Attribute 6 - Male
                PersonAttribute maynardGender = new PersonAttribute();
                maynardGender.setPerson(maynard);
                maynardGender.setAttribute(genderAttMale);
                personAttributeDao.insert(maynardGender);

                //Attribute 7 - white Skin
                PersonAttribute maynardSkin = new PersonAttribute();
                maynardSkin.setPerson(maynard);
                maynardSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(maynardSkin);

                //endregion

                //region // ----- VINCENT ----- //

                //Attribute 1 - has hair
                PersonAttribute vincentHair = new PersonAttribute();
                vincentHair.setPerson(vincent);
                vincentHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(vincentHair);

                //Attribute 1 - brown hair
                PersonAttribute vincentHairColor = new PersonAttribute();
                vincentHairColor.setPerson(vincent);
                vincentHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(vincentHairColor);

                //Attribute 2 - no facial hair
                PersonAttribute vincentFacial = new PersonAttribute();
                vincentFacial.setPerson(vincent);
                vincentFacial.setAttribute(facialAttNoHair);
                personAttributeDao.insert(vincentFacial);

                //Attribute 3 - blue eyes
                PersonAttribute vincentEyes = new PersonAttribute();
                vincentEyes.setPerson(vincent);
                vincentEyes.setAttribute(eyesAttBlue);
                personAttributeDao.insert(vincentEyes);

                //Attribute 4 - large nose
                PersonAttribute vincentNose = new PersonAttribute();
                vincentNose.setPerson(vincent);
                vincentNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(vincentNose);

                //Attribute 5 - no accessory
                PersonAttribute vincentAccessory = new PersonAttribute();
                vincentAccessory.setPerson(vincent);
                vincentAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(vincentAccessory);

                //Attribute 6 - male
                PersonAttribute vincentGender = new PersonAttribute();
                vincentGender.setPerson(vincent);
                vincentGender.setAttribute(genderAttMale);
                personAttributeDao.insert(vincentGender);

                //Attribute 7 - white Skin
                PersonAttribute vincentSkin = new PersonAttribute();
                vincentSkin.setPerson(vincent);
                vincentSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(vincentSkin);

                //endregion

                //region // ----- WINSTON ----- //

                //Attribute 1 - has hair
                PersonAttribute winstonHair = new PersonAttribute();
                winstonHair.setPerson(winston);
                winstonHair.setAttribute(hairAttHasHair);
                personAttributeDao.insert(winstonHair);

                //Attribute 1a - brown hair
                PersonAttribute winstonHairColor = new PersonAttribute();
                winstonHairColor.setPerson(winston);
                winstonHairColor.setAttribute(hairAttBrown);
                personAttributeDao.insert(winstonHairColor);

                //Attribute 2 - has facial hair
                PersonAttribute winstonFacial = new PersonAttribute();
                winstonFacial.setPerson(winston);
                winstonFacial.setAttribute(facialAttHasHair);
                personAttributeDao.insert(winstonFacial);

                //Attribute 2a - brown facial hair
                PersonAttribute winstonFacialColor = new PersonAttribute();
                winstonFacialColor.setPerson(winston);
                winstonFacialColor.setAttribute(facialAttBrown);
                personAttributeDao.insert(winstonFacialColor);

                //Attribute 3 - brown eyes
                PersonAttribute winstonEyes = new PersonAttribute();
                winstonEyes.setPerson(winston);
                winstonEyes.setAttribute(eyesAttBrown);
                personAttributeDao.insert(winstonEyes);

                //Attribute 4 - large nose
                PersonAttribute winstonNose = new PersonAttribute();
                winstonNose.setPerson(winston);
                winstonNose.setAttribute(noseAttLarge);
                personAttributeDao.insert(winstonNose);

                //Attribute 5 - no accessory
                PersonAttribute winstonAccessory = new PersonAttribute();
                winstonAccessory.setPerson(winston);
                winstonAccessory.setAttribute(accessoryAttNone);
                personAttributeDao.insert(winstonAccessory);

                //Attribute 6 - Male
                PersonAttribute winstonGender = new PersonAttribute();
                winstonGender.setPerson(winston);
                winstonGender.setAttribute(genderAttMale);
                personAttributeDao.insert(winstonGender);

                //Attribute 7 - white Skin
                PersonAttribute winstonSkin = new PersonAttribute();
                winstonSkin.setPerson(winston);
                winstonSkin.setAttribute(skinAttWhite);
                personAttributeDao.insert(winstonSkin);

                //endregion

                //endregion
            }
        });

        Log.d("debug_db", "database finished seeding");
    }
}
