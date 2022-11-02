package com.biniyam.birthday_witch;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    private CardView one, two, tree, four, five;
    private LinearLayout github, telegram;
    private Button yes, no, again;
    private TextView ans, canU;


    int sceen, day = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initViews();


        Typeface mytype = Typeface.createFromAsset(getAssets(), "fonts/productsansregular.ttf");
        canU.setTypeface(mytype);
        ans.setTypeface(mytype);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                actions(1);
            }
        });


        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actions(0);
            }
        });

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                sceen = 0;
                day = 0;
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                canU.setVisibility(View.VISIBLE);
                one.animate().translationXBy(1000f).setDuration(2300);
                two.animate().translationXBy(1000f).setDuration(1500);
                tree.animate().translationXBy(1000f).setDuration(1000);
                four.animate().translationXBy(1000f).setDuration(650);
                five.animate().translationXBy(1000f).setDuration(400);
                again.setEnabled(false);
            }
        });
    }


    private void actions(int i) {
        if (sceen == 0) {
            if (i == 1)
                day += 1;
            one.animate().translationXBy(-1000f).setDuration(1000);
            sceen++;
        } else if (sceen == 1) {
            if (i == 1)
                day += 2;
            two.animate().translationXBy(-1000f).setDuration(1000);
            sceen++;
        } else if (sceen == 2) {
            if (i == 1)
                day += 4;
            tree.animate().translationXBy(-1000f).setDuration(1000);
            sceen++;
        } else if (sceen == 3) {
            if (i == 1)
                day += 8;
            four.animate().translationXBy(-1000f).setDuration(1000);
            sceen++;
        } else if (sceen == 4) {
            if (i == 1)
                day += 16;

            ans.setText(String.valueOf(day));
            ans.setVisibility(View.VISIBLE);
            five.animate().translationXBy(-1000f).setDuration(1000);
            yes.setVisibility(View.INVISIBLE);
            no.setVisibility(View.INVISIBLE);
            canU.setVisibility(View.INVISIBLE);
            again.setEnabled(true);


        }


    }
    void initViews(){
        //initializing views
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        tree = findViewById(R.id.tree);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        ans = findViewById(R.id.ans);
        again = findViewById(R.id.again);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        canU = findViewById(R.id.can_u);
        ans.setVisibility(View.INVISIBLE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.about:

                AlertDialog dialogue;
                LayoutInflater inflater = Game.this.getLayoutInflater();
                dialogue = new AlertDialog.Builder(Game.this)
                        .setView(inflater.inflate(R.layout.menu_item, null))


                        .show();
                github = dialogue.findViewById(R.id.github);
                telegram = dialogue.findViewById(R.id.telegram);
                github.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callExternalLinks("https://github.com/b1n1yam");
                   }
               });
                telegram.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callExternalLinks("https://t.me/b1n1yam");
                    }
                });



        }
        return super.onOptionsItemSelected(item);
    }
    private void callExternalLinks(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
