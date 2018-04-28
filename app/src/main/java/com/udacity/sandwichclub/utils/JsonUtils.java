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
            JSONObject name = sandwich.getJSONObject("name");
            String mainName = name.getString("mainName");
            List<String> alsoKnownAs = parseArray(name.getJSONArray("alsoKnownAs"));
            String placeOfOrigin = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");
            List<String> ingredients = parseArray(sandwich.getJSONArray("ingredients"));
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            Log.e(TAG, "parseSandwichJson: Failed to parseing '" + json + "'", e);
            e.printStackTrace();
        }

        return null;
    }
}
