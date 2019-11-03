package com.example.recyceviewfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivDetail;
    private TextView tvTeamName, tvTeamKeys;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ivDetail = findViewById(R.id.ivDetail);
        tvTeamName = findViewById(R.id.tvJudul);
        tvTeamKeys = findViewById(R.id.tvDetail);


        Team datafromintent = getIntent().getParcelableExtra("EXTRA_DATA");
        tvTeamName.setText(datafromintent.getTeamName());
        tvTeamKeys.setText(datafromintent.getTeamKey());
        Glide.with(this).load(datafromintent.getTeamBadge()).into(ivDetail);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(datafromintent.getTeamKey());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);

    }


}
