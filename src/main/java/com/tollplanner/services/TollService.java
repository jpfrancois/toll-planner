package com.tollplanner.services;

import static com.tollplanner.Constants.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.tollplanner.beans.SearchParams;
import com.tollplanner.enums.NetworkType;
import com.tollplanner.enums.VehicleType;

/**
 * @author pablo
 */
public class TollService {

    public static String search(final SearchParams params) throws IOException, URISyntaxException {
        final HttpGet httpGet = new HttpGet(SERVICE_URL);
        final URI uri = new URIBuilder(httpGet.getURI())
                .addParameter(ACTION, SERVICE_CMD)
                .addParameter(TYPE, SERVICE_TYPE)
                .addParameter(ORIGIN_STATE, params.getOriginState())
                .addParameter(DESTINATION_STATE, params.getDestinationState())
                .addParameter(ORIGIN_CITY, params.getOriginCity())
                .addParameter(DESTINATION_CITY, params.getDestinationCity())
                .addParameter(VEHICLES, params.getVehicleType().getCode())
                .addParameter(NETWORK, params.getNetworkType().getCode())
                .build();
        httpGet.setURI(uri);

        final CloseableHttpResponse response = HttpClients.createDefault().execute(httpGet);
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }

    public static void main(final String[] args) throws IOException, URISyntaxException {
        final JsonObject data = getJsonData();
        final Map<String, String> states = parseStates(data);
        final Map<String, String> cities = parseCities(data);

        final SearchParams params = new SearchParams();
        params.setOriginState(states.get("Distrito Federal"));
        params.setDestinationState(states.get("Guanajuato"));
        params.setOriginCity(cities.get("Cd. De México (Zócalo)"));
        params.setDestinationCity(cities.get("León"));
        params.setVehicleType(VehicleType.CAR);
        params.setNetworkType(NetworkType.SIMPLIFIED);

        System.out.println(search(params));
    }

    private static JsonObject getJsonData() throws FileNotFoundException {
        final JsonReader reader = Json.createReader(new FileReader("src/main/resources/data.json"));
        final JsonObject data = reader.readObject();
        reader.close();
        return data;
    }

    private static Map<String, String> parseStates(final JsonObject data) {
        final JsonObject statesData = data.getJsonObject(JSON_STATES);
        final Map<String, String> states = new HashMap<>();
        for (final Entry<String, JsonValue> entry : statesData.entrySet()) {
            states.put(((JsonString) entry.getValue()).getString(), entry.getKey());
        }
        return states;
    }

    private static Map<String, String> parseCities(final JsonObject data) {
        final JsonObject citiesData = data.getJsonObject(JSON_LOCALITIES);
        final Map<String, String> cities = new HashMap<>();
        for (final Entry<String, JsonValue> entry : citiesData.entrySet()) {
            final JsonObject city = (JsonObject) entry.getValue();
            cities.put(city.getString(JSON_LOCALITY_NAME), entry.getKey());
        }
        return cities;
    }

}
