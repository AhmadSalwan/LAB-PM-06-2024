package com.example.praktikum_4;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("Rendand","Enak"
                ,"Masakan Padang adalah salah satu masakan paling populer di Indonesia"
                ,R.drawable.saiyosakato1,R.drawable.saiyosakato1));

        instagrams1.add(new Instagram("Gulai", "Kari Rendang"
                ,"Terkenal dengan kelezatannya yang kaya rasa dan rempah yang khas. Hidangan Padang terkenal dengan "
                ,R.drawable.saiyosakato2,R.drawable.saiyosakato2));

        instagrams1.add(new Instagram("shinseulkee", "Shin Seul-Ki"
                ,"Lebih dari sekedar pedas, masakan Padang menawarkan petualangan rasa yang luar biasa."
                ,R.drawable.saiyosakato3, R.drawable.saiyosakato3));

        instagrams1.add((new Instagram("Sate Padang","Rempah"
                ,"Padang: Surga bagi pecinta kuliner yang ingin menjelajahi cita rasa baru.\n"
                ,R.drawable.saiyosakato4,R.drawable.saiyosakato4)));

        instagrams1.add(new Instagram("Gulai Abah", "Surga Kuliner"
                ,"Menyantap masakan Padang: Sebuah pengalaman budaya yang tak ternilai."
                ,R.drawable.saiyosakato5,R.drawable.saiyosakato5));

        instagrams1.add(new Instagram("Cita Rasa","Pedas"
                ,"Kekayaan kuliner Padang: Sebuah warisan budaya yang patut dilestarikan.\n"
                ,R.drawable.saiyosakato6, R.drawable.saiyosakato6));

        instagrams1.add(new Instagram("Kari Rendang","Uni Uda"
                , "Masakan Padang: Bukti bahwa Indonesia adalah surga kuliner dunia"
                ,R.drawable.saiyosakato7,R.drawable.saiyosakato7));

        instagrams1.add(new Instagram("Minang","Enaknyoo"
                ,"Rendang, gulai, dan sate Padang: Perpaduan rempah yang menggoda selera"
                ,R.drawable.saiyosakato8, R.drawable.saiyosakato8));

        instagrams1.add(new Instagram("Surga Rasa", "Minang Padang"
                ,"Dengan berbagai hidangan lezat dan kaya rasa, masakan Padang pasti akan memuaskan selera Anda"
                ,R.drawable.saiyosakato9, R.drawable.saiyosakato9));

        instagrams1.add(new Instagram("Ranah Minang", "Surga Kuliner"
                ,"Masakan Padang sering disajikan dalam acara-acara khusus dan perayaan, dan merupakan bagian penting dari identitas budaya masyarakat Minang"
                ,R.drawable.saiyosakato10, R.drawable.saiyosakato10));
        return instagrams1;
    }
}
