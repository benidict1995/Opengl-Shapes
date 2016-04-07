package com.example.benidictdulce.opengl_shape_texture_3d.shapes_3D;


import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

/**
 * Created by Benidict Dulce on 4/7/2016.
 */
public class Shapes_3D extends Activity {

    GLSurfaceView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glView = new GLSurfaceView(this);
        glView.setRenderer(new Shapes_3DRenderer(this));
        this.setContentView(glView);

    }


    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
    }
}
