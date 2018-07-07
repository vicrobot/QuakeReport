//package name
package com.example.android.quakereport;

//imports
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

//class defining

/**
 * This class is the modification of ArrayAdapter in terms of resource input and their population in
 * the UI. This class do all the same things as ArrayAdapter but in extras it overrides its getView
 * method for specific view giving to the ListView.
 */
public class QuakeAdapter extends ArrayAdapter<QuakeList> {

    //The global variable for QuakeList access throughout the process.
    ArrayList<QuakeList> list1;

    //No public or private because this constructor is package-private.
    // The constructor needs to do all things that the ArrayAdapter's contructor do(if we
    //specially wants to take the profits of the super class); thus calling 'super()'.
    //The constructor of ArrayAdapter takes atleast three inputs which we have provided in the
    // 'super()' calling but we have not given the middle argument because we will firstly modify
    // it; and thus we wrote '0' in place of a real resource. Although we only provide two arguments
    // in QuakeAdapter because we gave the middle one inside the constructor.
    QuakeAdapter(Context ctx, ArrayList<QuakeList> list){
        super(ctx,0, list);
        list1 = list;
    }

    //overriding the getView method which is called by the listView from ArrayAdapter to provide it
    // the views to populate. The arguments it provide are the position of the view, the view
    // object, and the viewGroup of  view is the part of.
    @Override
    public View getView(int position, View v, ViewGroup vg){

        //Checking if the view provided by the ListView is null or not. And if it is null; then
        // inflate it in the given context with the suitable layout.
        if(v==null){
            LayoutInflater lf = LayoutInflater.from(getContext());
            v = lf.inflate(R.layout.model,vg,false);
        }

        // Making the TextView objects from the subViews or child Views of the view 'v'.
        TextView tv = (TextView)v.findViewById(R.id.mag);
        TextView tv1 = (TextView)v.findViewById(R.id.place);
        TextView tv2 = (TextView)v.findViewById(R.id.date);

        // Setting the textView with the value getting from the QuakeList object by the provided
        // position. Also; we are converting it to strings because we cannot put integers directly
        // to populate in the TextView because it only accepts strings; because integer act for
        // resource ids providing.
        tv.setText(String.valueOf(list1.get(position).getIntensity()));
        tv1.setText(String.valueOf(list1.get(position).getPlace()));
        tv2.setText(String.valueOf(list1.get(position).getDate()));

        //Setting the onClickListener in each view we give to ListView.
        v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Hello",Toast.LENGTH_SHORT).show();
            }

        });

        //Returning the modified view.
        return v;
    }
}
