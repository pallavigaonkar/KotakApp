package myapp.winsofttech.com.kotak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by javateam on 6/2/17.
 */

public class MyDashboard extends Fragment {

    GraphView  graphView;
    LineGraphSeries<DataPoint> series;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View  rootView=inflater.inflate(R.layout.my_dashboard,container, false);


        double y,x;
        x=-5.0;

        graphView=(GraphView)rootView.findViewById(R.id.graph1);


        series=new LineGraphSeries<DataPoint>();
        for(int i=0; i<500;i++)
        {
            x=x+3;
            y=Math.sin(x);

            series.appendData(new DataPoint(x,y), true, 500);

        }
        graphView.addSeries(series);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("My Dashboard");
    }


}
