package br.com.totustuus.androidtestes.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.totustuus.androidtestes.R;
import br.com.totustuus.androidtestes.model.Componente;
import br.com.totustuus.androidtestes.ui.adapter.ListaComponentesAdapter;
import br.com.totustuus.androidtestes.ui.adapter.listener.OnItemClickListener;

public class CollapseRecyclerViewActivity extends AppCompatActivity {

    private ListaComponentesAdapter adapter;
    private TextView cequipamento;
    private TextView crelatorio;
    private TextView cdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse_recycler_view);

        setTitle("  ");
        preencherCampos();
        List<Componente> componentes = configuraComponentesExemplo();
        configuraRecyclerView(componentes);
    }

    private void preencherCampos() {
        cequipamento = findViewById(R.id.activity_pontos_inspecao_equipamento);
        crelatorio = findViewById(R.id.activity_pontos_inspecao_relatorio);
        cdata = findViewById(R.id.activity_pontos_inspecao_data);

        cequipamento.setText("EQUIPAMENTO 001");
        crelatorio.setText("101-555");
        cdata.setText("Segunda, 11/03/2020");
    }

    private void configuraRecyclerView(List<Componente> componentes) {
        RecyclerView listaComponentes = findViewById(R.id.activity_pontos_recyclerview);
        configuraAdapter(componentes, listaComponentes);
        configuraItemTouchHelper(listaComponentes);
    }

    private void configuraItemTouchHelper(RecyclerView listaComponentes) {
    }

    private void configuraAdapter(List<Componente> componentes, RecyclerView listaComponentes) {

        adapter = new ListaComponentesAdapter(this, componentes);
        listaComponentes.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(Componente componente, int posicao) {
                Log.i("clicou", "onItemClick: " + componente.getNome());
            }
        });

    }

    private List<Componente> configuraComponentesExemplo() {

        List<Componente> componentes = new ArrayList<Componente>();
        componentes.add(new Componente(1, "Braço"));
        componentes.add(new Componente(2, "Perna"));
        componentes.add(new Componente(3, "Assento"));
        componentes.add(new Componente(4, "Encosto"));

        return componentes;
    }
}
