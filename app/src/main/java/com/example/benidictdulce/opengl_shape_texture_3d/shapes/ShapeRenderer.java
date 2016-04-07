package com.example.benidictdulce.opengl_shape_texture_3d.shapes;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Benidict Dulce on 4/6/2016.
 */
public class ShapeRenderer implements GLSurfaceView.Renderer{

    Square square;
    Triangle triangle;

    private float angle_square  = 0.0f;
    private float speed_square = -0.4f;
    private float angle_triangle = 0.0f;
    private float speed_triangle = -0.4f;

    public ShapeRenderer(Context context){
        square = new Square();
        triangle = new Triangle();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;
        float aspect = (float)width / height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 50, aspect, 0.1f, 100.f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f, 2.0f, -10.0f);
        gl.glRotatef(angle_square, 0.0f, 1.0f, 0.0f);
        square.draw(gl);
        angle_square += speed_square;

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, -2.0f, -10.0f);
        gl.glRotatef(angle_triangle, 0.0f, 1.0f, 0.0f);
        triangle.draw(gl);
        angle_triangle += speed_triangle;
    }


}
