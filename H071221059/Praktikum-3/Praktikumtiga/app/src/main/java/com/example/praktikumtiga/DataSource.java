package com.example.praktikumtiga;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 =new ArrayList<>();
        instagrams1.add(new Instagram("saiyosakato1", "Menunggubukapuasa", R.drawable.saiyosakato1, R.drawable.saiyosakato1, R.drawable.saiyosakato1, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato2", "Menunggubukapuasa", R.drawable.saiyosakato2, R.drawable.saiyosakato2, R.drawable.saiyosakato2, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato3", "Menunggubukapuasa", R.drawable.saiyosakato3, R.drawable.saiyosakato3, R.drawable.saiyosakato3, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato4", "Menunggubukapuasa", R.drawable.saiyosakato4, R.drawable.saiyosakato4, R.drawable.saiyosakato4, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato5", "Menunggubukapuasa", R.drawable.saiyosakato5, R.drawable.saiyosakato5, R.drawable.saiyosakato5, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato6", "Menunggubukapuasa", R.drawable.saiyosakato6, R.drawable.saiyosakato6, R.drawable.saiyosakato6, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato7", "Menunggubukapuasa", R.drawable.saiyosakato7, R.drawable.saiyosakato7, R.drawable.saiyosakato7, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato8", "Menunggubukapuasa", R.drawable.saiyosakato8, R.drawable.saiyosakato8, R.drawable.saiyosakato8, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato9", "Menunggubukapuasa", R.drawable.saiyosakato9, R.drawable.saiyosakato9, R.drawable.saiyosakato9, "1.5 jt", "5"));
        instagrams1.add(new Instagram("saiyosakato10", "Menunggubukapuasa", R.drawable.saiyosakato10, R.drawable.saiyosakato10, R.drawable.saiyosakato10, "1.5 jt", "5"));
        return instagrams1;
    }
}
