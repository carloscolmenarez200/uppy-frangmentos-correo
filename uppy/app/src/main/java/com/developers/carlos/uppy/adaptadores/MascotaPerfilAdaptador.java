package com.developers.carlos.uppy.adaptadores;

import android.app.Activity;
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
 * Created by carlos on 13/10/16.
 */

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.ViewHolder> {


    private final List<Mascota> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView tv_me_gusta;
        public ImageView img_mascota;
        public ImageView ic_hueso;


        public ViewHolder(View v) {
            super(v);

            tv_me_gusta = (TextView) v.findViewById(R.id.tv_me_gusta);
            img_mascota = (ImageView) v.findViewById(R.id.img_mascota);
            ic_hueso = (ImageView) v.findViewById(R.id.ic_hueso);
        }
    }

    public MascotaPerfilAdaptador(List<Mascota> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mascota_perfil, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Mascota item = items.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getFoto())
                .centerCrop()
                .into(viewHolder.img_mascota);
        viewHolder.tv_me_gusta.setText(String.valueOf(item.getCantidadMeGusta()));

    }

}
