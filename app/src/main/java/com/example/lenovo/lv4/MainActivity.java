package com.example.lenovo.lv4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
public String cityName;
    List<Forecast> forecasts=new ArrayList<Forecast>();
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getCity = findViewById(R.id.getCityName);
        EditText editText = findViewById(R.id.getCity);
        cityName = editText.getText().toString();
        initdata();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerAdapter = new RecyclerAdapter(forecasts, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(manager);

    }

    private void initdata()
    {
        HttpConnect httpConnect=new HttpConnect("https://www.apiopen.top/weatherApi?city="+cityName);
        httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                  parseByJSON(respone);

            }
        });
    }


    private void parseByJSON(String respone) {
        try {
            JSONObject jsonObject=new JSONObject(respone);
            Weather weather=new Weather();
            JSONObject obj1 = jsonObject.getJSONObject("data");
            Data data=new Data();
            data.city=obj1.getString("city");
            data.aqi=obj1.getString("api");
            JSONObject obj2 = jsonObject.getJSONObject("yesterday");
           Yesterday yesterday=new Yesterday();
yesterday.date=obj2.getString("date");
yesterday.fl=obj2.getString("fengli");
yesterday.fx=obj2.getString("fengxiang");
yesterday.high=obj2.getString("high");
yesterday.low=obj2.getString("low");
yesterday.type=obj2.getString("type");
            List<Forecast> forecasts=new ArrayList<>();
            JSONArray jsonArray = obj1.getJSONArray("forecast");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj3 = jsonArray.getJSONObject(i);
                Forecast forecast=new Forecast(null,null,null,null,null,null);
forecast.date=obj3.getString("date");
forecast.fengli=obj3.getString("fengli");
forecast.fengxiang=obj3.getString("fengxiang");
forecast.high=obj3.getString("high");
forecast.low=obj3.getString("low");
forecast.type=obj3.getString("type");
Forecast forecast1=new Forecast(forecast.date,forecast.fengli,forecast.fengxiang,forecast.high,forecast.low,forecast.type);
       forecasts.add(forecast1);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recyclerAdapter.notifyDataSetChanged();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
