package com.example.tugaspraktikum4;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("Kwon Soonyoung","Hoshi"
                ,"Halooooo",R.drawable.hoshi1,R.drawable.hoshi1));

        instagrams1.add(new Instagram("Mochi", "ochi"
                ,"cakep bgt"
                ,R.drawable.hoshi2,R.drawable.hoshi2));

        instagrams1.add(new Instagram("jeonghan", "han"
                ,"hannie"
                ,R.drawable.jeonghan1, R.drawable.jeonghan1));

        instagrams1.add((new Instagram("hannn","kasep"
                ,"menyala abangkuh"
                ,R.drawable.jeonghan2,R.drawable.jeonghan2)));

        instagrams1.add(new Instagram("joshua", "shua"
                ,"black"
                ,R.drawable.joshua1,R.drawable.joshua1));

        instagrams1.add(new Instagram("yoon jeong han","hani"
                ,"WKWK"
                ,R.drawable.jeonghan3, R.drawable.jeonghan3));

        instagrams1.add(new Instagram("hong jisoo","josh"
                , "sunday morning"
                ,R.drawable.joshua2,R.drawable.joshua2));

        instagrams1.add(new Instagram("josh","shua"
                ,"svt"
                ,R.drawable.joshua3, R.drawable.joshua3));

        instagrams1.add(new Instagram("jun", "juni"
                ,"line china nih"
                ,R.drawable.jun_the8_2, R.drawable.jun_the8_2));

        instagrams1.add(new Instagram("the8", "8"
                ,"with moon junhui"
                ,R.drawable.jun_the8_3, R.drawable.jun_the8_3));
        return instagrams1;
    }
}