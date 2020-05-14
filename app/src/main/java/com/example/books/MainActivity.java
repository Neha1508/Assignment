package com.example.books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  static final  String TAG="MainActivity";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> mImageUrls =new ArrayList<>();
    private ArrayList<String> mNames =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageBitmaps();
    }
    private void initImageBitmaps(){

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2019/01/Hitler.jpg");
        mNames.add("10 UNKNOWN FACTS ABOUT ADOLF HITLER THAT YOU DON’T KNOW");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/05/adiyogi-shiva-218x150.jpg");
        mNames.add("THESE ANCIENT SHIVA TEMPLES ON DIFFERENT LOCATIONS, LIE ON STRAIGHT LINE LONGITUDINALLY");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2016/09/Lord-Mahakal-Jyotir-linga-218x150.jpg");
        mNames.add("MAHAKALESHWAR JYOTIRLINGAM: LORD OF TIME AND DEATH");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/03/e0c73592c8ca318891ab8d256e223ce8-218x150.jpg");
        mNames.add("BEAUTIFUL STORY OF TIRUPATI BALAJI: MYSTERIES, LOVE, DEBT, KALIYUGA");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/05/dragon-warrior-4-by-camilkuo-on-deviantart-218x150.jpg");
        mNames.add("THE EIGHT IMMORTALS (CHIRANJIVI) ACCORDING TO HINDU MYTHOLOGY");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/03/987b420a4b3a46664bfdd7c90dc78c12-324x160.jpg");
        mNames.add("VITHAL TEMPLE, HAMPI AND ITS 56 MUSICAL PILLARS");


        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/05/hair-loss-disorders-and-causes-324x160.jpg");
        mNames.add("TOP 7 VEGETARIAN FOODS TO PREVENT HAIR LOSS");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/05/baby-869439_960_720-100x70.jpg");
        mNames.add("DREAMS THAT INDICATE THE SIGN OF PROSPERITY");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/07/maxresdefault1-100x70.jpg");
        mNames.add("AMAZING HEALTH BENEFITS OF THESE HASTA MUDRAS.");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/06/maxresdefault-1-2-100x70.jpg");
        mNames.add("COW URINE CAN DO MIRACLE FOR CURING DIABETES");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/07/pentagram-1866328_640-218x150.png");
        mNames.add("THE OCCULT (SUPER NATURAL POWER) THAT DIFFERENT NUMBERS HOLD.");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/03/early-morning-299735_1280-324x235.jpg");
        mNames.add("AVOID GROWING THESE PLANTS THAT BRING BAD LUCK TO YOUR HOME");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/06/418fb6cdbf42d348cbf62cf75b46e53c-324x235.jpg");
        mNames.add("LOOKING FOR HAPPY MARRIED LIFE??…….VASTU SHASTRA WILL HELP YOU.");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2016/09/Different-Pastel-Shades-218x150.jpg");
        mNames.add("WEARING THESE COLOURS WILL BRING YOU LUCK");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/03/woman-1081873_1920-218x150.jpg");
        mNames.add("ZODIAC SIGNS DETAILS: ALL YOU NEED TO KNOW ABOUT ALL ZODIAC.");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/06/7ae69b1be31ea40a0f28d1f0411a04ae-2-218x150.jpg");
        mNames.add(" (YELLOW SAPPHIRE) CAN GIVE YOU MIRACULOUS PROGRESS & SUCCESS.");

        mImageUrls.add("https://aastik.in/wp-content/uploads/2017/07/yellow-sapphire-stone-for-jewelry-218x150.jpg");
        mNames.add("WEARING PUKHRAJ (YELLOW SAPPHIRE) CAN GIVE YOU MIRACULOUS PROGRESS & SUCCESS.");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initializing staggered recyclerview");
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        StaggeredRecyclerViewAdaper staggeredRecyclerViewAdaper = new StaggeredRecyclerViewAdaper(this,mNames,mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdaper);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.message_notification,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel channel=new NotificationChannel("MyNotifications","MyNotifications",NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }
                NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MyNotifications")
                        .setContentTitle("Notification")
                        .setSmallIcon(R.drawable.ic_sms_24dp)
                        .setAutoCancel(true)
                        .setContentText("Hi there, I am a notification");

                NotificationManagerCompat manager =NotificationManagerCompat.from(this);
                manager.notify(999,builder.build());
                Toast.makeText(this, "This is NOTIFICATION Page", Toast.LENGTH_SHORT).show();
                Intent obj=new Intent(MainActivity.this,Notification_list.class);
                startActivity(obj);
                return true;
            case R.id.item2:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel channel=new NotificationChannel("MyNotifications","MyNotifications",NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager managers = getSystemService(NotificationManager.class);
                    managers.createNotificationChannel(channel);
                }
                NotificationCompat.Builder builders=new NotificationCompat.Builder(this,"MyNotifications")
                        .setContentTitle("Message")
                        .setSmallIcon(R.drawable.ic_chat_mess)
                        .setAutoCancel(true)
                        .setContentText("Hello World");

                NotificationManagerCompat managers =NotificationManagerCompat.from(this);
                managers.notify(999,builders.build());
                Toast.makeText(this, "This is Message Page", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Message.class);
                startActivity(intent);
            default:
                    return super.onOptionsItemSelected(item);
        }

    }
}
