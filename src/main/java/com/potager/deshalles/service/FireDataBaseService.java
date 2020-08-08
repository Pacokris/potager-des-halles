package com.potager.deshalles.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.potager.deshalles.error.FirebaseException;
import com.potager.deshalles.error.JacksonUtilityException;
import com.potager.deshalles.model.Item;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FireDataBaseService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Firebase firebase = new Firebase("https://potager-des-halles.firebaseio.com/");
    private final Map<String, Object> modelAndViewMap = new HashMap<>();

    public FireDataBaseService() throws FirebaseException {
    }

    public Map<String, Object> recupererAllPlats() throws JacksonUtilityException, IOException, FirebaseException {

        final String data = firebase.get().getRawBody();

        String[] listParRubrique = data.substring(1, data.length() - 1).
                replaceAll("],", "]],").replaceAll("null,", "")
                .split("],");

        for (String p : listParRubrique) {
            ajoutDesPlatsDeLaRubrique(p);
        }
        return modelAndViewMap;
    }

    private void ajoutDesPlatsDeLaRubrique(String listPlats) throws JacksonUtilityException, IOException, FirebaseException {

        String rubrique = listPlats.substring(0, listPlats.indexOf(":[")).replaceAll("\"", "");

        List<Item> listMappe = mapper.readValue(listPlats.substring(listPlats.indexOf("[")), new TypeReference<List<Item>>() {
        });

        modelAndViewMap.put(rubrique, listMappe);
    }
}
