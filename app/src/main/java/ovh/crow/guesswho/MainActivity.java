package ovh.crow.guesswho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seedDatabase();
    }


    private void seedDatabase() {

        //Get Session
        DaoSession daoSession = ((App) getApplication()).getDaoSession();

        //Get All tables
        PersonDao personDao = daoSession.getPersonDao();
        PersonAttributeDao personAttributeDao = daoSession.getPersonAttributeDao();
        ModifiersDao modifiersDao = daoSession.getModifiersDao();
        AttributeDao attributeDao = daoSession.getAttributeDao();
        AreasDao areasDao = daoSession.getAreasDao();

        //region // ----- SEED AREAS ------ //
        // ------------------------------------ //
        // ------------ SEED AREAS ------------ //
        // ------------------------------------ //
        List<Areas> areasList = new ArrayList<>();

        //AREA 1
        Areas areaHair = new Areas();
        areaHair.setName("Hair");
        areasList.add(areaHair);

        //AREA 2
        Areas areaFacialHair = new Areas();
        areaFacialHair.setName("FacialHair");
        areasList.add(areaFacialHair);

        //AREA 3
        Areas areaEyes = new Areas();
        areaEyes.setName("Eyes");
        areasList.add(areaEyes);

        //AREA 4
        Areas areaNose = new Areas();
        areaNose.setName("Nose");
        areasList.add(areaNose);

        //AREA 5
        Areas areaGender = new Areas();
        areaGender.setName("Gender");
        areasList.add(areaGender);

        //AREA 6
        Areas areaSkinTone = new Areas();
        areaSkinTone.setName("SkinTone");
        areasList.add(areaSkinTone);

        //AREA 7
        Areas areaAccessory = new Areas();
        areaAccessory.setName("Accessory");
        areasList.add(areaAccessory);

        //Insert in DB
        areasDao.insertInTx(areasList);

        //endregion

        //region // ----- SEED MODIFIERS ------ //
        // ------------------------------------ //
        // ---------- SEED MODIFIERS ---------- //
        // ------------------------------------ //
        List<Modifiers> modifiersList = new ArrayList<>();

        //Modifier 1
        Modifiers modifierBlond = new Modifiers();
        modifierBlond.setName("Blond");
        modifiersList.add(modifierBlond);

        //Modifier 2
        Modifiers modifierBrown = new Modifiers();
        modifierBrown.setName("Brown");
        modifiersList.add(modifierBrown);

        //Modifier 3
        Modifiers modifierNoHair = new Modifiers();
        modifierNoHair.setName("NoHair");
        modifiersList.add(modifierNoHair);

        //Modifier 4
        Modifiers modifierHasHair = new Modifiers();
        modifierHasHair.setName("HasHair");
        modifiersList.add(modifierHasHair);

        //Modifier 5
        Modifiers modifierHasFacialHair = new Modifiers();
        modifierHasFacialHair.setName("HasFacialHair");
        modifiersList.add(modifierHasFacialHair);

        //Modifier 6
        Modifiers modifierNoFacialHair = new Modifiers();
        modifierNoFacialHair.setName("NoFacialHair");
        modifiersList.add(modifierNoFacialHair);

        //Modifier 7
        Modifiers modifierOrange = new Modifiers();
        modifierOrange.setName("Orange");
        modifiersList.add(modifierOrange);

        //Modifier 8
        Modifiers modifierBlack = new Modifiers();
        modifierBlack.setName("Black");
        modifiersList.add(modifierBlack);

        //Modifier 9
        Modifiers modifierBlue = new Modifiers();
        modifierBlue.setName("Blue");
        modifiersList.add(modifierBlue);

        //Modifier 10
        Modifiers modifierWhite = new Modifiers();
        modifierWhite.setName("White");
        modifiersList.add(modifierWhite);

        //Modifier 11
        Modifiers modifierGlasses = new Modifiers();
        modifierGlasses.setName("Glasses");
        modifiersList.add(modifierGlasses);

        //Modifier 12
        Modifiers modifierMask = new Modifiers();
        modifierMask.setName("Mask");
        modifiersList.add(modifierMask);

        //Modifier 13
        Modifiers modifierMale = new Modifiers();
        modifierMale.setName("Male");
        modifiersList.add(modifierMale);

        //Modifier 14
        Modifiers modifierFemale = new Modifiers();
        modifierFemale.setName("Female");
        modifiersList.add(modifierFemale);

        //Modifier 15
        Modifiers modifierLarge = new Modifiers();
        modifierLarge.setName("Large");
        modifiersList.add(modifierLarge);

        //Modifier 16
        Modifiers modifierSmall = new Modifiers();
        modifierSmall.setName("Small");
        modifiersList.add(modifierSmall);

        //Modifier 17
        Modifiers modifierNone = new Modifiers();
        modifierNone.setName("None");
        modifiersList.add(modifierNone);

        //Insert in DB
        modifiersDao.insertInTx(modifiersList);
        //endregion

        //region // ----- SEED ATTRIBUTES ----- //
        // ------------------------------------ //
        // --------- SEED ATTRIBUTES ---------- //
        // ------------------------------------ //
        List<Attribute> attributeList = new ArrayList<>();

        //region // ----- HAIR ----- //

        //Attribute 1 - Brown
        Attribute hairAttBrown = new Attribute();
        hairAttBrown.setArea(areaHair);
        hairAttBrown.setModifier(modifierBrown);
        attributeList.add(hairAttBrown);

        //Attribute 2 - Blond
        Attribute hairAttBlond = new Attribute();
        hairAttBlond.setArea(areaHair);
        hairAttBlond.setModifier(modifierBlond);
        attributeList.add(hairAttBlond);

        //Attribute 3 - Black
        Attribute hairAttBlack = new Attribute();
        hairAttBlack.setArea(areaHair);
        hairAttBlack.setModifier(modifierBlue);
        attributeList.add(hairAttBlack);

        //Attribute 4 - Orange
        Attribute hairAttOrange = new Attribute();
        hairAttOrange.setArea(areaHair);
        hairAttOrange.setModifier(modifierOrange);
        attributeList.add(hairAttOrange);

        //Attribute 5 - No Hair
        Attribute hairAttNoHair = new Attribute();
        hairAttNoHair.setArea(areaHair);
        hairAttNoHair.setModifier(modifierNoHair);
        attributeList.add(hairAttNoHair);

        //Attribute 6 - Has Hair
        Attribute hairAttHasHair = new Attribute();
        hairAttHasHair.setArea(areaHair);
        hairAttHasHair.setModifier(modifierHasHair);
        attributeList.add(hairAttHasHair);

        //endregion

        //region // ----- FACIAL HAIR ----- //

        //Attribute 1 - No Hair
        Attribute facialAttNoHair = new Attribute();
        facialAttNoHair.setArea(areaFacialHair);
        facialAttNoHair.setModifier(modifierNoFacialHair);
        attributeList.add(facialAttNoHair);

        //Attribute 2 - Has Hair
        Attribute facialAttHasHair = new Attribute();
        facialAttHasHair.setArea(areaFacialHair);
        facialAttHasHair.setModifier(modifierHasFacialHair);
        attributeList.add(facialAttHasHair);

        //Attribute 3 - Orange
        Attribute facialAttOrange = new Attribute();
        facialAttOrange.setArea(areaFacialHair);
        facialAttOrange.setModifier(modifierOrange);
        attributeList.add(facialAttOrange);

        //Attribute 4 - Black
        Attribute facialAttBlack = new Attribute();
        facialAttBlack.setArea(areaFacialHair);
        facialAttBlack.setModifier(modifierBlack);
        attributeList.add(facialAttBlack);

        //Attribute 5 - Brown
        Attribute facialAttBrown = new Attribute();
        facialAttBrown.setArea(areaFacialHair);
        facialAttBrown.setModifier(modifierBrown);
        attributeList.add(facialAttBrown);

        //endregion

        //region // ----- EYES ----- //

        //Attribute 1 - Blue
        Attribute eyesAttBlue = new Attribute();
        eyesAttBlue.setArea(areaEyes);
        eyesAttBlue.setModifier(modifierBlue);
        attributeList.add(eyesAttBlue);

        //Attribute 2 - Brown
        Attribute eyesAttBrown = new Attribute();
        eyesAttBrown.setArea(areaEyes);
        eyesAttBrown.setModifier(modifierBrown);
        attributeList.add(eyesAttBrown);

        //endregion

        //region // ----- NOSE ----- //

        //Attribute 1 - Large
        Attribute noseAttLarge = new Attribute();
        noseAttLarge.setArea(areaNose);
        noseAttLarge.setModifier(modifierLarge);
        attributeList.add(noseAttLarge);

        //Attribute 2 - Small
        Attribute noseAttSmall = new Attribute();
        noseAttSmall.setArea(areaNose);
        noseAttSmall.setModifier(modifierNone);
        attributeList.add(noseAttSmall);

        //endregion

        //region // ----- GENDER ----- //

        //Attribute 1 - Female
        Attribute genderAttFemale = new Attribute();
        genderAttFemale.setArea(areaGender);
        genderAttFemale.setModifier(modifierFemale);
        attributeList.add(genderAttFemale);

        //Attribute 2 - Male
        Attribute genderAttMale = new Attribute();
        genderAttMale.setArea(areaGender);
        genderAttMale.setModifier(modifierMale);
        attributeList.add(genderAttMale);

        //endregion

        //region // ----- SKIN TONE ----- //

        //Attribute 1 - Brown
        Attribute skinAttBrown = new Attribute();
        skinAttBrown.setArea(areaSkinTone);
        skinAttBrown.setModifier(modifierBrown);
        attributeList.add(skinAttBrown);

        //Attribute 2 - White
        Attribute skinAttWhite = new Attribute();
        skinAttWhite.setArea(areaSkinTone);
        skinAttWhite.setModifier(modifierWhite);
        attributeList.add(skinAttWhite);

        //endregion

        //region // ----- ACCESSORY ----- //

        //Attribute 1 - Glasses
        Attribute accessoryAttGlasses = new Attribute();
        accessoryAttGlasses.setArea(areaAccessory);
        accessoryAttGlasses.setModifier(modifierGlasses);
        attributeList.add(accessoryAttGlasses);

        //Attribute 2 - Mask
        Attribute accessoryAttMask = new Attribute();
        accessoryAttMask.setArea(areaAccessory);
        accessoryAttMask.setModifier(modifierMask);
        attributeList.add(accessoryAttMask);

        //Attribute 2 - None
        Attribute accessoryAttNone = new Attribute();
        accessoryAttNone.setArea(areaAccessory);
        accessoryAttNone.setModifier(modifierNone);
        attributeList.add(accessoryAttNone);

        //endregion

        attributeDao.insertInTx(attributeList);

        //endregion

        //region // ----- SEED PERSONS ----- //
        // ------------------------------------ //
        // ----------- SEED PERSONS ----------- //
        // ------------------------------------ //
        List<Person> personList = new ArrayList<>();

        Person paul = new Person();
        paul.setName("Paul");
        paul.setImgName("IMG_poul");
        personList.add(paul);

        Person jody = new Person();
        jody.setName("Jody");
        jody.setImgName("IMG_jody");
        personList.add(jody);

        Person marcellus = new Person();
        marcellus.setName("Marcellus");
        marcellus.setImgName("IMG_marcellus");
        personList.add(marcellus);

        Person jimmie = new Person();
        jimmie.setName("Jimmie");
        jimmie.setImgName("IMG_jimmie");
        personList.add(jimmie);

        Person esmeralda = new Person();
        esmeralda.setName("Esmeralda");
        esmeralda.setImgName("IMG_esmeralda");
        personList.add(esmeralda);

        Person captKoons = new Person();
        captKoons.setName("Captain Koons");
        captKoons.setImgName("IMG_captain_koons");
        personList.add(captKoons);

        Person jules = new Person();
        jules.setName("Jules");
        jules.setImgName("IMG_jules");
        personList.add(jules);

        Person buddy = new Person();
        buddy.setName("Buddy");
        buddy.setImgName("IMG_boddy");
        personList.add(buddy);

        Person gimp = new Person();
        gimp.setName("The Gimp");
        gimp.setImgName("IMG_the_gimp");
        personList.add(gimp);

        Person yolanda = new Person();
        yolanda.setName("Yolanda");
        yolanda.setImgName("IMG_yolanda");
        personList.add(yolanda);

        Person roger = new Person();
        roger.setName("Roger");
        roger.setImgName("IMG_roger");
        personList.add(roger);

        Person fabienne = new Person();
        fabienne.setName("Fabienne");
        fabienne.setImgName("IMG_fabienne");
        personList.add(fabienne);

        Person ringo = new Person();
        ringo.setName("Ringo");
        ringo.setImgName("IMG_ringo");
        personList.add(ringo);

        Person raquel = new Person();
        raquel.setName("Raquel");
        raquel.setImgName("IMG_raquel");
        personList.add(raquel);

        Person lance = new Person();
        lance.setName("Lance");
        lance.setImgName("IMG_lance");
        personList.add(lance);

        Person butch = new Person();
        butch.setName("Butch");
        butch.setImgName("IMG_butch");
        personList.add(butch);

        Person mia = new Person();
        mia.setName("Mia");
        mia.setImgName("IMG_mia");
        personList.add(mia);

        Person marvin = new Person();
        marvin.setName("Marvin");
        marvin.setImgName("IMG_marvin");
        personList.add(marvin);

        Person zed = new Person();
        zed.setName("Zed");
        zed.setImgName("IMG_zed");
        personList.add(zed);

        Person brett = new Person();
        brett.setName("Brett");
        brett.setImgName("IMG_brett");
        personList.add(brett);

        Person trudi = new Person();
        trudi.setName("Trudi");
        trudi.setImgName("IMG_trudi");
        personList.add(trudi);

        Person maynard = new Person();
        maynard.setName("Maynard");
        maynard.setImgName("IMG_maynard");
        personList.add(maynard);

        Person vincent = new Person();
        vincent.setName("Vincent");
        vincent.setImgName("IMG_vincent");
        personList.add(vincent);

        Person winston = new Person();
        winston.setName("Winston");
        winston.setImgName("IMG_winston");
        personList.add(winston);

        personDao.insertInTx(personList);

        //endregion

        //region // ----- SEED PERSON ATTRIBUTES ----- //
        // ------------------------------------ //
        // ------ SEED PERSON ATTRIBUTES ------ //
        // ------------------------------------ //
        List<PersonAttribute> personAttributesList = new ArrayList<>();


        //region // ----- POUL ----- //

        //Attribute 1 - has hair
        PersonAttribute paulHair = new PersonAttribute();
        paulHair.setPerson(paul);
        paulHair.setAttribute(hairAttHasHair);
        personAttributesList.add(paulHair);

        //Attribute 1a - black hair
        PersonAttribute paulHairColor = new PersonAttribute();
        paulHairColor.setPerson(paul);
        paulHairColor.setAttribute(hairAttBlack);
        personAttributesList.add(paulHairColor);

        //Attribute 2 - has facial hair
        PersonAttribute paulFacial = new PersonAttribute();
        paulFacial.setPerson(paul);
        paulFacial.setAttribute(facialAttHasHair);
        personAttributesList.add(paulFacial);

        //Attribute 2a - black facial hair
        PersonAttribute paulFacialColor = new PersonAttribute();
        paulFacialColor.setPerson(paul);
        paulFacialColor.setAttribute(facialAttBlack);
        personAttributesList.add(paulFacialColor);

        //Attribute 3 - brown eyes
        PersonAttribute paulEyes = new PersonAttribute();
        paulEyes.setPerson(paul);
        paulEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(paulEyes);

        //Attribute 4 - large nose
        PersonAttribute paulNose = new PersonAttribute();
        paulNose.setPerson(paul);
        paulNose.setAttribute(noseAttLarge);
        personAttributesList.add(paulNose);

        //Attribute 5 - no accessory
        PersonAttribute paulAccessory = new PersonAttribute();
        paulAccessory.setPerson(paul);
        paulAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(paulAccessory);

        //Attribute 6 - Male
        PersonAttribute paulGender = new PersonAttribute();
        paulGender.setPerson(paul);
        paulGender.setAttribute(genderAttMale);
        personAttributesList.add(paulGender);

        //Attribute 7 - Brown Skin
        PersonAttribute paulSkin = new PersonAttribute();
        paulSkin.setPerson(paul);
        paulSkin.setAttribute(skinAttBrown);
        personAttributesList.add(paulSkin);

        //endregion

        //region // ----- JODY ----- //

        //Attribute 1 - has hair
        PersonAttribute jodyHair = new PersonAttribute();
        jodyHair.setPerson(jody);
        jodyHair.setAttribute(hairAttHasHair);
        personAttributesList.add(jodyHair);

        //Attribute 1 - blond hair
        PersonAttribute jodyHairColor = new PersonAttribute();
        jodyHairColor.setPerson(jody);
        jodyHairColor.setAttribute(hairAttBlond);
        personAttributesList.add(jodyHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute jodyFacial = new PersonAttribute();
        jodyFacial.setPerson(jody);
        jodyFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(jodyFacial);

        //Attribute 3 - blue eyes
        PersonAttribute jodyEyes = new PersonAttribute();
        jodyEyes.setPerson(jody);
        jodyEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(jodyEyes);

        //Attribute 4 - small nose
        PersonAttribute jodyNose = new PersonAttribute();
        jodyNose.setPerson(jody);
        jodyNose.setAttribute(noseAttSmall);
        personAttributesList.add(jodyNose);

        //Attribute 5 - no accessory
        PersonAttribute jodyAccessory = new PersonAttribute();
        jodyAccessory.setPerson(jody);
        jodyAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(jodyAccessory);

        //Attribute 6 - female
        PersonAttribute jodyGender = new PersonAttribute();
        jodyGender.setPerson(jody);
        jodyGender.setAttribute(genderAttFemale);
        personAttributesList.add(jodyGender);

        //Attribute 7 - white Skin
        PersonAttribute jodySkin = new PersonAttribute();
        jodySkin.setPerson(jody);
        jodySkin.setAttribute(skinAttWhite);
        personAttributesList.add(jodySkin);

        //endregion

        //region // ----- MARCELLUS ----- //

        //Attribute 1 - no hair
        PersonAttribute marcellusHair = new PersonAttribute();
        marcellusHair.setPerson(marcellus);
        marcellusHair.setAttribute(hairAttNoHair);
        personAttributesList.add(marcellusHair);

        //Attribute 2 - facial hair
        PersonAttribute marcellusFacial = new PersonAttribute();
        marcellusFacial.setPerson(marcellus);
        marcellusFacial.setAttribute(facialAttHasHair);
        personAttributesList.add(marcellusFacial);

        //Attribute 2a - black facial hair
        PersonAttribute marcellusFacialColor = new PersonAttribute();
        marcellusFacialColor.setPerson(marcellus);
        marcellusFacialColor.setAttribute(facialAttBlack);
        personAttributesList.add(marcellusFacialColor);

        //Attribute 3 - brown eyes
        PersonAttribute marcellusEyes = new PersonAttribute();
        marcellusEyes.setPerson(marcellus);
        marcellusEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(marcellusEyes);

        //Attribute 4 - large nose
        PersonAttribute marcellusNose = new PersonAttribute();
        marcellusNose.setPerson(marcellus);
        marcellusNose.setAttribute(noseAttLarge);
        personAttributesList.add(marcellusNose);

        //Attribute 5 - no accessory
        PersonAttribute marcellusAccessory= new PersonAttribute();
        marcellusAccessory.setPerson(marcellus);
        marcellusAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(marcellusAccessory);

        //Attribute 6 - male
        PersonAttribute marcellusGender = new PersonAttribute();
        marcellusGender.setPerson(marcellus);
        marcellusGender.setAttribute(genderAttMale);
        personAttributesList.add(marcellusGender);

        //Attribute 7 - brown Skin
        PersonAttribute marcellusSkin = new PersonAttribute();
        marcellusSkin.setPerson(marcellus);
        marcellusSkin.setAttribute(skinAttBrown);
        personAttributesList.add(marcellusSkin);

        //endregion

        //region // ----- JIMMIE ----- //

        //Attribute 1 - has hair
        PersonAttribute jimmieHair = new PersonAttribute();
        jimmieHair.setPerson(jimmie);
        jimmieHair.setAttribute(hairAttHasHair);
        personAttributesList.add(jimmieHair);

        //Attribute 1 - brown hair
        PersonAttribute jimmieHairColor = new PersonAttribute();
        jimmieHairColor.setPerson(jimmie);
        jimmieHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(jimmieHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute jimmieFacial = new PersonAttribute();
        jimmieFacial.setPerson(jimmie);
        jimmieFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(jimmieFacial);

        //Attribute 3 - brown eyes
        PersonAttribute jimmieEyes = new PersonAttribute();
        jimmieEyes.setPerson(jimmie);
        jimmieEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(jimmieEyes);

        //Attribute 4 - small nose
        PersonAttribute jimmieNose = new PersonAttribute();
        jimmieNose.setPerson(jimmie);
        jimmieNose.setAttribute(noseAttSmall);
        personAttributesList.add(jimmieNose);

        //Attribute 5 - no accessory
        PersonAttribute jimmieAccessory = new PersonAttribute();
        jimmieAccessory.setPerson(jimmie);
        jimmieAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(jimmieAccessory);

        //Attribute 6 - male
        PersonAttribute jimmieGender = new PersonAttribute();
        jimmieGender.setPerson(jimmie);
        jimmieGender.setAttribute(genderAttMale);
        personAttributesList.add(jimmieGender);

        //Attribute 7 - white Skin
        PersonAttribute jimmieSkin = new PersonAttribute();
        jimmieSkin.setPerson(jimmie);
        jimmieSkin.setAttribute(skinAttWhite);
        personAttributesList.add(jimmieSkin);

        //endregion

        //region // ----- ESMERALDA ----- //

        //Attribute 1 - has hair
        PersonAttribute esmeraldaHair = new PersonAttribute();
        esmeraldaHair.setPerson(esmeralda);
        esmeraldaHair.setAttribute(hairAttHasHair);
        personAttributesList.add(esmeraldaHair);

        //Attribute 1 - brown hair
        PersonAttribute esmeraldaHairColor = new PersonAttribute();
        esmeraldaHairColor.setPerson(esmeralda);
        esmeraldaHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(esmeraldaHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute esmeraldaFacial = new PersonAttribute();
        esmeraldaFacial.setPerson(esmeralda);
        esmeraldaFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(esmeraldaFacial);

        //Attribute 3 - brown eyes
        PersonAttribute esmeraldaEyes = new PersonAttribute();
        esmeraldaEyes.setPerson(esmeralda);
        esmeraldaEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(esmeraldaEyes);

        //Attribute 4 - small nose
        PersonAttribute esmeraldaNose = new PersonAttribute();
        esmeraldaNose.setPerson(esmeralda);
        esmeraldaNose.setAttribute(noseAttSmall);
        personAttributesList.add(esmeraldaNose);

        //Attribute 5 - no accessory
        PersonAttribute esmeraldaAccessory = new PersonAttribute();
        esmeraldaAccessory.setPerson(esmeralda);
        esmeraldaAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(esmeraldaAccessory);

        //Attribute 6 - female
        PersonAttribute esmeraldaGender = new PersonAttribute();
        esmeraldaGender.setPerson(esmeralda);
        esmeraldaGender.setAttribute(genderAttFemale);
        personAttributesList.add(esmeraldaGender);

        //Attribute 7 - white Skin
        PersonAttribute esmeraldaSkin = new PersonAttribute();
        esmeraldaSkin.setPerson(esmeralda);
        esmeraldaSkin.setAttribute(skinAttWhite);
        personAttributesList.add(esmeraldaSkin);

        //endregion

        //region // ----- CAPTAIN KOONS ----- //

        //Attribute 1 - has hair
        PersonAttribute captKoonsHair = new PersonAttribute();
        captKoonsHair.setPerson(captKoons);
        captKoonsHair.setAttribute(hairAttHasHair);
        personAttributesList.add(captKoonsHair);

        //Attribute 1 - brown hair
        PersonAttribute captKoonsHairColor = new PersonAttribute();
        captKoonsHairColor.setPerson(captKoons);
        captKoonsHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(captKoonsHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute captKoonsFacial = new PersonAttribute();
        captKoonsFacial.setPerson(captKoons);
        captKoonsFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(captKoonsFacial);

        //Attribute 3 - blue eyes
        PersonAttribute captKoonsEyes = new PersonAttribute();
        captKoonsEyes.setPerson(captKoons);
        captKoonsEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(captKoonsEyes);

        //Attribute 4 - small nose
        PersonAttribute captKoonsNose = new PersonAttribute();
        captKoonsNose.setPerson(captKoons);
        captKoonsNose.setAttribute(noseAttSmall);
        personAttributesList.add(captKoonsNose);

        //Attribute 5 - no accessory
        PersonAttribute captKoonsAccessory = new PersonAttribute();
        captKoonsAccessory.setPerson(captKoons);
        captKoonsAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(captKoonsAccessory);

        //Attribute 6 - male
        PersonAttribute captKoonsGender = new PersonAttribute();
        captKoonsGender.setPerson(captKoons);
        captKoonsGender.setAttribute(genderAttMale);
        personAttributesList.add(captKoonsGender);

        //Attribute 7 - white Skin
        PersonAttribute captKoonsSkin = new PersonAttribute();
        captKoonsSkin.setPerson(captKoons);
        captKoonsSkin.setAttribute(skinAttWhite);
        personAttributesList.add(captKoonsSkin);

        //endregion

        //region // ----- JULES ----- //

        //Attribute 1 - has hair
        PersonAttribute julesHair = new PersonAttribute();
        julesHair.setPerson(jules);
        julesHair.setAttribute(hairAttHasHair);
        personAttributesList.add(julesHair);

        //Attribute 1a - black hair
        PersonAttribute julesHairColor = new PersonAttribute();
        julesHairColor.setPerson(jules);
        julesHairColor.setAttribute(hairAttBlack);
        personAttributesList.add(julesHairColor);

        //Attribute 2 - has facial hair
        PersonAttribute julesFacial = new PersonAttribute();
        julesFacial.setPerson(jules);
        julesFacial.setAttribute(facialAttHasHair);
        personAttributesList.add(julesFacial);

        //Attribute 2a - black facial hair
        PersonAttribute julesFacialColor = new PersonAttribute();
        julesFacialColor.setPerson(jules);
        julesFacialColor.setAttribute(facialAttBlack);
        personAttributesList.add(julesFacialColor);

        //Attribute 3 - brown eyes
        PersonAttribute julesEyes = new PersonAttribute();
        julesEyes.setPerson(jules);
        julesEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(julesEyes);

        //Attribute 4 - large nose
        PersonAttribute julesNose = new PersonAttribute();
        julesNose.setPerson(jules);
        julesNose.setAttribute(noseAttLarge);
        personAttributesList.add(julesNose);

        //Attribute 5 - no accessory
        PersonAttribute julesAccessory = new PersonAttribute();
        julesAccessory.setPerson(jules);
        julesAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(julesAccessory);

        //Attribute 6 - Male
        PersonAttribute julesGender = new PersonAttribute();
        julesGender.setPerson(jules);
        julesGender.setAttribute(genderAttMale);
        personAttributesList.add(julesGender);

        //Attribute 7 - Brown Skin
        PersonAttribute julesSkin = new PersonAttribute();
        julesSkin.setPerson(jules);
        julesSkin.setAttribute(skinAttBrown);
        personAttributesList.add(julesSkin);

        //endregion

        //region // ----- BUDDY ----- //

        //Attribute 1 - has hair
        PersonAttribute buddyHair = new PersonAttribute();
        buddyHair.setPerson(buddy);
        buddyHair.setAttribute(hairAttHasHair);
        personAttributesList.add(buddyHair);

        //Attribute 1 - brown hair
        PersonAttribute buddyHairColor = new PersonAttribute();
        buddyHairColor.setPerson(buddy);
        buddyHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(buddyHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute buddyFacial = new PersonAttribute();
        buddyFacial.setPerson(buddy);
        buddyFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(buddyFacial);

        //Attribute 3 - blue eyes
        PersonAttribute buddyEyes = new PersonAttribute();
        buddyEyes.setPerson(buddy);
        buddyEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(buddyEyes);

        //Attribute 4 - small nose
        PersonAttribute buddyNose = new PersonAttribute();
        buddyNose.setPerson(buddy);
        buddyNose.setAttribute(noseAttSmall);
        personAttributesList.add(buddyNose);

        //Attribute 5 - no accessory
        PersonAttribute buddyAccessory = new PersonAttribute();
        buddyAccessory.setPerson(buddy);
        buddyAccessory.setAttribute(accessoryAttGlasses);
        personAttributesList.add(buddyAccessory);

        //Attribute 6 - male
        PersonAttribute buddyGender = new PersonAttribute();
        buddyGender.setPerson(buddy);
        buddyGender.setAttribute(genderAttMale);
        personAttributesList.add(buddyGender);

        //Attribute 7 - white Skin
        PersonAttribute buddySkin = new PersonAttribute();
        buddySkin.setPerson(buddy);
        buddySkin.setAttribute(skinAttWhite);
        personAttributesList.add(buddySkin);

        //endregion

        //region // ----- GIMP ----- //

        //Attribute 1 - has hair
        PersonAttribute gtmpHair = new PersonAttribute();
        gtmpHair.setPerson(gimp);
        gtmpHair.setAttribute(hairAttNoHair);
        personAttributesList.add(gtmpHair);


        //Attribute 2 - no facial hair
        PersonAttribute gimpFacial = new PersonAttribute();
        gimpFacial.setPerson(gimp);
        gimpFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(gimpFacial);

        //Attribute 3 - blue eyes
        PersonAttribute gimpEyes = new PersonAttribute();
        gimpEyes.setPerson(gimp);
        gimpEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(gimpEyes);

        //Attribute 4 - small nose
        PersonAttribute gimpNose = new PersonAttribute();
        gimpNose.setPerson(gimp);
        gimpNose.setAttribute(noseAttLarge);
        personAttributesList.add(gimpNose);

        //Attribute 5 - no accessory
        PersonAttribute gimpAccessory = new PersonAttribute();
        gimpAccessory.setPerson(gimp);
        gimpAccessory.setAttribute(accessoryAttMask);
        personAttributesList.add(gimpAccessory);

        //Attribute 6 - male
        PersonAttribute gimpGender = new PersonAttribute();
        gimpGender.setPerson(gimp);
        gimpGender.setAttribute(genderAttMale);
        personAttributesList.add(gimpGender);

        //Attribute 7 - white Skin
        PersonAttribute gimpSkin = new PersonAttribute();
        gimpSkin.setPerson(gimp);
        gimpSkin.setAttribute(skinAttWhite);
        personAttributesList.add(gimpSkin);

        //endregion

        //region // ----- YOLANDA ----- //

        //Attribute 1 - has hair
        PersonAttribute yolandaHair = new PersonAttribute();
        yolandaHair.setPerson(yolanda);
        yolandaHair.setAttribute(hairAttHasHair);
        personAttributesList.add(yolandaHair);

        //Attribute 1 - orange hair
        PersonAttribute yolandaHairColor = new PersonAttribute();
        yolandaHairColor.setPerson(yolanda);
        yolandaHairColor.setAttribute(hairAttOrange);
        personAttributesList.add(yolandaHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute yolandaFacial = new PersonAttribute();
        yolandaFacial.setPerson(yolanda);
        yolandaFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(yolandaFacial);

        //Attribute 3 - brown eyes
        PersonAttribute yolandaEyes = new PersonAttribute();
        yolandaEyes.setPerson(yolanda);
        yolandaEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(yolandaEyes);

        //Attribute 4 - large nose
        PersonAttribute yolandaNose = new PersonAttribute();
        yolandaNose.setPerson(yolanda);
        yolandaNose.setAttribute(noseAttLarge);
        personAttributesList.add(yolandaNose);

        //Attribute 5 - no accessory
        PersonAttribute yolandaAccessory = new PersonAttribute();
        yolandaAccessory.setPerson(yolanda);
        yolandaAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(yolandaAccessory);

        //Attribute 6 - female
        PersonAttribute yolandaGender = new PersonAttribute();
        yolandaGender.setPerson(yolanda);
        yolandaGender.setAttribute(genderAttFemale);
        personAttributesList.add(yolandaGender);

        //Attribute 7 - white Skin
        PersonAttribute yolandaSkin = new PersonAttribute();
        yolandaSkin.setPerson(yolanda);
        yolandaSkin.setAttribute(skinAttWhite);
        personAttributesList.add(yolandaSkin);

        //endregion

        //region // ----- ROGER ----- //

        //Attribute 1 - has hair
        PersonAttribute rogerHair = new PersonAttribute();
        rogerHair.setPerson(roger);
        rogerHair.setAttribute(hairAttHasHair);
        personAttributesList.add(rogerHair);

        //Attribute 1 - blond hair
        PersonAttribute rogerHairColor = new PersonAttribute();
        rogerHairColor.setPerson(roger);
        rogerHairColor.setAttribute(hairAttBlond);
        personAttributesList.add(rogerHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute rogerFacial = new PersonAttribute();
        rogerFacial.setPerson(roger);
        rogerFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(rogerFacial);

        //Attribute 3 - brown eyes
        PersonAttribute rogerEyes = new PersonAttribute();
        rogerEyes.setPerson(roger);
        rogerEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(rogerEyes);

        //Attribute 4 - small nose
        PersonAttribute rogerNose = new PersonAttribute();
        rogerNose.setPerson(roger);
        rogerNose.setAttribute(noseAttSmall);
        personAttributesList.add(rogerNose);

        //Attribute 5 - no accessory
        PersonAttribute rogerAccessory = new PersonAttribute();
        rogerAccessory.setPerson(roger);
        rogerAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(rogerAccessory);

        //Attribute 6 - male
        PersonAttribute rogerGender = new PersonAttribute();
        rogerGender.setPerson(roger);
        rogerGender.setAttribute(genderAttMale);
        personAttributesList.add(rogerGender);

        //Attribute 7 - white Skin
        PersonAttribute rogerSkin = new PersonAttribute();
        rogerSkin.setPerson(roger);
        rogerSkin.setAttribute(skinAttWhite);
        personAttributesList.add(rogerSkin);

        //endregion

        //region // ----- FABIENNE ----- //

        //Attribute 1 - has hair
        PersonAttribute fabienneHair = new PersonAttribute();
        fabienneHair.setPerson(fabienne);
        fabienneHair.setAttribute(hairAttHasHair);
        personAttributesList.add(fabienneHair);

        //Attribute 1 - black hair
        PersonAttribute fabienneHairColor = new PersonAttribute();
        fabienneHairColor.setPerson(fabienne);
        fabienneHairColor.setAttribute(hairAttBlack);
        personAttributesList.add(fabienneHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute fabienneFacial = new PersonAttribute();
        fabienneFacial.setPerson(fabienne);
        fabienneFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(fabienneFacial);

        //Attribute 3 - blue eyes
        PersonAttribute fabienneEyes = new PersonAttribute();
        fabienneEyes.setPerson(fabienne);
        fabienneEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(fabienneEyes);

        //Attribute 4 - small nose
        PersonAttribute fabienneNose = new PersonAttribute();
        fabienneNose.setPerson(fabienne);
        fabienneNose.setAttribute(noseAttSmall);
        personAttributesList.add(fabienneNose);

        //Attribute 5 - no accessory
        PersonAttribute fabienneAccessory = new PersonAttribute();
        fabienneAccessory.setPerson(fabienne);
        fabienneAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(fabienneAccessory);

        //Attribute 6 - female
        PersonAttribute fabienneGender = new PersonAttribute();
        fabienneGender.setPerson(fabienne);
        fabienneGender.setAttribute(genderAttFemale);
        personAttributesList.add(fabienneGender);

        //Attribute 7 - white Skin
        PersonAttribute fabienneSkin = new PersonAttribute();
        fabienneSkin.setPerson(fabienne);
        fabienneSkin.setAttribute(skinAttWhite);
        personAttributesList.add(fabienneSkin);

        //endregion

        //region // ----- RINGO ----- //

        //Attribute 1 - has hair
        PersonAttribute ringoHair = new PersonAttribute();
        ringoHair.setPerson(ringo);
        ringoHair.setAttribute(hairAttHasHair);
        personAttributesList.add(ringoHair);

        //Attribute 1 - blond hair
        PersonAttribute ringoHairColor = new PersonAttribute();
        ringoHairColor.setPerson(ringo);
        ringoHairColor.setAttribute(hairAttBlond);
        personAttributesList.add(ringoHairColor);

        //Attribute 2 - has facial hair
        PersonAttribute ringoFacial = new PersonAttribute();
        ringoFacial.setPerson(ringo);
        ringoFacial.setAttribute(facialAttHasHair);
        personAttributesList.add(ringoFacial);

        //Attribute 3 - blue eyes
        PersonAttribute ringoEyes = new PersonAttribute();
        ringoEyes.setPerson(ringo);
        ringoEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(ringoEyes);

        //Attribute 4 - large nose
        PersonAttribute ringoNose = new PersonAttribute();
        ringoNose.setPerson(ringo);
        ringoNose.setAttribute(noseAttLarge);
        personAttributesList.add(ringoNose);

        //Attribute 5 - no accessory
        PersonAttribute ringoAccessory = new PersonAttribute();
        ringoAccessory.setPerson(ringo);
        ringoAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(ringoAccessory);

        //Attribute 6 - male
        PersonAttribute ringoGender = new PersonAttribute();
        ringoGender.setPerson(ringo);
        ringoGender.setAttribute(genderAttMale);
        personAttributesList.add(ringoGender);

        //Attribute 7 - white Skin
        PersonAttribute ringoSkin = new PersonAttribute();
        ringoSkin.setPerson(ringo);
        ringoSkin.setAttribute(skinAttWhite);
        personAttributesList.add(ringoSkin);

        //endregion

        //region // ----- RAQUEL ----- //

        //Attribute 1 - has hair
        PersonAttribute raquelHair = new PersonAttribute();
        raquelHair.setPerson(raquel);
        raquelHair.setAttribute(hairAttHasHair);
        personAttributesList.add(raquelHair);

        //Attribute 1 - orange hair
        PersonAttribute raquelHairColor = new PersonAttribute();
        raquelHairColor.setPerson(raquel);
        raquelHairColor.setAttribute(hairAttOrange);
        personAttributesList.add(raquelHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute raquelFacial = new PersonAttribute();
        raquelFacial.setPerson(raquel);
        raquelFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(raquelFacial);

        //Attribute 3 - blue eyes
        PersonAttribute raquelEyes = new PersonAttribute();
        raquelEyes.setPerson(raquel);
        raquelEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(raquelEyes);

        //Attribute 4 - small nose
        PersonAttribute raquelNose = new PersonAttribute();
        raquelNose.setPerson(raquel);
        raquelNose.setAttribute(noseAttSmall);
        personAttributesList.add(raquelNose);

        //Attribute 5 - no accessory
        PersonAttribute raquelAccessory = new PersonAttribute();
        raquelAccessory.setPerson(raquel);
        raquelAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(raquelAccessory);

        //Attribute 6 - female
        PersonAttribute raquelGender = new PersonAttribute();
        raquelGender.setPerson(raquel);
        raquelGender.setAttribute(genderAttFemale);
        personAttributesList.add(raquelGender);

        //Attribute 7 - white Skin
        PersonAttribute raquelSkin = new PersonAttribute();
        raquelSkin.setPerson(raquel);
        raquelSkin.setAttribute(skinAttWhite);
        personAttributesList.add(raquelSkin);

        //endregion

        //region // ----- LANCE ----- //

        //Attribute 1 - has hair
        PersonAttribute lanceHair = new PersonAttribute();
        lanceHair.setPerson(lance);
        lanceHair.setAttribute(hairAttHasHair);
        personAttributesList.add(lanceHair);

        //Attribute 1a - orange hair
        PersonAttribute lanceHairColor = new PersonAttribute();
        lanceHairColor.setPerson(lance);
        lanceHairColor.setAttribute(hairAttOrange);
        personAttributesList.add(lanceHairColor);

        //Attribute 2 - has facial hair
        PersonAttribute lanceFacial = new PersonAttribute();
        lanceFacial.setPerson(lance);
        lanceFacial.setAttribute(facialAttHasHair);
        personAttributesList.add(lanceFacial);

        //Attribute 2a - orange facial hair
        PersonAttribute lanceFacialColor = new PersonAttribute();
        lanceFacialColor.setPerson(lance);
        lanceFacialColor.setAttribute(facialAttOrange);
        personAttributesList.add(lanceFacialColor);

        //Attribute 3 - blue eyes
        PersonAttribute lanceEyes = new PersonAttribute();
        lanceEyes.setPerson(lance);
        lanceEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(lanceEyes);

        //Attribute 4 - small nose
        PersonAttribute lanceNose = new PersonAttribute();
        lanceNose.setPerson(lance);
        lanceNose.setAttribute(noseAttSmall);
        personAttributesList.add(lanceNose);

        //Attribute 5 - no accessory
        PersonAttribute lanceAccessory = new PersonAttribute();
        lanceAccessory.setPerson(lance);
        lanceAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(lanceAccessory);

        //Attribute 6 - Male
        PersonAttribute lanceGender = new PersonAttribute();
        lanceGender.setPerson(lance);
        lanceGender.setAttribute(genderAttMale);
        personAttributesList.add(lanceGender);

        //Attribute 7 - white Skin
        PersonAttribute lanceSkin = new PersonAttribute();
        lanceSkin.setPerson(lance);
        lanceSkin.setAttribute(skinAttWhite);
        personAttributesList.add(lanceSkin);

        //endregion

        //region // ----- BUTCH ----- //

        //Attribute 1 - has hair
        PersonAttribute butchHair = new PersonAttribute();
        butchHair.setPerson(butch);
        butchHair.setAttribute(hairAttHasHair);
        personAttributesList.add(butchHair);

        //Attribute 1 - blond hair
        PersonAttribute butchHairColor = new PersonAttribute();
        butchHairColor.setPerson(butch);
        butchHairColor.setAttribute(hairAttBlond);
        personAttributesList.add(butchHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute butchFacial = new PersonAttribute();
        butchFacial.setPerson(butch);
        butchFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(butchFacial);

        //Attribute 3 - blue eyes
        PersonAttribute butchEyes = new PersonAttribute();
        butchEyes.setPerson(butch);
        butchEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(butchEyes);

        //Attribute 4 - small nose
        PersonAttribute butchNose = new PersonAttribute();
        butchNose.setPerson(butch);
        butchNose.setAttribute(noseAttSmall);
        personAttributesList.add(butchNose);

        //Attribute 5 - no accessory
        PersonAttribute butchAccessory = new PersonAttribute();
        butchAccessory.setPerson(butch);
        butchAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(butchAccessory);

        //Attribute 6 - male
        PersonAttribute butchGender = new PersonAttribute();
        butchGender.setPerson(butch);
        butchGender.setAttribute(genderAttMale);
        personAttributesList.add(butchGender);

        //Attribute 7 - white Skin
        PersonAttribute butchSkin = new PersonAttribute();
        butchSkin.setPerson(butch);
        butchSkin.setAttribute(skinAttWhite);
        personAttributesList.add(butchSkin);

        //endregion

        //region // ----- MIA ----- //

        //Attribute 1 - has hair
        PersonAttribute miaHair = new PersonAttribute();
        miaHair.setPerson(mia);
        miaHair.setAttribute(hairAttHasHair);
        personAttributesList.add(miaHair);

        //Attribute 1 - brown hair
        PersonAttribute miaHairColor = new PersonAttribute();
        miaHairColor.setPerson(mia);
        miaHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(miaHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute miaFacial = new PersonAttribute();
        miaFacial.setPerson(mia);
        miaFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(miaFacial);

        //Attribute 3 - blue eyes
        PersonAttribute miaEyes = new PersonAttribute();
        miaEyes.setPerson(mia);
        miaEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(miaEyes);

        //Attribute 4 - small nose
        PersonAttribute miaNose = new PersonAttribute();
        miaNose.setPerson(mia);
        miaNose.setAttribute(noseAttSmall);
        personAttributesList.add(miaNose);

        //Attribute 5 - no accessory
        PersonAttribute miaAccessory = new PersonAttribute();
        miaAccessory.setPerson(mia);
        miaAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(miaAccessory);

        //Attribute 6 - female
        PersonAttribute miaGender = new PersonAttribute();
        miaGender.setPerson(mia);
        miaGender.setAttribute(genderAttFemale);
        personAttributesList.add(miaGender);

        //Attribute 7 - white Skin
        PersonAttribute miaSkin = new PersonAttribute();
        miaSkin.setPerson(mia);
        miaSkin.setAttribute(skinAttWhite);
        personAttributesList.add(miaSkin);

        //endregion

        //region // ----- MARVIN ----- //

        //Attribute 1 - has hair
        PersonAttribute marvinHair = new PersonAttribute();
        marvinHair.setPerson(marvin);
        marvinHair.setAttribute(hairAttHasHair);
        personAttributesList.add(marvinHair);

        //Attribute 1 - black hair
        PersonAttribute marvinHairColor = new PersonAttribute();
        marvinHairColor.setPerson(marvin);
        marvinHairColor.setAttribute(hairAttBlack);
        personAttributesList.add(marvinHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute marvinFacial = new PersonAttribute();
        marvinFacial.setPerson(marvin);
        marvinFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(marvinFacial);

        //Attribute 3 - brown eyes
        PersonAttribute marvinEyes = new PersonAttribute();
        marvinEyes.setPerson(marvin);
        marvinEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(marvinEyes);

        //Attribute 4 - large nose
        PersonAttribute marvinNose = new PersonAttribute();
        marvinNose.setPerson(marvin);
        marvinNose.setAttribute(noseAttLarge);
        personAttributesList.add(marvinNose);

        //Attribute 5 - no accessory
        PersonAttribute marvinAccessory = new PersonAttribute();
        marvinAccessory.setPerson(marvin);
        marvinAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(marvinAccessory);

        //Attribute 6 - male
        PersonAttribute marvinGender = new PersonAttribute();
        marvinGender.setPerson(marvin);
        marvinGender.setAttribute(genderAttMale);
        personAttributesList.add(marvinGender);

        //Attribute 7 - brown Skin
        PersonAttribute marvinSkin = new PersonAttribute();
        marvinSkin.setPerson(marvin);
        marvinSkin.setAttribute(skinAttBrown);
        personAttributesList.add(marvinSkin);

        //endregion

        //region // ----- ZED ----- //

        //Attribute 1 - has hair
        PersonAttribute zedHair = new PersonAttribute();
        zedHair.setPerson(zed);
        zedHair.setAttribute(hairAttHasHair);
        personAttributesList.add(zedHair);

        //Attribute 1 - blond hair
        PersonAttribute zedHairColor = new PersonAttribute();
        zedHairColor.setPerson(zed);
        zedHairColor.setAttribute(hairAttBlond);
        personAttributesList.add(zedHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute zedFacial = new PersonAttribute();
        zedFacial.setPerson(zed);
        zedFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(zedFacial);

        //Attribute 3 - blue eyes
        PersonAttribute zedEyes = new PersonAttribute();
        zedEyes.setPerson(zed);
        zedEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(zedEyes);

        //Attribute 4 - large nose
        PersonAttribute zedNose = new PersonAttribute();
        zedNose.setPerson(zed);
        zedNose.setAttribute(noseAttLarge);
        personAttributesList.add(zedNose);

        //Attribute 5 - no accessory
        PersonAttribute zedAccessory = new PersonAttribute();
        zedAccessory.setPerson(zed);
        zedAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(zedAccessory);

        //Attribute 6 - male
        PersonAttribute zedGender = new PersonAttribute();
        zedGender.setPerson(zed);
        zedGender.setAttribute(genderAttMale);
        personAttributesList.add(zedGender);

        //Attribute 7 - white Skin
        PersonAttribute zedSkin = new PersonAttribute();
        zedSkin.setPerson(zed);
        zedSkin.setAttribute(skinAttWhite);
        personAttributesList.add(zedSkin);

        //endregion

        //region // ----- BRETT ----- //

        //Attribute 1 - has hair
        PersonAttribute brettHair = new PersonAttribute();
        brettHair.setPerson(brett);
        brettHair.setAttribute(hairAttHasHair);
        personAttributesList.add(brettHair);

        //Attribute 1 - brown hair
        PersonAttribute brettHairColor = new PersonAttribute();
        brettHairColor.setPerson(brett);
        brettHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(brettHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute brettFacial = new PersonAttribute();
        brettFacial.setPerson(brett);
        brettFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(brettFacial);

        //Attribute 3 - brown eyes
        PersonAttribute brettEyes = new PersonAttribute();
        brettEyes.setPerson(brett);
        brettEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(brettEyes);

        //Attribute 4 - large nose
        PersonAttribute brettNose = new PersonAttribute();
        brettNose.setPerson(brett);
        brettNose.setAttribute(noseAttLarge);
        personAttributesList.add(brettNose);

        //Attribute 5 - no accessory
        PersonAttribute brettAccessory = new PersonAttribute();
        brettAccessory.setPerson(brett);
        brettAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(brettAccessory);

        //Attribute 6 - male
        PersonAttribute brettGender = new PersonAttribute();
        brettGender.setPerson(brett);
        brettGender.setAttribute(genderAttMale);
        personAttributesList.add(brettGender);

        //Attribute 7 - white Skin
        PersonAttribute brettSkin = new PersonAttribute();
        brettSkin.setPerson(brett);
        brettSkin.setAttribute(skinAttWhite);
        personAttributesList.add(brettSkin);

        //endregion

        //region // ----- TRUDI ----- //

        //Attribute 1 - has hair
        PersonAttribute trudiHair = new PersonAttribute();
        trudiHair.setPerson(trudi);
        trudiHair.setAttribute(hairAttHasHair);
        personAttributesList.add(trudiHair);

        //Attribute 1 - brown hair
        PersonAttribute trudiHairColor = new PersonAttribute();
        trudiHairColor.setPerson(trudi);
        trudiHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(trudiHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute trudiFacial = new PersonAttribute();
        trudiFacial.setPerson(trudi);
        trudiFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(trudiFacial);

        //Attribute 3 - brown eyes
        PersonAttribute trudiEyes = new PersonAttribute();
        trudiEyes.setPerson(trudi);
        trudiEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(trudiEyes);

        //Attribute 4 - small nose
        PersonAttribute trudiNose = new PersonAttribute();
        trudiNose.setPerson(trudi);
        trudiNose.setAttribute(noseAttSmall);
        personAttributesList.add(trudiNose);

        //Attribute 5 - no accessory
        PersonAttribute trudiAccessory = new PersonAttribute();
        trudiAccessory.setPerson(trudi);
        trudiAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(trudiAccessory);

        //Attribute 6 - female
        PersonAttribute trudiGender = new PersonAttribute();
        trudiGender.setPerson(trudi);
        trudiGender.setAttribute(genderAttFemale);
        personAttributesList.add(trudiGender);

        //Attribute 7 - white Skin
        PersonAttribute trudiSkin = new PersonAttribute();
        trudiSkin.setPerson(trudi);
        trudiSkin.setAttribute(skinAttWhite);
        personAttributesList.add(trudiSkin);

        //endregion

        //region // ----- MAYNARD ----- //

        //Attribute 1 - has hair
        PersonAttribute maynardHair = new PersonAttribute();
        maynardHair.setPerson(maynard);
        maynardHair.setAttribute(hairAttHasHair);
        personAttributesList.add(maynardHair);

        //Attribute 1a - brown hair
        PersonAttribute maynardHairColor = new PersonAttribute();
        maynardHairColor.setPerson(maynard);
        maynardHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(maynardHairColor);

        //Attribute 2 - has facial hair
        PersonAttribute maynardFacial = new PersonAttribute();
        maynardFacial.setPerson(maynard);
        maynardFacial.setAttribute(facialAttHasHair);
        personAttributesList.add(maynardFacial);

        //Attribute 2a - brown facial hair
        PersonAttribute maynardFacialColor = new PersonAttribute();
        maynardFacialColor.setPerson(maynard);
        maynardFacialColor.setAttribute(facialAttBrown);
        personAttributesList.add(maynardFacialColor);

        //Attribute 3 - brown eyes
        PersonAttribute maynardEyes = new PersonAttribute();
        maynardEyes.setPerson(maynard);
        maynardEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(maynardEyes);

        //Attribute 4 - large nose
        PersonAttribute maynardNose = new PersonAttribute();
        maynardNose.setPerson(maynard);
        maynardNose.setAttribute(noseAttLarge);
        personAttributesList.add(maynardNose);

        //Attribute 5 - no accessory
        PersonAttribute maynardAccessory = new PersonAttribute();
        maynardAccessory.setPerson(maynard);
        maynardAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(maynardAccessory);

        //Attribute 6 - Male
        PersonAttribute maynardGender = new PersonAttribute();
        maynardGender.setPerson(maynard);
        maynardGender.setAttribute(genderAttMale);
        personAttributesList.add(maynardGender);

        //Attribute 7 - white Skin
        PersonAttribute maynardSkin = new PersonAttribute();
        maynardSkin.setPerson(maynard);
        maynardSkin.setAttribute(skinAttWhite);
        personAttributesList.add(maynardSkin);

        //endregion

        //region // ----- VINCENT ----- //

        //Attribute 1 - has hair
        PersonAttribute vincentHair = new PersonAttribute();
        vincentHair.setPerson(vincent);
        vincentHair.setAttribute(hairAttHasHair);
        personAttributesList.add(vincentHair);

        //Attribute 1 - brown hair
        PersonAttribute vincentHairColor = new PersonAttribute();
        vincentHairColor.setPerson(vincent);
        vincentHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(vincentHairColor);

        //Attribute 2 - no facial hair
        PersonAttribute vincentFacial = new PersonAttribute();
        vincentFacial.setPerson(vincent);
        vincentFacial.setAttribute(facialAttNoHair);
        personAttributesList.add(vincentFacial);

        //Attribute 3 - blue eyes
        PersonAttribute vincentEyes = new PersonAttribute();
        vincentEyes.setPerson(vincent);
        vincentEyes.setAttribute(eyesAttBlue);
        personAttributesList.add(vincentEyes);

        //Attribute 4 - large nose
        PersonAttribute vincentNose = new PersonAttribute();
        vincentNose.setPerson(vincent);
        vincentNose.setAttribute(noseAttLarge);
        personAttributesList.add(vincentNose);

        //Attribute 5 - no accessory
        PersonAttribute vincentAccessory = new PersonAttribute();
        vincentAccessory.setPerson(vincent);
        vincentAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(vincentAccessory);

        //Attribute 6 - male
        PersonAttribute vincentGender = new PersonAttribute();
        vincentGender.setPerson(vincent);
        vincentGender.setAttribute(genderAttMale);
        personAttributesList.add(vincentGender);

        //Attribute 7 - white Skin
        PersonAttribute vincentSkin = new PersonAttribute();
        vincentSkin.setPerson(vincent);
        vincentSkin.setAttribute(skinAttWhite);
        personAttributesList.add(vincentSkin);

        //endregion

        //region // ----- WINSTON ----- //

        //Attribute 1 - has hair
        PersonAttribute winstonHair = new PersonAttribute();
        winstonHair.setPerson(winston);
        winstonHair.setAttribute(hairAttHasHair);
        personAttributesList.add(winstonHair);

        //Attribute 1a - brown hair
        PersonAttribute winstonHairColor = new PersonAttribute();
        winstonHairColor.setPerson(winston);
        winstonHairColor.setAttribute(hairAttBrown);
        personAttributesList.add(winstonHairColor);

        //Attribute 2 - has facial hair
        PersonAttribute winstonFacial = new PersonAttribute();
        winstonFacial.setPerson(winston);
        winstonFacial.setAttribute(facialAttHasHair);
        personAttributesList.add(winstonFacial);

        //Attribute 2a - brown facial hair
        PersonAttribute winstonFacialColor = new PersonAttribute();
        winstonFacialColor.setPerson(winston);
        winstonFacialColor.setAttribute(facialAttBrown);
        personAttributesList.add(winstonFacialColor);

        //Attribute 3 - brown eyes
        PersonAttribute winstonEyes = new PersonAttribute();
        winstonEyes.setPerson(winston);
        winstonEyes.setAttribute(eyesAttBrown);
        personAttributesList.add(winstonEyes);

        //Attribute 4 - large nose
        PersonAttribute winstonNose = new PersonAttribute();
        winstonNose.setPerson(winston);
        winstonNose.setAttribute(noseAttLarge);
        personAttributesList.add(winstonNose);

        //Attribute 5 - no accessory
        PersonAttribute winstonAccessory = new PersonAttribute();
        winstonAccessory.setPerson(winston);
        winstonAccessory.setAttribute(accessoryAttNone);
        personAttributesList.add(winstonAccessory);

        //Attribute 6 - Male
        PersonAttribute winstonGender = new PersonAttribute();
        winstonGender.setPerson(winston);
        winstonGender.setAttribute(genderAttMale);
        personAttributesList.add(winstonGender);

        //Attribute 7 - white Skin
        PersonAttribute winstonSkin = new PersonAttribute();
        winstonSkin.setPerson(winston);
        winstonSkin.setAttribute(skinAttWhite);
        personAttributesList.add(winstonSkin);

        //endregion

        //insert in db
        personAttributeDao.insertInTx(personAttributesList);

        //endregion
    }
}
