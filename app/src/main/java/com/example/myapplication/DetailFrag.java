package com.example.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */



public class DetailFrag extends Fragment {
    private Button btSave;
    private ButtonListener buttonListener;

    public DetailFrag() {
        // Required empty public constructor
    }

    public interface ButtonListener{
        void onInputASent(boolean press);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.detail_frag, container, false);
        btSave = v.findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            buttonListener.onInputASent(true);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            buttonListener = (ButtonListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement the interface called buttonListener");
        }
    }


}
