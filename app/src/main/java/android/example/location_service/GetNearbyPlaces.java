package android.example.location_service;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class GetNearbyPlaces extends AsyncTask<Object,String,String> {
    String googlePlacesData ;
    GoogleMap googleMap;
    String url ;

    @Override
    protected String doInBackground(Object... objects) {
        googleMap = (GoogleMap) objects[0];
        url = (String) objects[1];

        DownloadURL downloadURL = new DownloadURL();
        try {
            googlePlacesData = downloadURL.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return googlePlacesData;
    }
   @Override
   protected void onPostExecute (String s){
        try{
            JSONObject parentObject =new JSONObject(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
   }


}
