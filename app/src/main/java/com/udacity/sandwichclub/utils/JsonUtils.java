package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getSimpleName();

    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE = "image";
    private static final String INGREDIENTS = "ingredients";

    private static List<String> parseArray (JSONArray array) {
        List<String> list = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                list.add(array.getString(i));
            }
        } catch (JSONException e) {
            Log.e(TAG, "generateStringFromArray: Could not process array '" + array + "'", e);
            e.printStackTrace();
        }
        return list;
    }

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject name = sandwich.getJSONObject(NAME);
            String mainName = name.getString(MAIN_NAME);
            List<String> alsoKnownAs = parseArray(name.getJSONArray(ALSO_KNOWN_AS));
            String placeOfOrigin = sandwich.getString(PLACE_OF_ORIGIN);
            String description = sandwich.getString(DESCRIPTION);
            String image = sandwich.getString(IMAGE);
            List<String> ingredients = parseArray(sandwich.getJSONArray(INGREDIENTS));
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            Log.e(TAG, "parseSandwichJson: Failed to parse '" + json + "'", e);
            e.printStackTrace();
        }
        return null;
    }
}
