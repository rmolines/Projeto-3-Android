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
                // Cria uma Intent para abrir uma StudentFormActivity.
                Intent intent = new Intent(MainMenuActivity.this, MorseActivity.class);

                // Inicia uma nova activity a partir da Intent criada.
                startActivity(intent);
            }
        });

    }
}
