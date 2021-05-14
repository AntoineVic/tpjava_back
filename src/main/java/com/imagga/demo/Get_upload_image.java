package com.imagga.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootApplication
public class Get_upload_image
{
    public static void main(String[] args) throws IOException {}

    public static String uploaded_img(String key, String option) throws IOException
    {
        String credentialsToEncode = "acc_63206b86f407506" + ":" + "d10663e15d3f13f665227095d10e76b8";
        String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));
        String SearchType = "";

        System.out.println("\noption : " + option);

        if (option.equals("face"))
        {
            SearchType = "faces/detections";
        }
        else if (option.equals("cat"))
        {
            SearchType = "categories/personal_photos";
        }

        String endpoint_url = "https://api.imagga.com/v2/" + SearchType;
        String image_KEY = key;

        String url = endpoint_url + "?image_upload_id=" + image_KEY + "&language=fr";

        URL urlObject = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestProperty("Authorization", "Basic " + basicAuth);

        int responseCode = connection.getResponseCode();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader connectionInput = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String jsonResponse = connectionInput.readLine();

        connectionInput.close();

        System.out.println(jsonResponse);



        return jsonResponse;
    }
}
