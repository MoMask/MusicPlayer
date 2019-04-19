package com.momask.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

public class PlayerService extends Service {
    private Messenger messenger;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int option = intent.getIntExtra("option", 0);
        if (messenger == null) {
            messenger = (Messenger) intent.getExtras().get("messenger");
        }
        if (EvenConstanct.EVEN_PLAY == option) {
            MediaUtils.getInstance().playMusic(intent.getStringExtra("path"));
        } else if (EvenConstanct.EVEN_PAUSE == option) {
            MediaUtils.getInstance().pause();
        } else if (EvenConstanct.EVEN_CONTINUE == option) {
            MediaUtils.getInstance().continuePlay();
        } else if (EvenConstanct.EVEN_STOP == option) {
            MediaUtils.getInstance().stop();
        } else if (EvenConstanct.EVEN_PROGRESS == option) {
            // seekPlay(intent.getIntExtra("progress",-1));
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
