package com.dot.freaks.picplanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Tulio on 30/04/2015.
 */

public class DentroPasta extends Activity{
    private String path, arrPath;
    private Bitmap[] thumbnails;
    private Boolean[] thumbnailsselection;
    private ImageAdapter imageAdapter;
    ArrayList<String> f = new ArrayList<String>();
    File[] listFile;

    Bundle params;


    public DentroPasta(String caminho){


        this.path = caminho;
    }

    public DentroPasta(){

        Intent inte = getIntent();
        if (inte !=null){
            Bundle params = inte.getExtras();
            if (params !=null){
                this.path = params.getString("caminho");
            }
        }

    }

    private static final String LOG_TAG = "PicPlanner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastas);




        /*Pegar();
        GridView gridFotos = (GridView)findViewById(R.id.GridFotos);
        imageAdapter = new ImageAdapter();
        gridFotos.setAdapter(imageAdapter);
        gridFotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Intent i = new Intent(getApplicationContext(), AumentarImagem.class);
                i.putExtra("id", position);
                startActivity(i);
                setContentView(R.layout.activity_imagefull);

                // get intent data
                //Intent i = getIntent();

                ImageAdapter imageAdapter = new ImageAdapter();

                ImageView imageView = (ImageView) findViewById(R.id.FullScreenImage);
                imageView.setImageBitmap(thumbnails[position]);
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.camera, menu);
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
        if(id == R.id.ImBttnCamera){
            Toast.makeText(this, "CAMERA", Toast.LENGTH_SHORT).show();

            Intent intCamera = new Intent("com.dot.freaks.picplanner.Camera");
            startActivity(intCamera);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Pegar(){
        File file = new File(path);
        if(file.isDirectory())
        {
            listFile = file.listFiles();
        }
        for (int i = 0; i < listFile.length; i++)
        {
            f.add(listFile[i].getAbsolutePath());
        }
    }


    public class ImageAdapter extends BaseAdapter{
        private LayoutInflater mInflater;



        public ImageAdapter(){
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return f.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.itemfoto, null);
                holder.image = (ImageView) convertView.findViewById(R.id.thumbImage);
                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
            }

            Bitmap myBitmap = BitmapFactory.decodeFile(f.get(position));
            holder.image.setImageBitmap(myBitmap);

            return convertView;
        }
    }
    public class ViewHolder{
        ImageView image;
    }


}