package br.com.totustuus.androidtestes.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.totustuus.androidtestes.R;
import br.com.totustuus.androidtestes.ui.adapter.listener.OnItemClickListener;

public class ListaPontosAdapter extends RecyclerView.Adapter<ListaPontosAdapter.PontoViewHolder>{

    private final Context context;
    private final List<String> pontos;
    private OnItemClickListener onItemClickListener;

    public ListaPontosAdapter(Context context, List<String> pontos) {
        this.context = context;
        this.pontos = pontos;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PontoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View viewCriada = LayoutInflater.from(context).inflate(R.layout.ponto_inspecao_item, parent, false);
        return new ListaPontosAdapter.PontoViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull PontoViewHolder holder, int position) {
        String ponto = pontos.get(position);
        holder.vincula(ponto);
    }

    @Override
    public int getItemCount() {
        return pontos.size();
    }

    class PontoViewHolder extends RecyclerView.ViewHolder {

        private final TextView cponto;
        private String ponto;

        PontoViewHolder(@NonNull View itemView) {

            super(itemView);

            cponto = itemView.findViewById(R.id.ponto_inspecao);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(ponto, getAdapterPosition());
                }
            });
        }

        void vincula(String ponto) {
            this.ponto = ponto;
            cponto.setText(ponto);
        }
    }
}
