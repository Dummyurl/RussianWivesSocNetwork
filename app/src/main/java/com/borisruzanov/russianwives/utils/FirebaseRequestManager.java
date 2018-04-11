package com.borisruzanov.russianwives.utils;

import java.util.HashMap;

public class FirebaseRequestManager {

    public static HashMap<String, String> createNewUser(String displayName, String deviceToken){
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("name", displayName);
        userMap.put("status", "Default status");
        userMap.put("image", "default");
        userMap.put("thumb_image", "default");
        userMap.put("device_token", deviceToken);
        userMap.put("relationship_status", "default");
        userMap.put("gender", "default");
        userMap.put("how_tall", "default");
        userMap.put("body_type", "default");
        userMap.put("ethnicity", "default");
        userMap.put("faith", "default");
        userMap.put("languages", "default");
        userMap.put("smoking_status", "default");
        userMap.put("drink_status", "default");
        userMap.put("number_of_kids", "default");
        userMap.put("want_children_or_not", "default");
        userMap.put("hobby", "default");
        return userMap;
    }

}
