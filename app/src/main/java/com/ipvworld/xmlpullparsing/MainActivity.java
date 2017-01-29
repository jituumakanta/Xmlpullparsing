package com.ipvworld.xmlpullparsing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {

    public String xml;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
      listView = (ListView) findViewById(R.id.listView1);
        getData9();

       /* List<Employee> employees = null;
        try {
            XmlPullParserHandler parser = new XmlPullParserHandler();
            //InputStream is=getAssets().open("employees.xml");
            InputStream is=getAssets().open("xml");
            employees = parser.parse(is);

            ArrayAdapter<Employee> adapter =new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1, employees);
            listView.setAdapter(adapter);

        } catch (IOException e) {e.printStackTrace();}*/
        
    }



    public void getData9() {
        String url = "http://www.espncricinfo.com/rss/content/story/feeds/6.xml";
        // String url = Config.url;
        // Log.d("nam", url);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        xml = response.toString();
                         Log.d("nam", xml);
                        xml(xml);
                       // Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
// Add the request to the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
        //return xml;

    }



    public void xml(String xml){
        List<Employee> employees = null;

            XmlPullParserHandler parser = new XmlPullParserHandler();
            //InputStream is=getAssets().open("employees.xml");
            Toast.makeText(getApplicationContext(), xml, Toast.LENGTH_LONG).show();
           // InputStream is=getAssets().open(xml);
            InputStream is = new ByteArrayInputStream(xml.getBytes());
            employees = parser.parse(is);

            ArrayAdapter<Employee> adapter =new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1, employees);
            listView.setAdapter(adapter);



    }


    
}
