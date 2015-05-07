package com.dot.freaks.picplanner;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

/**
 * Created by Tulio on 30/04/2015.
 */
public class NomeadorPasta extends DialogFragment implements View.OnClickListener{


    private Button bttnConfirma;
    private Button bttnCancela;
    private EditText BoxNomePasta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.box_pasta_nome, container, false);

        bttnConfirma = (Button)view.findViewById(R.id.bttnConfirmaPasta);
        bttnCancela = (Button)view.findViewById(R.id.bttnCancelarPasta);
        BoxNomePasta = (EditText)view.findViewById(R.id.edtTextPasta);
        bttnConfirma.setOnClickListener(this);
        bttnCancela.setOnClickListener(this);

        getDialog().setTitle("Nova Pasta");

        return view;
    }

    static NomeadorPasta newInstance() {
        NomeadorPasta f = new NomeadorPasta();
        // Supply num input as an argument.
        Bundle args = new Bundle();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bttnConfirmaPasta:
                CreateFolder Novo = new CreateFolder();
                Novo.setNome(BoxNomePasta.getText().toString());
                Novo.gerar();
                this.dismiss();
                break;
            case R.id.bttnCancelarPasta:
                try {
                    this.dismiss();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                break;
            case R.id.edtTextPasta:

        }
    }
}

