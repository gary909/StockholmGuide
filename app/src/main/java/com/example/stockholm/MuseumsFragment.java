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
public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // list of Museum locations
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Transport Museum", "Includes entrance to the toy museum", "https://www.sparvagsmuseet.sl.se/", R.drawable.transportmuseum, "££"));
        places.add(new place("Toy Museum Stockholm", "Part of the Transport Museum", "https://www.leksaksmuseet.se/html/english.htm/", R.drawable.toymuseum, "££"));
        places.add(new place("Nobel Museum", "Learn about the Nobel Prize and its founder Alfred Nobel", "http://www.nobelmuseum.se/", R.drawable.nobelmuseum, "££"));
        places.add(new place("Stadshusset Tower", "Take the 106 meter trip to the top of Stockholms City Hall Tower", "http://www.stockholm.se/stadshuset/", R.drawable.stadshuset, "£"));
        places.add(new place("Diving Museum", "Learn about the pressures of diving", "http://www.sdhf.se/", R.drawable.divingmuseum, "£"));
        places.add(new place("Nordiska Museet", "Explore Sweden's cultural history", "http://www.nordiskamuseet.se/", R.drawable.nordiskamuseet, "££"));
        places.add(new place("Medieval Stockholm Museum", "Learn about medieval Stockholm", "http://www.medeltidsmuseet.stockholm.se/", R.drawable.medievelmuseum, "£"));
        places.add(new place("Music & Theatre Museum", "try out a really wide selection of musical instruments", "http://www.musikmuseet.se/", R.drawable.musicmuseum, "££"));
        places.add(new place("Customs Museum", "Learn about tax-dodging smugglers", "http://www.tullverket.se/", R.drawable.tullmuseum, "£"));
        places.add(new place("Stockholm City Museum", "Discover how Stockholm grew from a small settlements into what it is today", "http://www.stadsmuseum.stockholm.se/", R.drawable.stadsmuseum, "£"));
        places.add(new place("Historiska Museet", "Nordic artifacts spanning thousands of years", "http://www.historiska.se/", R.drawable.fillerstockholmsunset, "£££"));
        places.add(new place("Economy Museum", "The history of money", "http://www.myntkabinettet.se/", R.drawable.swedishcoin, "£"));
        places.add(new place("Maritime Museum", "Stockholm's Maritime history", "http://www.sjohistoriska.se/en/", R.drawable.sjohistoriska2, "££"));
        places.add(new place("Post Museum", "Letters tell you something about the post", "http://www.postmuseum.posten.se/museng/", R.drawable.postmuseum1, "££"));
        places.add(new place("Army Museum", "The history of Sweden's warfare", "http://www.sfhm.se/", R.drawable.armymuseum, "£££"));
        places.add(new place("House of Nobility", "Artifacts from the upper classes", "http://www.riddarhuset.se", R.drawable.fillerstockholmskyline1, "£££"));
        places.add(new place("Police Museum", "Forensic techniques & history", "http://www.polismuseet.se/", R.drawable.policemuseum, "£"));
        places.add(new place("Sports Museum", "The many different types of sports through the ages", "http://www.riksidrottsmuseet.se/", R.drawable.sportsmuseum, "£"));
        places.add(new place("Langholmen Prison Museum", "Prison Museum", "http://www.langholmen.com/en/Museum/Museum.aspx", R.drawable.prison, "£"));
        places.add(new place("Arkitektur Museet", "Charting the course of Swedish Architecture", "http://www.arkitekturmuseet.se/english/", R.drawable.architecturemuseum, "£££"));

        // Create a new {@link ArrayAdapter} for museum category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_museums);

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
