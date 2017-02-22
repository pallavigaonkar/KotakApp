package myapp.winsofttech.com.kotak;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Opportunity extends Fragment {
    EditText dueBy;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    Spinner productcategory,type,productsubtype;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments


        View rootView=inflater.inflate(R.layout.fragment_opportunity, container, false);
        dueBy=(EditText)rootView.findViewById(R.id.input_dom);
        productcategory=(Spinner)rootView.findViewById(R.id.input_productcategory);
        type=(Spinner)rootView.findViewById(R.id.input_type);
        productsubtype=(Spinner)rootView.findViewById(R.id.input_subproducttype);


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
        });
*/
        ArrayAdapter<String> adapter;
        List<String> list;
        list=new ArrayList<String>();
        list.add("select");
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        productcategory.setAdapter(adapter);
        type.setAdapter(adapter);
        productsubtype.setAdapter(adapter);

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

        dueBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

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
                   Fragment fragment=new Action();

                    return true;
                }
                return false;
            }
        });
    }

    private void updateLabel() {

        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dueBy.setText(sdf.format(myCalendar.getTime()));
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Log / Call Edit");
    }
   /* public void changeFragment(int position) {
        int fragmentId;
        switch (position) {
            case R.id.oprations:{
                //fragmentId = R.id.content_my_home;
                pushFragment(new CallLogEdit());
                break;
            }
            case R.id.callreport:{
                //    Toast.makeText(getContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                //manager.beginTransaction().replace(R.id.my_activities, new CallLogEdit()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
                //fragmentId = R.id.content_my_home;
                pushFragment(new CallReport());
                break;
            }
            case R.id.action:{
                // Toast.makeText(getContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                //manager.beginTransaction().replace(R.id.my_activities, new CallLogEdit()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
                //fragmentId = R.id.content_my_home;
                pushFragment(new Action());
                break;
            }
            case R.id.opportunity:{
                // Toast.makeText(getContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                //manager.beginTransaction().replace(R.id.my_activities, new CallLogEdit()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
              //  fragmentId = R.id.content_my_home;
                pushFragment(new Opportunity());
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
        }
    }*/
}
