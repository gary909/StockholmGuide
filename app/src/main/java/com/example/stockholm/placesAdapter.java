package com.example.stockholm;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class placesAdapter extends ArrayAdapter<place> {

    private int mColorResourceID;

    public placesAdapter(Context context, ArrayList<place> pPlaces, int colorResourceID) {
        super(context, 0, pPlaces);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.display_activity, parent, false);
        }

        //get the object located at given position
        place currentPlace = getItem(position);

        // Find the TextView with view ID name
        TextView name = (TextView) listView.findViewById(R.id.name);
        name.setText(currentPlace.getName());

        // Find the TextView with ID knownFor
        TextView description = (TextView) listView.findViewById(R.id.description);
        description.setText(currentPlace.getDescription());

        // Find the background colour
        View container = listView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        container.setBackgroundColor(color);

        // Find the TextView with ID price
        TextView price = (TextView) listView.findViewById(R.id.price);
        price.setText(currentPlace.getPrice());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listView.findViewById(R.id.image);
        // Check if an image is provided
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getmImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        return listView;
    }
}
