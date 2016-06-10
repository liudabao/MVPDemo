package com.example.lenovo.util;

import android.util.Log;

import org.apache.http.params.HttpConnectionParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lenovo on 2016/6/8.
 */
public class HttpUtil {

    public static void post(String username, String password, final OnHttpListener listener){

        URL url= null;
        InputStream inputStream= null;
        HttpURLConnection connection= null;
        try {
            url = new URL("https://www.baidu.com");
            connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setDoInput(true);
            connection.setDoInput(true);
            Log.e("connect", "start");
            if(connection.getResponseCode()==200){
                Log.e("connect", "success");
                inputStream=connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder=new StringBuilder();
                String line;
                while ((line=reader.readLine())!=null){
                    builder.append(line);
                }
                listener.onFinish(builder.toString());
            }
            else {
                Log.e("connect", "failed");
                listener.onError();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            connection.disconnect();
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
