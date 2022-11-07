package com.example.assignment_1;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private ImageView image;
    private TextView name, age, position, goals, number, country, appearance, joined, quote, playerQuote, moreInfo;
    private Button moreInfoButton, kitButton;

    private Player data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        image = findViewById(R.id.imageView2);
        name = findViewById(R.id.textView9);

        age = findViewById(R.id.textView6);
        position = findViewById(R.id.textView7);
        goals = findViewById(R.id.textView8);

        moreInfo = findViewById(R.id.textView10);
        moreInfo.setPaintFlags(moreInfo.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        playerQuote = findViewById(R.id.quote);
        playerQuote.setPaintFlags(moreInfo.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        number = findViewById(R.id.playerNumberText);
        country = findViewById(R.id.countryText);
        appearance = findViewById(R.id.appearancesText);
        joined = findViewById(R.id.joinedText);
        quote = findViewById(R.id.quoteText);

        moreInfoButton = findViewById(R.id.button);
        kitButton = findViewById(R.id.button2);


        // Get the data
        Intent intent = getIntent();

        // (Person) from private Person data = null;
        data = (Player) intent.getExtras().getSerializable("data");

        // Populate widget with data
        String imageName = data.getImage();
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageID = this.getResources().getIdentifier(imageName, "drawable", getPackageName());
        image.setImageResource(imageID);

        name.setText(data.getFullname());

        age.setText(data.getAge());
        position.setText(data.getPosition());
        goals.setText(data.getGoals());

        number.setText(data.getNumber());
        country.setText(data.getCountry());
        appearance.setText(data.getAppearances());
        joined.setText(data.getJoined());
        quote.setText(data.getQuote());

        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DetailsActivity.this, WebInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        kitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DetailsActivity.this, MoreDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
