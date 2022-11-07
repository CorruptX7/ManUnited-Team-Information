package com.example.assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// DataAdapter has to extend something

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private final RecyclerViewInterface recyclerViewInterface;

    private Context context;
    private int rowID;

    public Player [] players = null;
    private PlayersFromXML player;

    // Code > Generate > Constructor
    public DataAdapter(Context context, int rowID, PlayersFromXML player, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.rowID = rowID;
        this.player = player;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    // Focus on inner class
    // ViewHolder creates links for the layouts for the text and image

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name;
        public TextView number;


        // Code > Generate > Constructor

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageView);
            this.name = itemView.findViewById(R.id.textView);
            this.number = itemView.findViewById(R.id.textView2);

            // Reference the row aka itemView
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Calls the interface method
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate the layout and return the tree view
        View v = LayoutInflater.from(this.context).inflate(this.rowID, parent, false);

        return new ViewHolder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        players = player.getPlayerList();

        // Populate / bind the ViewHolder fields with data
        holder.name.setText(player.getNames()[position]);
        holder.number.setText(player.getNumbers()[position]);

        String imageName = player.getThumbnails()[position];
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageID = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

        holder.image.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return player.getPlayerList().length;
    }
}
