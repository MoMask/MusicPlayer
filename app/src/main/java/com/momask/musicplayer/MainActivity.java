package com.momask.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ImageView mIvPlay;
    private ImageView mIvLastSong;
    private ImageView mIvNextSong;
    private boolean isPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = findViewById(R.id.rv_content);
        mIvPlay = findViewById(R.id.iv_play);
        mIvLastSong = findViewById(R.id.iv_last_song);
        mIvNextSong = findViewById(R.id.iv_next_song);

        mIvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlay = !isPlay;
                if (isPlay) {
                    //暂停
                    mIvPlay.setImageDrawable(getResources().getDrawable(R.mipmap.icon_test_1));
                } else {
                    //播放
                    mIvPlay.setImageDrawable(getResources().getDrawable(R.mipmap.icon_test_2));
                }
            }
        });
    }
}
