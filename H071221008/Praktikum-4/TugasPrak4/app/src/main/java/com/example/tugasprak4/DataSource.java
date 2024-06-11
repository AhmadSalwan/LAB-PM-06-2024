package com.example.tugasprak4;

import android.net.Uri;
import com.example.tugasprak4.Post;
import com.example.tugasprak4.User;
import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Post> posts = generatePosts();
    public static User user = new User("Iqbal Ramadhan", "iqbalramadhan", R.drawable.iqbal_ramadhan);

    public static ArrayList<Post> generatePosts() {
        User iqbal = new User("Iqbal Ramadhan", "iqbal ramadhan", R.drawable.iqbal_ramadhan);
        User pamungkas = new User("Pamungkas", "pamungkas", R.drawable.pamungkas);
        User jefri = new User("Jefri Nichol", "jefri_nichol", R.drawable.jefri_nichol);
        User tulus = new User("Tulus", "tulus_123", R.drawable.tulus);
        User rey = new User("Rey Mbayang", "rey_mbayang", R.drawable.rey_mbayang);
        User verrel = new User("Verrel Bramasta", "verrel_bramasta", R.drawable.verrel_bramasta);
        ArrayList<Post> dump = new ArrayList<>();
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "iqbal_ramadhan"), "Iqbaal Dhiafakhri Ramadhan adalah aktor dan penyanyi berkebangsaan Indonesia.", iqbal));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "pamungkas"), "Pamungkas, adalah seorang penyanyi, produser rekaman, penulis lagu, dan aktor berkebangsaan Indonesia.", pamungkas));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "jefri_nichol"), "Jefri Nichol adalah pemeran dan model Indonesia. Namanya dikenal luas berkat perannya sebagai Nathan dalam film Dear Nathan pada tahun 2017 ", jefri));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "tulus"), "Tulus memulai karier profesionalnya sejak tahun 2011 melalui label rekaman independen TulusCompany yang didirikannya. ", tulus));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "rey_mbayang"), "Reynaldi Mbayang, S.M. merupakan pemeran, penyanyi, dan model berkebangsaan Indonesia", rey));
        dump.add(new Post(Uri.parse("android.resource://com.example.tugasprak4/drawable/" + "verrel_bramasta"), "Verrell Bramasta Fadilla Soedjoko adalah pemeran, penyanyi, dan politikus Indonesia", verrel));
        return dump;
    }
}
