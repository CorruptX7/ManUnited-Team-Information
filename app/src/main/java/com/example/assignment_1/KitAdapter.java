package com.example.assignment_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KitAdapter extends RecyclerView.Adapter<KitAdapter.ViewHolder>{

    private Context context;
    private int rowID;

    public Player [] players = null;
    private PlayersFromXML player;

    // Code > Generate > Constructor
    public KitAdapter(Context context, int rowID, PlayersFromXML player) {
        this.context = context;
        this.rowID = rowID;
        this.player = player;
    }

    // Focus on inner class
    // ViewHolder creates links for the layouts for the text and image

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name, number, price;
        public Button buy;


        // Code > Generate > Constructor

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageRV);
            this.name = itemView.findViewById(R.id.textRV2);
            this.number = itemView.findViewById(R.id.textRV4);
            this.price = itemView.findViewById(R.id.textRV5);
            this.buy = itemView.findViewById(R.id.textRV6);
        }
    }

    @NonNull
    @Override
    public KitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate the layout and return the tree view
        View v = LayoutInflater.from(this.context).inflate(this.rowID, parent, false);

        return new KitAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KitAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        players = player.getPlayerList();

        // Populate / bind the ViewHolder fields with data
        String imageName = player.getKits()[position];
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageID = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        holder.image.setImageResource(imageID);

        holder.name.setText(player.getNames()[position]);
        holder.number.setText(player.getNumbers()[position]);
        holder.price.setText(player.getKitPrices()[position]);

        holder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BuyKitActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", players[position]);
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return player.getPlayerList().length;
    }
}
