package ovh.crow.guesswho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PersonDao personDao;
    private PersonAttributeDao personAttributeDao;
    private ModifiersDao modifiersDao;
    private AttributeDao attributeDao;
    private AreasDao areasDao;

    //Get Session
    DaoSession daoSession = ((App) getApplication()).getDaoSession();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seedDatabase();
    }


    private void seedDatabase() {

        //Get All tables
        personDao = daoSession.getPersonDao();
        personAttributeDao = daoSession.getPersonAttributeDao();
        modifiersDao = daoSession.getModifiersDao();
        attributeDao = daoSession.getAttributeDao();
        areasDao = daoSession.getAreasDao();

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

        Person Roger = new Person();
        Roger.setName("Roger");
        Roger.setImgName("IMG_roger");
        personList.add(Roger);

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

        //endregion
    }
}
