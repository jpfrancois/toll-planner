package com.tollplanner.services;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.tollplanner.Constants.*;

/**
 * Created by pablo on 21/02/16.
 */
public class TollService {

    public static final String URL = "http://aplicaciones4.sct.gob.mx/sibuac_internet/ControllerUI";

    public static String search() throws IOException, URISyntaxException {
        HttpGet httpGet = new HttpGet(URL);
        URI uri = new URIBuilder(httpGet.getURI())
                .addParameter(ACTION, "cmdSolRutas")
                .addParameter(TYPE, "1")
                .addParameter(ORIGIN_STATE, "9")
                .addParameter(DESTINATION_STATE, "11")
                .addParameter(ORIGIN_CITY, "9010")
                .addParameter(DESTINATION_CITY, "11180")
                .addParameter(VEHICLES, "A")
                .addParameter(NETWORK, "simplificada")
                .build();
        httpGet.setURI(uri);

        CloseableHttpResponse response = HttpClients.createDefault().execute(httpGet);
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(search());
    }

}
