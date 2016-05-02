package br.edu.insper.sprint2_projeto3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HelperActivity extends AppCompatActivity {

    private String[] arvorebinaria = {"NADA","E","T","I","A","N","M","S","U","R",
            "W","D","K","G","O","H","V","F","NADA","L","P","J","B","X",
            "C","Y","Z","Q","NADA","NADA","5","4","3","2","1","6","7",
            "8","9","0"};

    TreeFactory factory = new TreeFactory();
    ArrayList<String> morsecode = factory.getMorse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        ListView lista = (ListView) findViewById(R.id.lista);


        ArrayList<String> letras = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, letras);
        lista.setAdapter(arrayAdapter);
    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        for (int i=1;i<40;i++){
        dados.add(arvorebinaria[i] + "      =     " + morsecode.get(i));
        }

        return dados;


    }
}
