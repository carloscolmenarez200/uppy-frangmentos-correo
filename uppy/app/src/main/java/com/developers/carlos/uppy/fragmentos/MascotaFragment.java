package com.developers.carlos.uppy.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.adaptadores.MascotaAdaptador;
import com.developers.carlos.uppy.modelos.MascotaData;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment {


    public MascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);

        RecyclerView mi_recycler = (RecyclerView) v.findViewById(R.id.mi_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mi_recycler.setLayoutManager(linearLayoutManager);
        mi_recycler.setAdapter(new MascotaAdaptador(MascotaData.MASCOTAS_DATA,getActivity()));

        return v;
    }

}
