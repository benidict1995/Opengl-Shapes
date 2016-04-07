package com.example.benidictdulce.opengl_shape_texture_3d.moving_shape;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Benidict Dulce on 4/7/2016.
 */
public class Moving_Shape_Renderer implements GLSurfaceView.Renderer{

    int x = 0, y = 0;

    Moving_Triangle moving_triangle;
   private float  angle_triangle = 0.0f;
    private float speed_triangle = 1.1f;

    Moving_Square moving_square;
    private float angle_square = 0.0f;
    private float speed_square = 1.1f;

    public Moving_Shape_Renderer(Context context){
        moving_triangle = new Moving_Triangle();
        moving_square = new Moving_Square();
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
        GLU.gluPerspective(gl, 100, aspect, 0.1f, 100.f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        if (x==0) {
            gl.glTranslatef(3.0f, 2.0f, -11.0f);
            gl.glRotatef(angle_triangle, 0.0f, 1.0f, 0.3f);
            x +=1;
            if (x==1){
                gl.glTranslatef(0.3f, 1.0f, -7.0f);
                gl.glRotatef(angle_triangle, 1.0f, 1.0f, 0.3f);
                x = 0;
            }
        }moving_triangle.draw(gl);
        angle_triangle += speed_triangle;


        gl.glLoadIdentity();
        if(x==0) {
            gl.glTranslatef(0.0f, -8.0f, -10.0f);
            gl.glRotatef(angle_square, 1.0f, 0.0f, -10.f);
            x +=1;
            if (x == 1){
                gl.glTranslatef(0.0f, 13.0f, -10.0f);
                gl.glRotatef(angle_square, 1.0f, 0.0f, -10.0f);
                x = 0;
            }
        }
        moving_square.draw(gl);
        angle_square += speed_square;


        gl.glLoadIdentity();
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, -10.0f);
        gl.glRotatef(angle_square, 0.1f, 1.0f, 0.3f);
        moving_square.draw(gl);
        angle_square += speed_square;
        gl.glPopMatrix();

        gl.glLoadIdentity();
        if (x == 0) {
            gl.glTranslatef(2.0f, -5.0f, -10.0f);
            gl.glRotatef(angle_triangle, 3.1f, 1.0f, 0.5f);
                x +=1;
            if (x == 1){
                gl.glTranslatef(3.0f, -6.0f, -8.0f);
                gl.glRotatef(angle_square , 3.1f, 1.0f, 0.3f);
                x = 0;
            }
        }

        moving_triangle.draw(gl);
        angle_triangle += speed_triangle;

        gl.glLoadIdentity();
        if (x == 0) {
            gl.glTranslatef(0.0f, 1.0f, -6.0f);
            gl.glRotatef(angle_square, 0.0f, 1.0f, 0.1f);
            x +=1;
            if (x == 1){
                gl.glTranslatef(1.1f,0.1f,-8.0f);
                gl.glRotatef(angle_square, 1.1f, 1.0f, 1.1f);
                x = 0;
            }
        }
        moving_square.draw(gl);
        angle_square += speed_square;
    }


}
