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
public class EatingFragment extends Fragment {

    public EatingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // list of Eating locations
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Folkets Kebab", "Good falafels", "http://www.tripadvisor.com/Restaurant_Review-g189852-d810122-Reviews-Folkets_Kebab-Stockholm.html/",  R.drawable.kebabfolkets, "£"));
        places.add(new place("Nystekt Strömming", "Stockholm's famous fish stand", "https://www.tripadvisor.com/Restaurant_Review-g189852-d2201594-Reviews-Nystekt_Stromming-Stockholm.html/",  R.drawable.fishstand, "££"));
        places.add(new place("Bistro Celine", "Pasta dishes from 79sek", "http://www.bistro-celine.se//",  R.drawable.foodhallostermalm, "££"));
        places.add(new place("Bagel Street Cafe", "Bagels from 35sek", "http://www.bagelstreet.se//",  R.drawable.bagelstreetcafe, "££"));
        places.add(new place("Jerusalem Kebab", "Maybe Stockholm's most popular kebab", "https://www.tripadvisor.com/Restaurant_Review-g189852-d1119643-Reviews-Jerusalem_Kebab-Stockholm.html/",  R.drawable.jerusalemkebab, "£"));
        places.add(new place("Lilla Harem Pizzaria", "Hidden pizzaria selling large pizzas from 60sek", "http://www.lillaharem.se/",  R.drawable.lillaharempizza, "££"));
        places.add(new place("St Pauls Pizzeria", "Cheap central pizza", "https://www.yelp.com/biz/s-t-pauls-pizzeria-stockholm",  R.drawable.stpaulspizza, "££"));
        places.add(new place("Waynes Coffee", "Stockholm's version of Starbucks", "http://www.waynescoffee.se//",  R.drawable.waynescoffee, "£££"));

        // Create a new {@link ArrayAdapter} for eating category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_eating);

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
