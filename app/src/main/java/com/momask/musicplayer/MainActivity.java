package com.momask.musicplayer;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ImageView mIvPlay;
    private ImageView mIvLastSong;
    private ImageView mIvNextSong;
    private boolean isPlay;
    private List<MusicBean> musicBeanList = new ArrayList<>();
    public static final int CODE_FOR_WRITE_PERMISSION = 10001;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = findViewById(R.id.rv_content);
        mIvPlay = findViewById(R.id.iv_play);
        mIvLastSong = findViewById(R.id.iv_last_song);
        mIvNextSong = findViewById(R.id.iv_next_song);

        initEven();

        //检查一下是否有权限
        int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    CODE_FOR_WRITE_PERMISSION);
        } else {
            getSongList(this);
        }


    }

    private void initEven() {
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

        mIvLastSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mIvNextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //6.0请求权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CODE_FOR_WRITE_PERMISSION) {
            if (permissions[0].equals(Manifest.permission.READ_EXTERNAL_STORAGE)
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getSongList(this);
            } else {
                Toast.makeText(this, "请开启手机读写权限，再尝试使用", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void getSongList(Context context) {
        musicBeanList.clear();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = context.getContentResolver().query(uri,
                new String[]{
                        MediaStore.Audio.Media.TITLE,
                        MediaStore.Audio.Media.ARTIST,
                        MediaStore.Audio.Media.DATA}, null, null, null);
        assert cursor != null;
        while (cursor.moveToNext()) {
            musicBeanList.add(new MusicBean(
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)),
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)),
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))));
        }
    }
}
