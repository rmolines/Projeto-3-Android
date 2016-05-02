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

/**
 * Created by Rafael on 5/2/2016.
 */
public class SMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        // Código básico para utilizar o novo modelo de permissões do Android.
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
        }

        final EditText phoneEdit = (EditText) findViewById(R.id.phoneEdit);

        Button sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código básico para utilizar envio de torpedos internamente.
                SmsManager manager = SmsManager.getDefault();
                String phone = phoneEdit.getText().toString();
                if (PhoneNumberUtils.isWellFormedSmsAddress(phone)) {
                    manager.sendTextMessage(phone, null, "Insper", null, null);
                    Toast.makeText(SMSActivity.this, "Torpedo enviado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SMSActivity.this, "Número inválido!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
