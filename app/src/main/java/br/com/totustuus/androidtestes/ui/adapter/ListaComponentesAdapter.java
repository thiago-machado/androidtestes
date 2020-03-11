package br.com.totustuus.androidtestes.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.totustuus.androidtestes.R;
import br.com.totustuus.androidtestes.model.Componente;
import br.com.totustuus.androidtestes.ui.adapter.listener.OnItemClickListener;

public class ListaComponentesAdapter extends RecyclerView.Adapter<ListaComponentesAdapter.ComponenteViewHolder>{

    private final List<Componente> componentes;
    private final Context context;
    private OnItemClickListener onItemClickListener;

    public ListaComponentesAdapter(Context context, List<Componente> componentes) {
        this.context = context;
        this.componentes = componentes;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ComponenteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View viewCriada = LayoutInflater.from(context).inflate(R.layout.ponto_inspecao_item, parent, false);
        return new ComponenteViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ComponenteViewHolder holder, int position) {
        Componente componente = componentes.get(position);
        holder.vincula(componente);
    }

    @Override
    public int getItemCount() {
        return componentes.size();
    }

    class ComponenteViewHolder extends RecyclerView.ViewHolder {

        private final TextView ccomponente;
        private Componente componente;

        ComponenteViewHolder(@NonNull View itemView) {
            super(itemView);

            ccomponente = itemView.findViewById(R.id.ponto_inspecao_componente);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(componente, getAdapterPosition());
                }
            });
        }

        void vincula(Componente componente) {
            this.componente = componente;
            ccomponente.setText( this.componente.getNome());
        }

    }
}
