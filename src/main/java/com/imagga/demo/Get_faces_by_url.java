package com.imagga.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootApplication
public class Get_faces_by_url {
	public static void main(String[] args) throws IOException {}

	public static String Face_url() throws IOException {
		String credentialsToEncode = "acc_63206b86f407506" + ":" + "d10663e15d3f13f665227095d10e76b8";
		String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));

		String endpoint_url = "https://api.imagga.com/v2/faces/detections";
		String image_url = "https://www.presse-citron.net/app/uploads/2018/06/https_2F2Fblueprint-api-production.s3.amazonaws.com2Fuploads2Fstory2Fthumbnail2F762412Fc08c7e58-14b2-49fb-9c81-82db752c459e-e1529417140216.png";

		String url = endpoint_url + "?image_url=" + image_url;
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
