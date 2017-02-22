package myapp.winsofttech.com.kotak;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by javateam on 6/2/17.
 */

public class MyActivities extends Fragment {
    private static final String YOU_SPEC = "you";
    private static final String TAG = MainActivity.class.getSimpleName();

    private Fragment fragment;
    private FragmentManager fragmentManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View rootView = inflater.inflate(R.layout.fragment_assigned_to_me, container, false);
/*
        TabHost tabHost = (TabHost) rootView.findViewById(R.id.tabHost);
        tabHost.setup();


        ////
        TabHost.TabSpec    firstTabSpec = tabHost.newTabSpec("tid1");
        TabHost.TabSpec secondTabSpec = tabHost.newTabSpec("tid2");
        TabHost.TabSpec thirdTabSpec = tabHost.newTabSpec("tid3");

    firstTabSpec.setIndicator("Current").setContent(new Intent(getContext(),CallLogEdit.class));
    secondTabSpec.setIndicator("24Hour").setContent(new Intent(getContext(),CallReport.class));
    thirdTabSpec.setIndicator("48Hour").setContent(new Intent(getContext(),Action.class));

    tabHost.addTab(firstTabSpec);
    tabHost.addTab(secondTabSpec);
    tabHost.addTab(thirdTabSpec);



    for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
    {
        TextView tv =(TextView)tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
        tv.setTextColor(Color.BLACK);
        tv.setPadding(10, 10, 10, 15);
        tv.setTextSize((float) 20.0);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setBackgroundResource(R.mipmap.ic_launcher);
        tv.setHeight(100);
        tv.setWidth(100);
    }*/

        ////


/*
    //Tab 1
     TabHost.TabSpec spec = host.newTabSpec("Tab One");




        spec.setIndicator("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("",getResources().getDrawable(R.mipmap.ic_launcher));

        host.addTab(spec);


        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);

        spec.setIndicator("",getResources().getDrawable(R.mipmap.ic_launcher));
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);

        spec.setIndicator("",getResources().getDrawable(R.mipmap.ic_launcher));

        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("Tab Four");
        spec.setContent(R.id.tab3);
        spec.setIndicator("",getResources().getDrawable(R.mipmap.ic_launcher));
        // spec.setIndicator("Tab Three");
        host.addTab(spec);*/

       /* BottomNavigationView bottomNavigationView = (BottomNavigationView)
                rootView.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item
                changeFragment(item.getItemId());
                //selectFragment(item);
                return true;
            }
        });*/


        BottomNavigationView    bottomNavigation = (BottomNavigationView)rootView.findViewById(R.id.bottom_navigationnew);
        bottomNavigation.inflateMenu(R.menu.myactivitiesitems);
        fragmentManager = getFragmentManager();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.assignedtome:
                        fragment = new AssignedToMe();
                //        Fragment newFragment = new ExampleFragment();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.main_containernew, fragment,"A");
                        transaction.addToBackStack(null);

// Commit the transaction
                        transaction.commit();
                        break;
                    case R.id.assignedbyme:
                        fragment = new AssignedByMe();
                        break;
                    case R.id.mycomments:
                        fragment = new MyComments();
                        break;
                    case R.id.mypendingtasks:
                        fragment = new PendingTask();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_containernew, fragment).commit();
                return true;
            }
        });

        return rootView;


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("My Activities");
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    // handle back button's click listener
                    return true;
                }
                return false;
            }
        });


    }



}
