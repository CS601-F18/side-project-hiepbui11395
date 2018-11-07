package hpbui.gamerportal.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import hpbui.gamerportal.entity.Genre;
import hpbui.gamerportal.service.GenreService;

@Controller
public class GenreController {
	@Autowired
	GenreService genreService;

	private final String USER_AGENT = "Mozilla/5.0";

	@GetMapping(path="/admin/genre/get")
	public String getGenres() {
		int offset = 0;
		int total = Integer.MAX_VALUE;
		while(offset<total) {
			String urlString = "https://www.giantbomb.com/api/genres/"
					+ "?api_key=24a0f044a74d7d88224268e7cbc11c39007727fc&"
					+ "format=json&"
					+ "field_list=name&"
					+ "offset=" + offset;
			//create URL object

			URL obj;
			try {
				obj = new URL(urlString);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();

				//Request header
				con.setRequestProperty("User-Agent", USER_AGENT);

				int responseCode = con.getResponseCode();
				System.out.println("\nSending 'GET' request to URL : " + urlString);
				System.out.println("Response Code : " + responseCode);

				BufferedReader in = new BufferedReader(
						new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				JSONObject jsonObject = new JSONObject(response.toString());
				total = jsonObject.getInt("number_of_total_results");
				JSONArray jsonArray = jsonObject.getJSONArray("results");
				for(int i = 0;i<jsonArray.length();i++) {
					JSONObject genre = jsonArray.getJSONObject(i);
					Genre entity = new Genre();
					entity.setGenre(genre.getString("name"));
					entity.setActive(true);
					genreService.save(entity);
				}
				in.close();
				offset+=100;
				System.out.println(response.toString());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		return "admin/index";
	}
}
