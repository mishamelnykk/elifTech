package restTask;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpURLConnectionTest {
    private String inputLine;

    public String getInputLine() {
        return inputLine;
    }

    public void sendGet() throws Exception {

        String url = "https://www.eliftech.com/school-task";

        URL obj = new URL(url);
        HttpURLConnection con =  (HttpURLConnection)obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");


        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        inputLine = response.toString();
        System.out.println(inputLine);
    }

    public void sendPost(String id) throws Exception {
        String url = "https://www.eliftech.com/school-task";
        URL obj = new URL(url);
        HttpURLConnection con =  (HttpURLConnection)obj.openConnection();

        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);

        String urlParameters = id;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    }
}
