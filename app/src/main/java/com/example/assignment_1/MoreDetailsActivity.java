package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MoreDetailsActivity extends AppCompatActivity{

    private ImageView image;
    private TextView playerName, name, price, number;
    private Button btn;

    private Player data;

    private RecyclerView recyclerView = null;
    private KitAdapter adapter = null;

    public PlayersFromXML player = null;
    private Player [] players = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt_recyclerview);

        playerName = findViewById(R.id.textView15);

        image = findViewById(R.id.imageView3);

        name = findViewById(R.id.textView12);
        price = findViewById(R.id.textView7);
        number = findViewById(R.id.textView14);

        btn = findViewById(R.id.button2);

        // Get the data
        Intent intent = getIntent();

        // (Person) from private Person data = null;
        data = (Player) intent.getExtras().getSerializable("data");

        // Populate widget with data
        playerName.setText(data.getFullname());

        String imageName = data.getKit();
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageID = this.getResources().getIdentifier(imageName, "drawable", getPackageName());
        image.setImageResource(imageID);

        name.setText(data.getName());
        price.setText(data.getKitprice());
        number.setText(data.getNumber());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreDetailsActivity.this, BuyKitActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        // Recycler View Set Up Code

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        player = new PlayersFromXML(this);
        players = player.getPlayerList();

        adapter = new KitAdapter(this, R.layout.activity_more_details, player);
        recyclerView.setAdapter(adapter);
    }
}
