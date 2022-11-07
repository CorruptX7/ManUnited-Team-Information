package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;

    public PlayersFromXML player = null;
    private Player [] players = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recycleView settings
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        player = new PlayersFromXML(this);
        players = player.getPlayerList();

        adapter = new DataAdapter(this, R.layout.players_list, player, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", players[position]);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}