package com.momask.musicplayer;

import android.util.Log;

public class MusicBean {
    private String musicName;
    private String artist;
    private String data;
    private boolean autoPlay;

    public MusicBean(String musicName, String artist, String data) {
        this.musicName = musicName;
        this.artist = artist;
        this.data = data;
    }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    public boolean getAutoPlay() {
        return autoPlay;
    }

    public String getArtist() {
        return artist;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getData() {
        return data;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}
