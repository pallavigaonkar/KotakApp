package myapp.winsofttech.com.kotak;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by javateam on 6/2/17.
 */

public class CallLogEdit extends Fragment{

    LinearLayout mainlayout,mainlayout2;
    EditText frmdate,todate,dateofmeeting;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date,date1,date2;
    Spinner typeofreferral,clientType,Tagcall;
    ArrayAdapter<String> adapter;
    List<String> list;

    private Fragment fragment;
    private FragmentManager fragmentManager;

    public CallLogEdit() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View rootView = inflater.inflate(R.layout.fragment_call_log_edit, container, false);
        mainlayout=(LinearLayout)rootView.findViewById(R.id.mainlayout);
        mainlayout2=(LinearLayout)rootView.findViewById(R.id.mainlayout2);
        frmdate=(EditText)rootView.findViewById(R.id.input_frmdate);
        todate=(EditText)rootView.findViewById(R.id.input_todate);
        dateofmeeting=(EditText)rootView.findViewById(R.id.input_dom);
        typeofreferral=(Spinner)rootView.findViewById(R.id.input_typeofreferral);
        clientType=(Spinner)rootView.findViewById(R.id.input_clienttype);
        Tagcall=(Spinner)rootView.findViewById(R.id.input_tagcall);


        SwitchCompat switchCompat = (SwitchCompat) rootView.findViewById(R.id.switch_compat);
        switchCompat.setOnCheckedChangeListener(onCheckedChanged());


        ArrayAdapter<String> adapter;
        List<String> list;
        list = new ArrayList<String>();
        list.add("Select");
        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeofreferral.setAdapter(adapter);
        clientType.setAdapter(adapter);
        Tagcall.setAdapter(adapter);

        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        date1 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel1();
            }

        };

        date2 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel2();
            }

        };

        frmdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();



            }
        });

        todate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(getActivity(), date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        dateofmeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(getActivity(), date2, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        /*BottomNavigationView bottomNavigationView = (BottomNavigationView)
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
        BottomNavigationView bottomNavigation = (BottomNavigationView)rootView.findViewById(R.id.bottom_navigationnew);
        bottomNavigation.inflateMenu(R.menu.bottom_nav_items);
        fragmentManager = getFragmentManager();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.operations:
                        fragment = new CallLogEdit();
                        break;
                    case R.id.callreport:
                        fragment = new CallReport();
                        break;
                    case R.id.action:
                        fragment = new Action();
                        break;
                    case R.id.opportunity:
                        fragment = new Opportunity();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_containernew, fragment).commit();
                return true;
            }
        });

        // Inflate the layout for this fragment

        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.RGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.radiobuttoncall) {
                   // Toast.makeText(getActivity().getApplicationContext(), "choice: A",
                     //       Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.radiobuttonaction) {
                    //Toast.makeText(getActivity().getApplicationContext(), "choice: B",
                      //      Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.radiobuttonoppotunity){
                   // Toast.makeText(getActivity().getApplicationContext(), "choice: C",
                 //           Toast.LENGTH_SHORT).show();
                }
            }

        });
            return rootView;
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
                    fragment=new MyActivities();

                    return true;
                }
                return false;
            }
        });
    }

    private void updateLabel() {

        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        frmdate.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateLabel1() {

        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        todate.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateLabel2() {

        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateofmeeting.setText(sdf.format(myCalendar.getTime()));
    }


    private CompoundButton.OnCheckedChangeListener onCheckedChanged() {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {

                    case R.id.switch_compat:
                        setButtonState(isChecked);
                        break;
                }
            }
        };
    }

    private void setButtonState(boolean state) {
        if (state) {

            mainlayout.setVisibility(View.VISIBLE);
            mainlayout2.setVisibility(View.GONE);

      //   Toast.makeText(MainActivity.this, "Button enabled!", Toast.LENGTH_SHORT).show();
        } else {
            mainlayout.setVisibility(View.GONE);
            mainlayout2.setVisibility(View.VISIBLE);
            //     Toast.makeText(MainActivity.this, "Button disabled!", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Log / Edit Call");
    }

   /* public void changeFragment(int position) {
        int fragmentId;

        Fragment fragment = null;
        switch (position) {
            case R.id.oprations:{
               // fragment = new CallLogEdit();
              pushFragment(new CallLogEdit());

                break;
            }
            case R.id.callreport:{
               pushFragment(new CallReport());
               // fragment = new CallReport();
                break;
            }
            case R.id.action:{
               // Toast.makeText(getContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                //manager.beginTransaction().replace(R.id.my_activities, new CallLogEdit()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
                pushFragment(new Action());
               // fragment = new Action();
                break;
            }
            case R.id.opportunity:{
                // Toast.makeText(getContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                //manager.beginTransaction().replace(R.id.my_activities, new CallLogEdit()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
               // fragmentId = R.id.content_my_home;
              pushFragment(new Opportunity());
             //   fragment = new Opportunity();
                break;
            }



        }

    }

    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
           if (ft != null) {
              ViewGroup mContainer = (ViewGroup) getActivity().findViewById(R.id.content_my_home);
                mContainer.removeAllViews();
                super.onDestroyView();
                ft.add(R.id.content_my_home, fragment,"A");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();

            }

           *//* if (fragment != null) {
                FragmentTransaction ft1 = fragmentManager.beginTransaction();
                ft1.add(R.id.container, fragment, fragment.getTag());
                ft1.commit();
            }*//*
        }
    }*/
}
