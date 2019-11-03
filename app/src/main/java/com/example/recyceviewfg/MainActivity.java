package com.example.recyceviewfg;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;

    private MainAdapter adapter;
    Type listType = new TypeToken<List<Team>>(){}.getType();

    private final String jsonData = "[\n" +
            "    {\n" +
            "        \"team_key\": \"2611\",\n" +
            "        \"team_name\": \"Leicester\",\n" +
            "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2611_leicester.png\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"team_key\": \"2612\",\n" +
            "        \"team_name\": \"Everton\",\n" +
            "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2612_everton.png\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"team_key\": \"2613\",\n" +
            "        \"team_name\": \"Brighton\",\n" +
            "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2613_brighton.png\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"team_key\": \"2614\",\n" +
            "        \"team_name\": \"Southampton\",\n" +
            "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2614_southampton.png\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"team_key\": \"2615\",\n" +
            "        \"team_name\": \"Bournemouth\",\n" +
            "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2615_bournemouth.png\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"team_key\": \"2616\",\n" +
            "        \"team_name\": \"Chelsea\",\n" +
            "        \"team_badge\": \"https://apiv2.apifootball.com/badges/2616_chelsea.png\"\n" +
            "    }\n" +
            "]";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rv_club);

        Gson gson = new Gson();
        List<Team> data = gson.fromJson((jsonData), listType);
        adapter = new MainAdapter(data);

        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
    }




}
