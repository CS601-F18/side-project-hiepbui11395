package hpbui.gamerportal.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Utils {
    private final static String USER_AGENT = "Mozilla/5.0";
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	public static String callGetApi(String url) {
		URL obj;
        StringBuffer response = new StringBuffer();
		try {
			obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	        //Request header
	        con.setRequestProperty("User-Agent", USER_AGENT);

	        int responseCode = con.getResponseCode();
//	        System.out.println("\nSending 'GET' request to URL : " + url);
//	        System.out.println("Response Code : " + responseCode);

	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.toString();
	}

	public static String convertFromIntToTime(int minutes){
		String startTime = "00:00";
		String time = "";
		int h = minutes / 60 + Integer.parseInt(startTime.substring(0,1));
		int m = minutes % 60 + Integer.parseInt(startTime.substring(3,4));
		if(m<10){
			time = h+":0"+m;
		} else{
			time = h+":"+m;
		}
		return time;
	}

    public static String convertTimeStamp(Timestamp timestamp) {
        return dateFormat.format(timestamp);
    }
}
