package br.andresgois.github.io.webserviceapi.util;

import static br.andresgois.github.io.webserviceapi.util.Contants.*;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Shared {
   
    private Shared() {}
    
    public static JSONArray stringToObject(String obj) throws JSONException {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(obj);
            System.out.println(jsonObject.getJSONArray("value").getJSONObject(0));
        } catch (JSONException e) {
            log.error(ERRO_CONVERSAO);
            e.printStackTrace();
        }
        return jsonObject.getJSONArray("value");
    }
}
