package com.momask.musicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicDataAdapter extends RecyclerView.Adapter<MusicDataAdapter.MVH> {


    @NonNull
    @Override
    public MVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent);
        MVH mvh = new MVH(inflate);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MVH holder, int position) {
        holder.tvPlay.setText("");

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MVH extends RecyclerView.ViewHolder {

        TextView tvPlay;

        MVH(@NonNull View itemView) {
            super(itemView);
            tvPlay = itemView.findViewById(R.id.tv_playName);
        }
    }
}
