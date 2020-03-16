package br.com.totustuus.androidtestes.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
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
    }

    private void configuraAdapter(List<Componente> componentes, RecyclerView listaComponentes) {

        adapter = new ListaComponentesAdapter(this, componentes);

        ((SimpleItemAnimator) listaComponentes.getItemAnimator()).setSupportsChangeAnimations(false);

        listaComponentes.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(Componente componente, int posicao) {
                Log.i("clicou", "onItemClick: " + componente.getNome());
                componente.setExpandido(componente.isExpandido() ? false : true);
                adapter.notifyItemChanged(posicao);
            }

            @Override
            public void onItemClick(String valor, int posicao) {

            }
        });

    }

    private List<Componente> configuraComponentesExemplo() {

        List<Componente> componentes = new ArrayList<Componente>();

        componentes.add(new Componente(1, "Braço", Arrays.asList("Ponto A", "Ponto B")));
        componentes.add(new Componente(2, "Perna", Arrays.asList("Ponto C") ));
        componentes.add(new Componente(3, "Assento", new ArrayList<String>()));
        componentes.add(new Componente(4, "Encosto", Arrays.asList("Ponto D", "Ponto E", "Ponto F")));

        return componentes;
    }
}
