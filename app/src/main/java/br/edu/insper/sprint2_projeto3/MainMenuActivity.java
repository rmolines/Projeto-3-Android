package br.edu.insper.sprint2_projeto3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rafael on 4/29/2016.
 */
public class MainMenuActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainmenu);

        Button buttonNew = (Button) findViewById(R.id.morse);
        assert buttonNew != null;
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainMenuActivity.this, MorseActivity.class);


                startActivity(intent);
            }
        });

        Button buttonNew2 = (Button) findViewById(R.id.helper);
        assert buttonNew2 != null;
        buttonNew2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, HelperActivity.class);


                startActivity(intent);
            }
        });


        Button buttonNew3 = (Button) findViewById(R.id.mensagens);
        assert buttonNew3 != null;
        buttonNew3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, MensagensActivity.class);


                startActivity(intent);
            }
        });
    }
}
