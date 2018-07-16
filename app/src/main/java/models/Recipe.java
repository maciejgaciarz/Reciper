package models;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mgaciarz on 2018-06-07.
 */

public class Recipe {

    private String label;

    private String imageURL;

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

    private String instructionURL;

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
}
