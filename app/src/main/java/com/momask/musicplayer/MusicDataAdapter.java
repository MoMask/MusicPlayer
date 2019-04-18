package com.momask.musicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicDataAdapter extends RecyclerView.Adapter<MusicDataAdapter.MVH> {
    private List<MusicBean> mData = new ArrayList<>();

    public void setData(List<MusicBean>data){
        this.mData=data;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent,false);
        MVH mvh = new MVH(inflate);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MVH holder, int position) {
        String musicName = mData.get(position).getMusicName();
        holder.tvPlay.setText(musicName);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MVH extends RecyclerView.ViewHolder {

        TextView tvPlay;

        MVH(@NonNull View itemView) {
            super(itemView);
            tvPlay = itemView.findViewById(R.id.tv_playName);
        }
    }
}
