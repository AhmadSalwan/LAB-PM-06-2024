package com.example.praktikum5;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Model> models = generateDummyModels();

    private static ArrayList<Model> generateDummyModels() {
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model("Rum Tum Tugger", "Rum", "Kamu harus menghentikannya sebelum ia keluar atau sangat sulit ditangkap.", R.drawable.cat1, R.drawable.cat11));
        models.add(new Model("Edgar Allan Paw", "Edgar", "Kamu akan selalu beruntung jika tahu cara berteman.", R.drawable.cat2, R.drawable.cat22));
        models.add(new Model("Mad Catter", "Mad", "Hal terbaik yang dapat kamu lakukan adalah menjadi teman mereka.", R.drawable.cat3, R.drawable.cat33));
        models.add(new Model("Skimbleshanks", "Shanks", "Kucing tampaknya berprinsip bahwa tidak ada salahnya meminta apa yang mereka inginkan.", R.drawable.cat4, R.drawable.cat44));

        return models;
    }
}
