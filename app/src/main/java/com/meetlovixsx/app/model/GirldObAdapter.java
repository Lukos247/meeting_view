package com.meetlovixsx.app.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meetlovixsx.app.R;

import java.util.ArrayList;

public class GirldObAdapter extends RecyclerView.Adapter<GirldObAdapter.Holder> {

    private listener listener;
    private ArrayList<GirlOb> items;

    public GirldObAdapter(GirldObAdapter.listener listener, ArrayList<GirlOb> items) {
        this.listener = listener;
        this.items = items;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.object_girl, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
       holder.img.setImageResource(items.get(position).getImg());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView img;

        public Holder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(v -> listener.onClick(items.get(getAdapterPosition())));
        }
    }



    public interface listener {
        void onClick(GirlOb woman);
    }
}
