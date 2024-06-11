package com.example.tugaspraktikum5;

import java.util.ArrayList;

public class DataSources {

    public static ArrayList<Instagram> instagrams =generateDummyInstagram();

    private static ArrayList<Instagram> generateDummyInstagram() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("Hoshi Kwon", "hoshi", "good morning caratdeul"
                ,R.drawable.hoshi3, R.drawable.hoshi3));

        instagrams1.add(new Instagram("chwe hansol", "vernon", "blue sky"
                ,R.drawable.vernon2, R.drawable.vernon2));

        instagrams1.add(new Instagram("lee chan", "dino", "wiith boo"
                ,R.drawable.sk_dino2, R.drawable.sk_dino2));

        instagrams1.add(new Instagram("jeong wonwoo", "wonu", "my shadow"
                ,R.drawable.wonu_dk_3, R.drawable.wonu_dk_3));

        return instagrams1;

    }

}