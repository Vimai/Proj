package com.dot.freaks.picplanner;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;


public class Pastas extends Activity{

    private static final String LOG_TAG = "PicPlanner";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        int[] lista= new int[]{R.drawable.folder01,R.drawable.folder01,R.drawable.folder01,R.drawable.folder01};
        GridView PastasGrid = (GridView)findViewById(R.id.GridPastas);

        PastasGrid.setAdapter(new Adaptador(this, lista));


        PastasGrid.setOnItemClickListener(new GridView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView parent, View view, int i, long l) {
                Toast.makeText(getBaseContext(),"Pasta"+i+1,Toast.LENGTH_SHORT).show();
            }

        });


        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Organizador");
        try{
            if(dir.mkdir()) {
                Log.i(LOG_TAG,"Directory created");
            } else {
                Log.i(LOG_TAG,"Directory not created");
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pastas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent i = new Intent("com.dot.freaks.picplanner.DentroPasta");
        Bundle params = new Bundle();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.ImBttnCreatePasta){
            showDialog();
            return true;
        }
        if(id == R.id.teste){
            //DentroPasta teste = new DentroPasta(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Organizador/jk");
            //teste.startActivity(getParentActivityIntent());
            //acho q ta errado essas 2 linhas ai em cima
            params.putString("caminho",Environment.getExternalStorageDirectory().getAbsolutePath().toString()+"/Organizador/jk");
            i.putExtras(params);

            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }

    void showDialog() {
        DialogFragment newFragment = NomeadorPasta.newInstance();
        newFragment.show(getFragmentManager(), "dialog");
    }
}
