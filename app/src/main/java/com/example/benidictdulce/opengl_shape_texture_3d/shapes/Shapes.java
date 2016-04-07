package com.example.benidictdulce.opengl_shape_texture_3d.shapes;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

/**
 * Created by Benidict Dulce on 4/6/2016.
 */
public class Shapes extends Activity{

    private GLSurfaceView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        glView = new GLSurfaceView(this);
        glView.setRenderer(new ShapeRenderer(this));
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
