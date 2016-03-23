package PCard.Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by rkelly on 3/23/16.
 */
public class UrlSource {

    public static String getUrlSource(String url) throws IOException {
        URL theURL = new URL(url);
        URLConnection urlC = theURL.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlC.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();
        return a.toString();
    }
}
