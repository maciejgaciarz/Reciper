package models;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mgaciarz on 2018-06-07.
 */

public class Recipe {

    private String label;

    private String imageURL;

    public Recipe(String label, String imageURL, String instructionURL) {
        this.label = label;
        this.imageURL = imageURL;
        this.instructionURL = instructionURL;
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
