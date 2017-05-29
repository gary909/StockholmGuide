package com.example.stockholm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // list of Shopping locations
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Stadsmission Second hand", "Charity shops", "https://www.stadsmissionen.se/",  R.drawable.stadsmission, "£"));
        places.add(new place("Emmaus second hand", "Boutique second hand", "http://www.emmausstockholm.se/butiker/",  R.drawable.emmaus, "£"));
        places.add(new place("Design Torget", "Interesting & unique designs", "http://www.designtorget.se/",  R.drawable.designtorget, "££"));
        places.add(new place("Filippa K Secondhand", "Famous Stockholm brand but used", "http://www.filippaksecondhand.se/",  R.drawable.filippak, "£££"));
        places.add(new place("Humana", "Used clothing", "http://www.humanasecondhand.se/",  R.drawable.humanasecondhand, "£"));
        places.add(new place("Mickes Vinyl, CD & DVDs", "Used Vinyl, CD & DVD's", "http://www.mickes-cdvinyl.se/",  R.drawable.mikeysrecords, "£"));
        places.add(new place("Myrorna Secondhand", "Cheap & unpretentious secondhand", "http://www.myrorna.se/", R.drawable.myrorna, "£"));
        places.add(new place("Judits Second hand", "Clothes from the 1920’s onwards + Local designers", "http://www.judits.se/",  R.drawable.judits, "£££"));
        places.add(new place("Andra Chansen Second Hand", "Traditional charity shop", "http://www.vintagekartan.se/0477054/Andra_Chansen_Second_Hand", R.drawable.andreachansen, "££"));

        // Create a new {@link ArrayAdapter} for shopping category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_shopping);

        // Find a reference to the {@link ListView} in the layout
        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        placesListView.setAdapter(adapter);
        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                place currentPlace = adapter.getItem(position);
                Uri placeUri = Uri.parse(currentPlace.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, placeUri);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }
}
