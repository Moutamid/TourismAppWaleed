package com.moutamid.tourismappwaleed.data;

import com.moutamid.tourismappwaleed.R;
import com.moutamid.tourismappwaleed.model.PlaceModel;
import com.moutamid.tourismappwaleed.utils.Constants;
import com.moutamid.tourismappwaleed.utils.Stash;

public class Brain {

    public static PlaceModel getTajMahalModel() {
        PlaceModel model = new PlaceModel();

        model.name = "Taj Mahal";
        model.country = "India";
        model.title = "Great Place To Visit";
        model.desc = Descrptions.TAJ_MAHAL;

        model.image1 = R.drawable.tajmahal1;
        model.image2 = R.drawable.tajmahal2;
        model.image3 = R.drawable.tajmahal3;
        model.image4 = R.drawable.tajmahal4;

        model.rating = Stash.getFloat(Constants.RATING_VALUE + model.name, 0);

        model.isSaved = Stash.getBoolean(Constants.TAJ_MAHAL, false);

        return model;
    }

    public static PlaceModel getChristTheRedeemerModel() {
        PlaceModel model = new PlaceModel();

        model.name = "Christ the redeemer";
        model.country = "Brazil";
        model.title = "A Big Statue";
        model.desc = Descrptions.CHRIST;

        model.image1 = R.drawable.christtheredeemer1;
        model.image2 = R.drawable.christtheredeemer2;
        model.image3 = R.drawable.christtheredeemer3;
        model.image4 = R.drawable.christtheredeemer4;

        model.rating = Stash.getFloat(Constants.RATING_VALUE + model.name, 0);

        model.isSaved = Stash.getBoolean(Constants.CHRIST_THE_REDEEMER, false);

        return model;
    }

    public static PlaceModel getGizaModel() {
        PlaceModel model = new PlaceModel();

        model.name = "Pyramids Of Giza";
        model.country = "Egypt";
        model.title = "The Great Pyramids Of Giza";
        model.desc = Descrptions.GIZA;

        model.image1 = R.drawable.pyramidsofgiza1;
        model.image2 = R.drawable.pyramidsofgiza2;
        model.image3 = R.drawable.pyramidsofgiza3;
        model.image4 = R.drawable.pyramidsofgiza4;

        model.rating = Stash.getFloat(Constants.RATING_VALUE + model.name, 0);

        model.isSaved = Stash.getBoolean(Constants.PYRAMIDS_OF_GIZA, false);

        return model;
    }

    public static PlaceModel getStoneModel() {
        PlaceModel model = new PlaceModel();

        model.name = "StoneHedge";
        model.country = "England";
        model.title = "The Big Stones";
        model.desc = Descrptions.STONE;

        model.image1 = R.drawable.stonehenge1;
        model.image2 = R.drawable.stonehenge2;
        model.image3 = R.drawable.stonehenge3;
        model.image4 = R.drawable.stonehenge4;

        model.rating = Stash.getFloat(Constants.RATING_VALUE + model.name, 0);

        model.isSaved = Stash.getBoolean(Constants.STONE_HEDGE, false);

        return model;
    }

    public static PlaceModel getPetraModel() {
        PlaceModel model = new PlaceModel();

        model.name = "Petra";
        model.country = "Jordan";
        model.title = "The Inhabitants of Petra";
        model.desc = Descrptions.PETRA;

        model.image1 = R.drawable.petra1;
        model.image2 = R.drawable.petra2;
        model.image3 = R.drawable.petra3;
        model.image4 = R.drawable.petra4;

        model.rating = Stash.getFloat(Constants.RATING_VALUE + model.name, 0);

        model.isSaved = Stash.getBoolean(Constants.PETRA, false);

        return model;
    }

    public static PlaceModel getForbiddenCityModel() {
        PlaceModel model = new PlaceModel();

        model.name = "The Forbidden City";
        model.country = "China";
        model.title = "World Heritage";
        model.desc = Descrptions.FORBIDDEN;

        model.image1 = R.drawable.theforbiddencityinbeijing1;
        model.image2 = R.drawable.theforbiddencityinbeijing2;
        model.image3 = R.drawable.theforbiddencityinbeijing3;
        model.image4 = R.drawable.theforbiddencityinbeijing4;

        model.rating = Stash.getFloat(Constants.RATING_VALUE + model.name, 0);

        model.isSaved = Stash.getBoolean(Constants.FORBIDDEN_CITY, false);

        return model;
    }

    public static PlaceModel getMakkahModel() {
        PlaceModel model = new PlaceModel();

        model.name = "Holy Makkah";
        model.country = "Saudi Arabia";
        model.title = "The Holy Kaaba";
        model.desc = Descrptions.MAKKAH;

        model.image1 = R.drawable.makkah1;
        model.image2 = R.drawable.makkah2;
        model.image3 = R.drawable.makkah3;
        model.image4 = R.drawable.makkah4;

        model.rating = Stash.getFloat(Constants.RATING_VALUE + model.name, 0);

        model.isSaved = Stash.getBoolean(Constants.HOLY_MAKKAH, false);

        return model;
    }

    public static PlaceModel getK2Model() {
        PlaceModel model = new PlaceModel();

        model.name = "K2 Mountain";
        model.country = "Pakistan";
        model.title = "2nd Top Mountain";
        model.desc = Descrptions.K2;

        model.image1 = R.drawable.mountain1;
        model.image2 = R.drawable.mountain2;
        model.image3 = R.drawable.mountain3;
        model.image4 = R.drawable.mountain4;

        model.rating = Stash.getFloat(Constants.RATING_VALUE + model.name, 0);

        model.isSaved = Stash.getBoolean(Constants.K2_PAKISTAN, false);

        return model;
    }

}
