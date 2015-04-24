package com.dot.freaks.picplanner;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.io.File;


public class Pastas extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        private static final String LOG_TAG = "PicPlanner";


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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastas);

        GridView gridFotos = (GridView)findViewById(R.id.GridFotos);
        gridFotos.setAdapter(new ImageAdapter(this));
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
