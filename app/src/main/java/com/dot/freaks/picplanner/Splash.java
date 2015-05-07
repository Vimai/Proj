package com.dot.freaks.picplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Vinicius on 07/05/2015.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);

        Thread timer = new Thread(){

          public void run(){
              try{
                  sleep(4000);

              }catch (InterruptedException e){
                e.printStackTrace();
              }finally {
                  Intent x = new Intent("com.dot.freaks.picplanner.Pastas");
                  startActivity(x);
                  finish();
              }
          }
        };
        timer.start();

    }
}
