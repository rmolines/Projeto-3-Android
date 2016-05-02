package br.edu.insper.sprint2_projeto3;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MorseActivity extends AppCompatActivity {


    private String[] arvorebinaria = {"","E","I","S","H","5","4","V","3","U",
            "F", "","2","A","R","L","W","P","J","1","T","N","D","B","6",
            "X","K","C","Y","M","G","Z","7","Q","O","","8","",
            "9","0"};

    String letra = "";
    String text = "";
    TreeFactory factory = new TreeFactory();
    ArrayList<String> morsecode = factory.getMorse();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse);

        Button buttonmorse_enviar  = (Button) findViewById(R.id.buttonmorse);
        final TextView texto = (TextView) findViewById(R.id.textView);
        assert buttonmorse_enviar != null;

        final CountDownTimer remainingTimeCounter = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                try {
                    text += arvorebinaria[morsecode.indexOf(letra)];
                    texto.setText(text);
                    letra = "";
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    Toast.makeText(MorseActivity.this, "Voce errou o código", Toast.LENGTH_LONG).show();
                    letra = "";
                }
            }
        }.start();


        buttonmorse_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letra += "o";
                remainingTimeCounter.cancel();
                remainingTimeCounter.start();
            }
        });

        buttonmorse_enviar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                letra += "-";
                remainingTimeCounter.cancel();
                remainingTimeCounter.start();
                return true;
            }
        });
    }


}
