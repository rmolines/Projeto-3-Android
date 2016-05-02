package br.edu.insper.sprint2_projeto3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MorseActivity extends AppCompatActivity {


    private String[] arvorebinaria = {null,"E","I","S","H","5","4","V","3","U",
            "F", null,"2","A","R","L","W","P","J","1","T","N","D","B","6",
            "X","K","C","Y","M","G","Z","7","Q","O",null,"8",null,
            "9","0"};

    String letra = "";
    String numero = "";
    String text = "";
    String mensagem = "";
    boolean celular = false;
    TreeFactory factory = new TreeFactory();
    ArrayList<String> morsecode = factory.getMorse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse);

        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
        }

        Button buttonmorse_enviar  = (Button) findViewById(R.id.buttonmorse);
        final EditText texto = (EditText) findViewById(R.id.textView);
        assert buttonmorse_enviar != null;

        final CountDownTimer remainingTimeCounter = new CountDownTimer(1500,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                try {
                    if (letra.equals("----")) {
                        text = text.substring(0, text.length()-1);
                    }
                    else if (letra.equals("..--")) {
                        text += " ";
                    }
                    else {
                        text += arvorebinaria[morsecode.indexOf(letra)];
                    }
                    if (!celular) {
                        if (letra.equals("---.")) {
                            mensagem = text;
                            text = "";
                            texto.setText("Digite o número de celular");
                            celular = true;
                        } else if (letra != null) {
                            texto.setText(text);
                            texto.setSelection(text.length());
                            letra = "";
                        }
                    }
                    else {
                        if (letra.equals("---.")) {
                            System.out.println("Entrou1");
                            //checar aqui
                            SmsManager manager = SmsManager.getDefault();
                            String phone = numero;
                            System.out.println(phone);
                            if (PhoneNumberUtils.isWellFormedSmsAddress(phone)) {
                                System.out.println("Entrou11");
                                manager.sendTextMessage(phone, null, mensagem, null, null);
                                Toast.makeText(MorseActivity.this, "Torpedo enviado!", Toast.LENGTH_SHORT).show();
                            } else {
                                System.out.println("Entrou12");
                                Toast.makeText(MorseActivity.this, "Número inválido!", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
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
                letra += ".";
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
