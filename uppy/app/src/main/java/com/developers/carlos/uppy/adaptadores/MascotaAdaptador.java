package com.developers.carlos.uppy.adaptadores;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

/**
 * Created by carlos on 29/09/16.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.ViewHolder> {


    private final List<Mascota> items;
    private final Activity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView tv_nombre_mascota;
        public TextView tv_me_gusta;
        public ImageView img_mascota;
        public ImageView ic_hueso;


        public ViewHolder(View v) {
            super(v);

            tv_nombre_mascota = (TextView) v.findViewById(R.id.tv_nombre_mascota);
            tv_me_gusta = (TextView) v.findViewById(R.id.tv_me_gusta);
            img_mascota = (ImageView) v.findViewById(R.id.img_mascota);
            ic_hueso = (ImageView) v.findViewById(R.id.ic_hueso);
        }
    }

    public MascotaAdaptador(List<Mascota> items, Activity activity) {
        this.items = items;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mascota, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final Mascota item = items.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getFoto())
                .centerCrop()
                .into(viewHolder.img_mascota);
        viewHolder.tv_nombre_mascota.setText(item.getNombre());
        viewHolder.tv_me_gusta.setText(String.valueOf(item.getCantidadMeGusta()));

        viewHolder.ic_hueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setCantidadMeGusta(item.getCantidadMeGusta()+1);
                viewHolder.tv_me_gusta.setText(String.valueOf(item.getCantidadMeGusta()));
                Toast.makeText(activity,"ha indicado me gusta a "+item.getNombre(),Toast.LENGTH_LONG).show();
            }
        });
    }

}
