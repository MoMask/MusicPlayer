package com.momask.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

public class MediaUtils {
    public interface CallBack {
        void onSucceed();

        void onError(String message);
    }

    public static int PLAY_STATE = 0;

    private MediaPlayer mediaPlayer;

    private MediaUtils() {
        init();
    }

    public static MediaUtils getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final MediaUtils sInstance = new MediaUtils();
    }

    private void init() {
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
    }

    public void playMusic(String path) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
            MediaUtils.PLAY_STATE = EvenConstanct.EVEN_PLAY;
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    //暂停
    public void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            MediaUtils.PLAY_STATE = EvenConstanct.EVEN_PAUSE;
        }
    }

    //继续播放
    public void continuePlay() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            MediaUtils.PLAY_STATE = EvenConstanct.EVEN_CONTINUE;
        }
    }

    //停止播放
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            MediaUtils.PLAY_STATE = EvenConstanct.EVEN_STOP;
        }
    }

    public void playMusic(String path, CallBack callBack) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
            MediaUtils.PLAY_STATE = EvenConstanct.EVEN_PLAY;
            if (callBack != null) {
                callBack.onSucceed();
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (callBack != null) {
                callBack.onError(e.getMessage());
            }

        }
    }

}
