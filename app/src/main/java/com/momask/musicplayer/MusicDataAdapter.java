package com.momask.musicplayer;

import android.content.Context;
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
    private Context context;
    private ClickCallBack clickCallBack;

    public interface ClickCallBack {
        void onClick(MusicBean musicBean, int position);
    }

    void setContext(Context context) {
        this.context = context;
    }

    void setData(List<MusicBean> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(ClickCallBack clickListener) {
        this.clickCallBack = clickListener;
    }

    @NonNull
    @Override
    public MVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        MVH mvh = new MVH(inflate);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MVH holder, final int position) {
        final String musicName = mData.get(position).getMusicName();
        holder.tvPlay.setTextColor(context.getResources().getColor(mData.get(position).getAutoPlay() ? R.color.colorAccent : R.color.colorPrimary));
        holder.tvPlay.setText(musicName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件回调出去
                if (clickCallBack!=null)
                clickCallBack.onClick(mData.get(position),position);
            }
        });

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
