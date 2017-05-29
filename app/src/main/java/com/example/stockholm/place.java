package com.example.stockholm;

public class place {
    // Name of place
    private String mName;

    // Place Description
    private String mDescription;

    // Url for the website of the place
    private String mUrl;

    // Price of place
    private String mPrice;

    /** Image resource ID for the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /** Constant value that represents no image was provided for this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Constructs a new {@link place} object.
     *
     * @param name is the name of the place
     * @param description description of the place
     * @param url is the website address of the place
     * @param price is the cost of the place
     */

    public place(String name, String description, String url, int imageResourceId, String price) {
        mName = name;
        mDescription = description;
        mUrl = url;
        mImageResourceId = imageResourceId;
        mPrice = price;
    }

    public String getName() { return mName; }
    public String getDescription() {return mDescription; }
    public String getUrl() {return mUrl; }
    public int getmImageResourceId() { return mImageResourceId; }
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    public String getPrice() {return mPrice; }

}
