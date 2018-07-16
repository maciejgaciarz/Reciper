package models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mgaciarz on 2018-06-07.
 */

public class Recipe implements Parcelable {

    private String label;

    private String imageURL;

    private String instructionURL;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Recipe(String label, String imageURL, String instructionURL, long id) {
        this.label = label;
        this.imageURL = imageURL;
        this.instructionURL = instructionURL;
        this.id = id;

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getInstructionURL() {
        return instructionURL;
    }

    public void setInstructionURL(String instructionURL) {
        this.instructionURL = instructionURL;
    }


    protected Recipe(Parcel in) {
        label = in.readString();
        imageURL = in.readString();
        instructionURL = in.readString();
        id = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        dest.writeString(imageURL);
        dest.writeString(instructionURL);
        dest.writeLong(id);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}