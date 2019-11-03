package com.example.recyceviewfg;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> implements View.OnClickListener {

    private List<Team> data = new ArrayList<>();

    public MainAdapter(List<Team> data) {this.data = data;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false));
    }



    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.bindDataToView(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivBadge;
        private TextView tvClubName;
        private TextView tvClubId;
        private TextView tvNumPlayer;
        private TextView tvNumCoach;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivBadge = itemView.findViewById(R.id.iv_badge);
            tvClubName = itemView.findViewById(R.id.tv_club_name);
            tvClubId = itemView.findViewById(R.id.tv_club_id);
            tvNumPlayer = itemView.findViewById(R.id.tv_num_player);
            tvNumCoach = itemView.findViewById(R.id.tv_num_coach);
        }

        public void bindDataToView(final Team team){
            team.setCoachNum(1);
            team.setPlayerNum(20);
            Glide.with(itemView.getContext()).load(team.getTeamBadge()).into(ivBadge);
            tvClubName.setText(team.getTeamName());
            tvClubId.setText(team.getTeamKey());
            tvNumPlayer.setText(String.valueOf(team.getPlayerNum()));
            tvNumCoach.setText(String.valueOf(team.getCoachNum()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    Intent extra_data = intent.putExtra("EXTRA_DATA", team);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
