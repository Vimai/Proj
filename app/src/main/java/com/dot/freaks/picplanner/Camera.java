package com.dot.freaks.picplanner;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Vinicius on 06/05/2015.
 */
public class Camera extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        /*if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, camera2.newInstance())
                    .commit();
        }*/
    }



}
