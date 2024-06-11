package com.example.tugasprakktikum3;

import java.util.ArrayList;

public class DataSources {
    public static ArrayList<AccountIg>accountIg = generateDummyAccountIg();

    private static ArrayList<AccountIg>generateDummyAccountIg(){
        ArrayList<AccountIg>accountIg = new ArrayList<>();
        accountIg.add(new AccountIg("hoshi kwon", "horanghae", R.drawable.hoshi1, R.drawable.hoshi2, R.drawable.hoshi3, 8000000, 13));
        accountIg.add(new AccountIg("jeonghan", "hola", R.drawable.jeonghan1, R.drawable.jeonghan2, R.drawable.jeonghan3, 8000000, 13));
        accountIg.add(new AccountIg("joshua", "enjoying sunset", R.drawable.joshua1, R.drawable.joshua2, R.drawable.joshua3, 8000000, 13));
        accountIg.add(new AccountIg("scoup", "first time in paris", R.drawable.scoup1, R.drawable.scoup2, R.drawable.scoup3, 8000000, 13));
        accountIg.add(new AccountIg("jun", "with the8", R.drawable.jun1, R.drawable.jun_the8_2, R.drawable.jun_the8_3, 8000000, 13));
        accountIg.add(new AccountIg("wonwoo", "gam3 boi ", R.drawable.wonwoo1, R.drawable.wonu_dk_2, R.drawable.wonu_dk_3, 8000000, 13));
        accountIg.add(new AccountIg("woozi", "new song", R.drawable.uji1, R.drawable.uji2, R.drawable.uji3, 8000000, 13));
        accountIg.add(new AccountIg("seungkwan", "pemandangan indah", R.drawable.sk1, R.drawable.sk_dino2, R.drawable.sk_dino3, 8000000, 13));
        accountIg.add(new AccountIg("vernon", "okeh", R.drawable.vernon1, R.drawable.vernon2, R.drawable.vernon3, 8000000, 13));
        accountIg.add(new AccountIg("mingyu", "cakep bgt gueh", R.drawable.mingyu1, R.drawable.mingyu2, R.drawable.mingyu3, 8000000, 13));
        return accountIg;
    }
}
