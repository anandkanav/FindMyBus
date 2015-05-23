package bus.happyhours.com.findmybus;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbatheja on 5/16/2015.
 */
public class SimpleHttpPut {

        public static String poster(){

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://4482660d.ngrok.io");
            try {
                String returnVal = "";
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
                nameValuePairs.add(new BasicNameValuePair("BusNumber",
                        "123456789"));
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse response = client.execute(post);
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    returnVal += line;
                }
                return returnVal;

            } catch (IOException e) {

                e.printStackTrace();
                return ".";
            }
        }

}