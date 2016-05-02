package br.edu.insper.sprint2_projeto3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MensagensActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mensagens);

        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
        }

        final EditText phoneEdit = (EditText) findViewById(R.id.enterPhone);

        Button sms1 = (Button) findViewById(R.id.sms1);
        assert sms1 != null;

        sms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Entrou1");
                //checar aqui
                SmsManager manager = SmsManager.getDefault();
                String phone = phoneEdit.getText().toString();
                System.out.println(phone);
                if(PhoneNumberUtils.isWellFormedSmsAddress(phone)) {
                    System.out.println("Entrou11");
                    manager.sendTextMessage(phone, null, "Preciso de Ajuda!", null, null);
                    Toast.makeText(MensagensActivity.this, "Torpedo enviado!", Toast.LENGTH_SHORT).show();
                }
                else {
                    System.out.println("Entrou12");
                    Toast.makeText(MensagensActivity.this, "Número inválido!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button sms2 = (Button) findViewById(R.id.sms2);
        assert sms2 != null;

        sms2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SmsManager manager = SmsManager.getDefault();
                String phone = phoneEdit.getText().toString();
                if(PhoneNumberUtils.isWellFormedSmsAddress(phone)) {
                    manager.sendTextMessage(phone, null, "Estou com fome", null, null);
                    Toast.makeText(MensagensActivity.this, "Torpedo enviado!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MensagensActivity.this, "Número inválido!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button sms3 = (Button) findViewById(R.id.sms3);
        assert sms3 != null;

        sms3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SmsManager manager = SmsManager.getDefault();
                String phone = phoneEdit.getText().toString();
                if(PhoneNumberUtils.isWellFormedSmsAddress(phone)) {
                    manager.sendTextMessage(phone, null, "Preciso ir no banheiro", null, null);
                    Toast.makeText(MensagensActivity.this, "Torpedo enviado!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MensagensActivity.this, "Número inválido!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

