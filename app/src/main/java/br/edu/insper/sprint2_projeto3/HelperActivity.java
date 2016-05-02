package br.edu.insper.sprint2_projeto3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelperActivity extends AppCompatActivity {

    private String[] arvorebinaria = {null,"E","T","I","A","N","M","S","U","R",
            "W","D","K","G","O","H","V","F",null,"L","P","J","B","X",
            "C","Y","Z","Q",null,null,"5","4","3","2","1","6","7",
            "8","9","0"};

    private List<String> arvorebinaria2 = Arrays.asList(null,"E","I","S","H","5","4","V","3","U",
            "F", null,"2","A","R","L","W","P","J","1","T","N","D","B","6",
            "X","K","C","Y","M","G","Z","7","Q","O",null,"8",null,
            "9","0");

    TreeFactory factory = new TreeFactory();
    ArrayList<String> morsecode = factory.getMorse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        GridView lista = (GridView) findViewById(R.id.grid);


        ArrayList<String> letras = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, letras);
        lista.setAdapter(arrayAdapter);
    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        for (int i=1;i<40;i++){
            if (arvorebinaria[i] != null) {
                dados.add(arvorebinaria[i] + " = " + morsecode.get(arvorebinaria2.indexOf(arvorebinaria[i])));
            }
        }

        return dados;


    }
}
