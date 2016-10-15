package com.developers.carlos.uppy.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.adaptadores.MascotaAdaptador;
import com.developers.carlos.uppy.adaptadores.MascotaPerfilAdaptador;
import com.developers.carlos.uppy.modelos.MascotaData;
import com.mikhaellopez.circularimageview.CircularImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MiMascotaFragment extends Fragment {


    public MiMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mi_mascota, container, false);

        CircularImageView fotoMacota = (CircularImageView) v.findViewById(R.id.img_miMascota);
        TextView nombreMacota = (TextView) v.findViewById(R.id.tv_nombre_perfil);

        Glide.with(this.getContext())
                .load(MascotaData.MASCOTAS_DATA_PERFIL.get(0).getFoto())
                .centerCrop()
                .into(fotoMacota);
        nombreMacota.setText(MascotaData.MASCOTAS_DATA_PERFIL.get(0).getNombre());

        RecyclerView mi_recycler = (RecyclerView) v.findViewById(R.id.mi_recycler_perfil);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mi_recycler.setLayoutManager(gridLayoutManager);
        mi_recycler.setAdapter(new MascotaPerfilAdaptador(MascotaData.MASCOTAS_DATA_PERFIL));

        return v;
    }

}
