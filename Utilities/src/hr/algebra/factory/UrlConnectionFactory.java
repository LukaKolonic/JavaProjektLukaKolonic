/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.factory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author dnlbe
 */
public class UrlConnectionFactory {
    
    
    private static final String MOZILLA50 = "Mozilla/5.0";
    private static final String USER_AGENT = "User-Agent";
    private static final int TIMEOUT = 10000;
    private static final String REQUEST_METHOD="GET";

    private UrlConnectionFactory() {
        
    }
   
    
    
    public static HttpURLConnection getHttpUrlConnection(String path) throws MalformedURLException, IOException {
        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setReadTimeout(TIMEOUT);
        con.setConnectTimeout(TIMEOUT);
        con.setRequestMethod(REQUEST_METHOD);
        con.addRequestProperty(USER_AGENT, MOZILLA50);
        return con;
    }
    
}
