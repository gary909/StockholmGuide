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
public class DrinkingFragment extends Fragment {

    public DrinkingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // list of Drinking locations
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Kelly's Bar", "Scandinavian rock/metal bar", "http://www.kellysbar.se/",  R.drawable.kellysbar, "££"));
        places.add(new place("Cafe Sten Sture", "Hidden little cellar bar", "http://www.cafestensture.se//",  R.drawable.cafestenstura, "£"));
        places.add(new place("Harry B James", "American style bar with a bit of a rock edge", "https://www.harrybjames.com//",  R.drawable.harrybjamesbar, "£££"));
        places.add(new place("Oliver Twist Bar", "Nice friendly local", "http://www.olivertwist.se/",  R.drawable.olivertwists, "£££"));
        places.add(new place("Kings Bar", "Cheapest drinks in Stockholm?", "https://popularabarer.se/0348343/Kings_Bar//",  R.drawable.kingsbar, "£"));
        places.add(new place("Dovas", "Beer 50cl from 35sek", "https://www.tripadvisor.se/Restaurant_Review-g189852-d7211992-Reviews-Dovas_Hornsgatan_90-Stockholm.html//",  R.drawable.dovasbar, "£"));
        places.add(new place("Lasse i Parken", "Bands play outside most nights for free in the summer months", "https://www.lasseiparken.se/",  R.drawable.lasseiparken, "£££"));
        places.add(new place("Viking Bar", "50cl Beer 39sek", "https://foursquare.com/v/viking-bar/51a12a8b498eeb0fb7ba2a13/",  R.drawable.vikingbar, "££"));
        places.add(new place("Charlies Bar Kok", "40cl Draught beer 28sek", "https://www.yelp.com/biz/charlies-k%C3%B6k-och-bar-stockholm/",  R.drawable.charliesbar, "££"));

        // Create a new {@link ArrayAdapter} for drinking category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_drinking);

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
