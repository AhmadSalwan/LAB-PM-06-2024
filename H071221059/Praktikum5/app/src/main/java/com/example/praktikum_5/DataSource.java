package com.example.praktikum_5;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Sosialmedia> sosialmedias = generateDummySosialmedia();

    private static ArrayList<Sosialmedia> generateDummySosialmedia(){
        ArrayList<Sosialmedia> sosialmedia1 = new ArrayList<>();
        sosialmedia1.add(new Sosialmedia("Daeng Ari", "Observasi", "Wawancara", R.drawable.sitangkasbawakotak, R.drawable.sitangkasbawakotak ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkasdiskusi, R.drawable.sitangkasdiskusi ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkaskameramen, R.drawable.sitangkaskameramen ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkastoko, R.drawable.sitangkastoko ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkasmelihat, R.drawable.sitangkasmelihat ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkaskameramenlagi, R.drawable.sitangkaskameramenlagi ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkasumkm, R.drawable.sitangkasumkm ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkaszeketi, R.drawable.sitangkaszeketi ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkaszeketimutol, R.drawable.sitangkaszeketimutol ));
        sosialmedia1.add(new Sosialmedia("Tim Zeketi", "Berdiskusi", "Diskusi", R.drawable.sitangkaszoel, R.drawable.sitangkaszoel ));

        return sosialmedia1;

    }

}
