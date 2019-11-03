package com.example.recyceviewfg;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Team implements Parcelable {
    @SerializedName("team_badge")
    private String mTeamBadge;
    @SerializedName("team_key")
    private String mTeamKey;
    @SerializedName("team_name")
    private String mTeamName;

    private Integer playerNum;
    private Integer coachNum;

    protected Team(Parcel in){
        mTeamBadge = in.readString();
        mTeamKey = in.readString();
        mTeamName = in.readString();

        if (in.readByte() == 0 ){
            playerNum = null;
        }else {
            playerNum = in.readInt();

        }

        if (in.readByte() == 0){
            coachNum = null;
        } else {
            coachNum = in.readInt();
        }

    }


    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public Integer getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(Integer playerNum) {
        this.playerNum = playerNum;
    }

    public Integer getCoachNum() {
        return coachNum;
    }

    public void setCoachNum(Integer coachNum) {
        this.coachNum = coachNum;
    }

    public String getTeamBadge() {
        return mTeamBadge;
    }

    public void setTeamBadge(String teamBadge) {
        mTeamBadge = teamBadge;
    }

    public String getTeamKey() {
        return mTeamKey;
    }

    public void setTeamKey(String teamKey) {
        mTeamKey = teamKey;
    }

    public String getTeamName() {
        return mTeamName;
    }

    public void setTeamName(String teamName) {
        mTeamName = teamName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTeamBadge);
        dest.writeString(mTeamKey);
        dest.writeString(mTeamName);
        if (playerNum == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(playerNum);
        }
        if (coachNum == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(coachNum);
        }
    }


}


