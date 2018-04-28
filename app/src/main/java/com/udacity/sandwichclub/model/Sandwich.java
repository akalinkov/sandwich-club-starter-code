package com.udacity.sandwichclub.model;

import java.util.List;

public class Sandwich {

    public static final String NO_INFORMATION = "No information found";

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    private String stringFromList(List<String> list) {
        if (0 == list.size()) return NO_INFORMATION;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i ++) {
            sb.append("\u2022 ").append(list.get(i));
            if (i + 1 <  list.size()) sb.append("\n");
        }
        return sb.toString();
    }

    private String unorderedList(List<String> list) {
        if (0 == list.size()) return NO_INFORMATION;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i ++) {
            sb.append(list.get(i));
            sb.append((i + 1 < list.size()) ? ", " : "");
        }
        return sb.toString();
    }

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getAlsoKnownAs() {
        return unorderedList(alsoKnownAs);
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        if ("".equals(placeOfOrigin)) return NO_INFORMATION;
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredients() {
        return stringFromList(ingredients);
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
