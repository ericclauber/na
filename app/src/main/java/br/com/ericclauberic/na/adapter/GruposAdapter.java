package br.com.ericclauberic.na.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.ericclauberic.na.R;
import br.com.ericclauberic.na.modelo.Grupos;

/**
 * Created by eric on 31/08/16.
 */
public class GruposAdapter extends BaseAdapter {

    private final Context context;
    private final List<Grupos> grupos;

    public GruposAdapter(Context context, List<Grupos> grupos) {
        this.context = context;
        this.grupos = grupos;
    }

    @Override
    public int getCount() {
        return grupos != null ? grupos.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return grupos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //; Infla a view
        View view1 = LayoutInflater.from(context).inflate(R.layout.grupos_adapter_lista, viewGroup, false);
        // Retorna as view da lista; que precisa atualizar
        TextView nomeGrupo = (TextView) view1.findViewById(R.id.layout_grupos_adapter_textview_nomegrupo);
        TextView enderecoGrupo = (TextView) view1.findViewById(R.id.layout_grupos_adapter_textview_endereco);
        TextView numeroGrupo = (TextView) view1.findViewById(R.id.layout_grupos_adapter_textview_numero);
        TextView bairroGrupo = (TextView) view1.findViewById(R.id.layout_grupos_adapter_textview_bairro);
        TextView cidadeGrupo = (TextView) view1.findViewById(R.id.layout_grupos_adapter_textview_cidade);
        TextView ufGrupo = (TextView) view1.findViewById(R.id.layout_grupos_adapter_textview_uf);
        TextView localGrupo = (TextView) view1.findViewById(R.id.layout_grupos_adapter_textview_local);
        // Atualiza os valores
        Grupos grupos = this.grupos.get(i);
        //idGrupo.setText(String.valueOf(grupos.getId()));
        nomeGrupo.setText(grupos.getNomeGrupo());
        enderecoGrupo.setText(grupos.getEndereco());
        numeroGrupo.setText(grupos.getNumero());
        bairroGrupo.setText(grupos.getBairro());
        cidadeGrupo.setText(grupos.getCidade());
        ufGrupo.setText(grupos.getUf());
        localGrupo.setText(grupos.getLocal());
        // Retorna a view dos grupos
        return view1;
    }
}
