package com.example.praktikum3;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Artis> artis = generateDummyArtis();

    private static ArrayList<Artis> generateDummyArtis() {
    ArrayList<Artis> artis = new ArrayList<>();
    artis.add(new Artis("Agnes Monica", "Cantik", R.drawable.agnez_monica, R.drawable.agnez_monica_2, R.drawable.agnez_monica_3,5000000, 1));
    artis.add(new Artis("Bunga Citra Lestari", "Pesta", R.drawable.bunga_citra_lestari, R.drawable.bunga_citra_lestari_2, R.drawable.bunga_citra_lestari_3, 4000000, 2));
    artis.add(new Artis("Cinta Laura", "Wisuda", R.drawable.cinta_laura, R.drawable.cinta_laura_2, R.drawable.cinta_laura_3, 6000000, 3));
    artis.add(new Artis("Citra Kirana", "otw", R.drawable.citra_kirana, R.drawable.citra_kirana_2, R.drawable.citra_kirana_3, 7000000, 4));
    artis.add(new Artis("Jessica Iskandar", "Liburan", R.drawable.jessica_iskandar, R.drawable.jessica_iskandar_2, R.drawable.jessica_iskandar_3, 10000000, 5));
    artis.add(new Artis("Lyodra", "Gala Show", R.drawable.lyodra, R.drawable.lyodra_2, R.drawable.lyodra_3, 500000, 6));
    artis.add(new Artis("Maudy Ayunda", "Santai", R.drawable.maudy_ayunda, R.drawable.maudy_ayunda_2, R.drawable.maudy_ayunda_3, 3000000, 7));
    artis.add(new Artis("Natasha Wilona", "Sekolah", R.drawable.natasha_wilona, R.drawable.natasha_wilona_3, R.drawable.natasha_wilona__2, 2000000, 8));
    artis.add(new Artis("Prilly Latuconsina", "Yeay Lulus", R.drawable.prilly_latuconsina, R.drawable.prilly_latuconsina_3, R.drawable.prilly_latuconsina_2, 50045400, 9));
    artis.add(new Artis("Raisa", "Foto Shoot", R.drawable.raisa, R.drawable.raisa_2, R.drawable.raisa_3, 5340000, 10));
    return artis;
    }
}
