package com.elyehgmail.ladimer.smartbusiness;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.elyehgmail.ladimer.smartbusiness.Fragments.Administrator;
import com.elyehgmail.ladimer.smartbusiness.Fragments.ClockInOut;
import com.elyehgmail.ladimer.smartbusiness.Fragments.Rating;

public class Main extends AppCompatActivity implements
        ClockInOut.OnFragmentInteractionListener, Rating.OnFragmentInteractionListener ,Administrator.OnFragmentInteractionListener{

//    Fragment newFragment = new SecondFragment();
//    FragmentTransaction transaction = getFragmentManager().beginTransaction();
//    transaction.replace(R.id.header, newFragment);
//    transaction.addToBackStack(null); // Ads FirstFragment to the back-stack
//    transaction.commit();
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button clockIn, rating, admin ;

        final LinearLayout container ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout)findViewById(R.id.fragment_container);
        clockIn = (Button) findViewById(R.id.clockButton);
        rating = (Button) findViewById(R.id.rateus);
        admin = (Button) findViewById(R.id.admin);


        Fragment f = new Fragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ftrns = fm.beginTransaction();

       // createListeners();

        View.OnClickListener ClockInlistener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                container.removeAllViews();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //  HelloFragment hello = new HelloFragment();
                //  fragmentTransaction.add(R.id.fragment_container, hello, "HELLO");
                ClockInOut clockinout = new ClockInOut();
                fragmentTransaction.add(R.id.fragment_container,clockinout);

                fragmentTransaction.commit();
            }

        };

        View.OnClickListener ratinglistener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                container.removeAllViews();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //  HelloFragment hello = new HelloFragment();
                //  fragmentTransaction.add(R.id.fragment_container, hello, "HELLO");
                Rating rating = new Rating();
                fragmentTransaction.add(R.id.fragment_container,rating);

                fragmentTransaction.commit();
            }

        };

        View.OnClickListener adminlistener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                container.removeAllViews();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //  HelloFragment hello = new HelloFragment();
                //  fragmentTransaction.add(R.id.fragment_container, hello, "HELLO");
                Administrator admin = new Administrator();
                fragmentTransaction.add(R.id.fragment_container,admin);

                fragmentTransaction.commit();
            }

        };


        clockIn.setOnClickListener(ClockInlistener);

        admin.setOnClickListener(adminlistener);
        rating.setOnClickListener(ratinglistener);


//        Configuration conf = getResources().getConfiguration();
//
//        // if in portrait, make the side list thinner
//        if (conf.orientation == Configuration.ORIENTATION_PORTRAIT){
//
//        }

    }//onCreate

//    private void createListeners() {
//
//         View.OnClickListener ClockInlistener = new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//              //  HelloFragment hello = new HelloFragment();
//              //  fragmentTransaction.add(R.id.fragment_container, hello, "HELLO");
//                ClockInOut clockinout = new ClockInOut();
//                fragmentTransaction.add(R.id.fragment_container,clockinout);
//
//                fragmentTransaction.commit();
//            }
//
//        };
//    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
