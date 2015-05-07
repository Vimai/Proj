package com.dot.freaks.picplanner;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Tulio on 23/04/2015.
 */
public class CreateFolder {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateFolder that = (CreateFolder) o;

        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

    protected String nome;


    @Override
    public String toString() {
        return "CreateFolder{" +
                "nome=" + nome +
                '}';
    }
    private static final String LOG_TAG = "PicPlanner";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public void gerar(){
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Organizador/"+nome);
        try{
            if(dir.mkdir()) {
                Log.i(LOG_TAG, "Directory created");
            } else {
                Log.i(LOG_TAG,"Directory not created");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }




}