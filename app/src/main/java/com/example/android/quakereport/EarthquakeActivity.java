//package name
package com.example.android.quakereport;

//imports
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

//class defining
public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    //overriding onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting the activity that we want to populate and in this case
        // we have our listView that we have to set.
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        // This is the use of generics of java which tells that about your
        // creation of making a sequence of your explicit type
        ArrayList<QuakeList> earthquakes = new ArrayList<>();
        earthquakes.add(new QuakeList(4.5,"San Francisco",12071999));
        earthquakes.add(new QuakeList(7.2,"London",12071999));
        earthquakes.add(new QuakeList(6.5,"Tokyo",12071999));
        earthquakes.add(new QuakeList(3.9,"Mexico",12071999));
        earthquakes.add(new QuakeList(5.7,"Moscow",12071999));
        earthquakes.add(new QuakeList(6.0,"Rio de Janeiro",12071999));
        earthquakes.add(new QuakeList(8.9,"Paris",12071999));

        // Find a reference to the {@link ListView} in the layout
        ListView lw = (ListView) findViewById(R.id.list);

        //This was previously the ArrayAdapter which used to take the inputs consisting context,
        // the layout which were made by developers "android.R.layout.simple_list_item_1", and
        // the resource which you wanted to populate in the list which were fixed.
        // this was the input:- this,android.R.layout.simple_list_item_1, earthquakes
        // But due to this we created a new adapter which can take our own type of
        // inputs {@link QuakeList} and can set it to our own type of layout{@link model.xml}.

        QuakeAdapter adapter = new QuakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        lw.setAdapter(adapter);
    }
}
