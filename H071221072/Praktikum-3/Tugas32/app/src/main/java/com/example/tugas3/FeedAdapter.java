package com.example.tugas3;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context context;
    private List<FeedModel> feedList;

    public FeedAdapter(Context context, List<FeedModel> feedList) {
        this.context = context;
        this.feedList = feedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FeedModel feed = feedList.get(position);
        holder.ivfeed.setImageResource(feed.getIvfeed());
        holder.ivlogo.setImageResource(feed.getIvlogo());
        holder.tvusername.setText(feed.getUsername());

        holder.parentLayout.setOnClickListener(view -> {
            if (feed.getUsername().equals("mpl.id.official")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.mpl);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_mpl);
                intent.putExtra("NAME_DEFAULT","MPL Indonesia");
                intent.putExtra("USERNAME_DEFAULT","mpl.id.official");
                intent.putExtra("BIO_DEFAULT","Seru-seruan bareng di TikTok! 🙌🥳 Jangan lupa follow yagesya! ✨");
                intent.putExtra("POSTS_DEFAULT","8.652");
                intent.putExtra("FOLLOWERS_DEFAULT","6,5 jt");
                intent.putExtra("FOLLOWING_DEFAULT","186");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("evosesport")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.evos);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_evos);
                intent.putExtra("NAME_DEFAULT","EVOS ESPORTS");
                intent.putExtra("USERNAME_DEFAULT","evosesport");
                intent.putExtra("BIO_DEFAULT","ML | PUBGM | FF\n" +
                        "—\n" +
                        "@axis_id @popmieofficial @itelindonesia @bywondersphere @noctua.saintseiya");
                intent.putExtra("POSTS_DEFAULT","8.676");
                intent.putExtra("FOLLOWERS_DEFAULT","7 jt");
                intent.putExtra("FOLLOWING_DEFAULT","515");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("teamrrq")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.rrq);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_rrq);
                intent.putExtra("NAME_DEFAULT","Team RRQ");
                intent.putExtra("USERNAME_DEFAULT","teamrrq");
                intent.putExtra("BIO_DEFAULT","ID/PH/BR\n" +
                        "@rrq_topup\n" +
                        "@rrq_kingdomm\n" +
                        "@rrq_store\n" +
                        "Partners\n" +
                        "@samsungindonesia @biznethome @asusrog.id @sukro @popmieofficial @zilliqa_official");
                intent.putExtra("POSTS_DEFAULT","6.295");
                intent.putExtra("FOLLOWERS_DEFAULT","5,2 jt");
                intent.putExtra("FOLLOWING_DEFAULT","510");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("onic.esports")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.onic);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_onic);
                intent.putExtra("NAME_DEFAULT","ONIC");
                intent.putExtra("USERNAME_DEFAULT","onic.esports");
                intent.putExtra("BIO_DEFAULT","ONIC ID\n" +
                        "—\n" +
                        "@biznethome @dailybox.id @infinixid @jdsportsindo @gopayindonesia\n" +
                        "--\n" +
                        "@onic_topup @onicsupplyid @sonic.republic @academy.onic");
                intent.putExtra("POSTS_DEFAULT","5.492");
                intent.putExtra("FOLLOWERS_DEFAULT","2,4 jt");
                intent.putExtra("FOLLOWING_DEFAULT","366");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("geekfamid")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.geek);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_geek);
                intent.putExtra("NAME_DEFAULT","Geek Fam Indonesia");
                intent.putExtra("USERNAME_DEFAULT","geekfamid");
                intent.putExtra("BIO_DEFAULT","Official Instagram for Geek Fam Indonesia\n" +
                        "Partnership: partners@geekfam.asia\n" +
                        "---\n" +
                        "Partners: @duniagames.co.id");
                intent.putExtra("POSTS_DEFAULT","4.676");
                intent.putExtra("FOLLOWERS_DEFAULT","393 rb");
                intent.putExtra("FOLLOWING_DEFAULT","158");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("bigetronesports")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.btr);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_btr);
                intent.putExtra("NAME_DEFAULT","Bigetron Esports");
                intent.putExtra("USERNAME_DEFAULT","bigetronesports");
                intent.putExtra("BIO_DEFAULT","\uD83C\uDDEE\uD83C\uDDE9\uD83C\uDDE7\uD83C\uDDF7 Programmed to Win\n" +
                        "Cheapest Topup @ionplay.id\n" +
                        "Official Merch @btrgear");
                intent.putExtra("POSTS_DEFAULT","7.409");
                intent.putExtra("FOLLOWERS_DEFAULT","3 jt");
                intent.putExtra("FOLLOWING_DEFAULT","10");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("blacklistintl")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.blck);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_blck);
                intent.putExtra("NAME_DEFAULT","Blacklist International");
                intent.putExtra("USERNAME_DEFAULT","blacklistintl");
                intent.putExtra("BIO_DEFAULT","@TierOneEntertainment's official esports division. #BreakTheCode\n" +
                        "\uD83D\uDCE7 Brand Partnerships: partnerships.blck@tier.one");
                intent.putExtra("POSTS_DEFAULT","5.027");
                intent.putExtra("FOLLOWERS_DEFAULT","124 rb");
                intent.putExtra("FOLLOWING_DEFAULT","64");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("echophilippines")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.echo);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_echo);
                intent.putExtra("NAME_DEFAULT","ECHO");
                intent.putExtra("USERNAME_DEFAULT","echophilippines");
                intent.putExtra("BIO_DEFAULT","ECHO LOUD, ECHO PROUD\n" +
                        "Home of the M4 World Champions | MPL PH S11 Champions \uD83C\uDFC6\n" +
                        "✉\uFE0F business@echo.ph\n" +
                        "\uD83D\uDC9C#ECHOLOUD");
                intent.putExtra("POSTS_DEFAULT","4.146");
                intent.putExtra("FOLLOWERS_DEFAULT","137 rb");
                intent.putExtra("FOLLOWING_DEFAULT","32");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("auraesports")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.aura);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_aura);
                intent.putExtra("USERNAME_DEFAULT","AURA");
                intent.putExtra("NAME_DEFAULT","auraesports");
                intent.putExtra("BIO_DEFAULT","THE FIRE IN YOU\n" +
                        "__\n" +
                        "@gaga100extrapedas , @poco_id\n" +
                        "__\n" +
                        "@auramerch @auraesportsfamily");
                intent.putExtra("POSTS_DEFAULT","5.114");
                intent.putExtra("FOLLOWERS_DEFAULT","4 jt");
                intent.putExtra("FOLLOWING_DEFAULT","145");
                context.startActivity(intent);
            }
            if (feed.getUsername().equals("alteregoesports")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("LOGO_DEFAULT",R.drawable.alterego);
                intent.putExtra("FEED_DEFAULT",R.drawable.feed_alterego);
                intent.putExtra("NAME_DEFAULT","Alter Ego e-Sports");
                intent.putExtra("USERNAME_DEFAULT","alteregoesports");
                intent.putExtra("BIO_DEFAULT","@hyundaigowa @redbull.indonesia @officialboncabe @kohai.infiniti @agonbyaocid @vidio_esports @steelseriesindonesia");
                intent.putExtra("POSTS_DEFAULT","4.634");
                intent.putExtra("FOLLOWERS_DEFAULT","1 jt");
                intent.putExtra("FOLLOWING_DEFAULT","361");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivfeed, ivlogo;
        TextView tvusername;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivfeed = itemView.findViewById(R.id.iv_feed);
            ivlogo = itemView.findViewById(R.id.iv_logo);
            tvusername = itemView.findViewById(R.id.tv_username);
            parentLayout = itemView.findViewById(R.id.parentlayout);
        }
    }
}

