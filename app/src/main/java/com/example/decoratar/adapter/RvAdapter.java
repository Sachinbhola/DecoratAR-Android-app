package com.example.decoratar.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decoratar.R;
import com.example.decoratar.model.FurnitureData;

import java.util.List;

//tbd - binding

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.CustomViewHolder> {

    Context context;
    List<FurnitureData> furnitureList;

    public RvAdapter(Context context, List<FurnitureData> furnitureList){
        this.context = context;
        this.furnitureList = furnitureList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        final FurnitureData data = furnitureList.get(position);
        holder.imageView.setImageResource(furnitureList.get(position).getURL());
        holder.textView.setText(furnitureList.get(position).getName());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_intent(data.getLink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return furnitureList.size();
    }

    public static final class CustomViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivItem);
            textView = itemView.findViewById(R.id.tvItem);
        }


    }
        private void start_intent(String str) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        Uri intentUri =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file", "" +str)
                        .appendQueryParameter("mode", "ar_only")
                        .build();

        sceneViewerIntent.setData(intentUri);
        sceneViewerIntent.setPackage("com.google.ar.core");
        sceneViewerIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(sceneViewerIntent);
    }
}
