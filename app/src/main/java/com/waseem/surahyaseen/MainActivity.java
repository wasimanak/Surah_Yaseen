package com.waseem.surahyaseen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    Button btn_read,s_rahman,btn_about,btn_share;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        btn_read=findViewById(R.id.btn_read);
        s_rahman=findViewById(R.id.s_rahman);
        btn_about=findViewById(R.id.btn_about);
        btn_share=findViewById(R.id.btn_share);



        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ReadActivity.class));
            }
        });
        s_rahman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NewActivity.class));

            }

        });
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text) + " https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                intentShare.setType("text/plain");
                startActivity(Intent.createChooser(intentShare,"settings_share"));
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }
    public void showDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.contactus_dialoge);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dilog_bg);
        ImageView iv_call,iv_facebook,iv_google,iv_youtube;

        dialog.show();

        Button btn_close = dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }

        });
        iv_call=dialog.findViewById(R.id.iv_call);
        iv_facebook=dialog.findViewById(R.id.iv_facebook);
        iv_google=dialog.findViewById(R.id.iv_google);
        iv_youtube=dialog.findViewById(R.id.iv_youtube);

        iv_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String defultapp = "WhatsApp";

                try {
                    String url = "https://api.whatsapp.com/send?phone=+923012861054" +
                            "&text=" + URLEncoder.encode("HELLO Surah App TEAM !  ", "UTF-8");

                    Intent sendIntent = new Intent("android.intent.action.MAIN");
                    sendIntent.setAction(Intent.ACTION_VIEW);

                    if (defultapp.equalsIgnoreCase("WhatsApp")) {
                        sendIntent.setPackage("com.whatsapp");
                        Log.e("message", "WhatsApp");
                    }
                    sendIntent.setData(Uri.parse(url));
                    startActivity(sendIntent);

                } catch (Exception e) {
                    Log.e("message", e.getMessage());
                }
            }
        });
        iv_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:"+"wasimanak@gmail.com"));
//                intent.putExtra(Intent.EXTRA_SUBJECT, "KSK User");
                intent.putExtra(Intent.EXTRA_SUBJECT, "KSK USER");
                intent.putExtra(Intent.EXTRA_EMAIL, "\nThis email from Surah App USER");

                startActivity(intent);





            }
        });
        iv_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                String url="https://www.youtube.com/c/WasiManak";
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            }
        });
        iv_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String YourPageURL = "https://www.facebook.com/CEdiscoveries";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));

                startActivity(browserIntent);
            }
        });

    }
}