package com.example.benidictdulce.opengl_shape_texture_3d.shapes_3D;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

import com.example.benidictdulce.opengl_shape_texture_3d.R;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Benidict Dulce on 4/7/2016.
 */
public class Shapes_Square_3D {

    private FloatBuffer verBuffer;
    private int num = 6;

    private float[][] colors = {
            {1.0f, 0.0f, 0.0f, 1.0f},  //red
            {0.0f, 1.0f, 0.0f, 1.0f},  //green
            {1.0f, 0.0f, 1.0f, 1.0f},  //violet
            {0.0f, 0.0f, 1.0f, 1.0f},  //blue
            {1.0f, 0.5f, 0.0f, 1.0f},  //orange
            {1.0f, 1.0f, 0.0f, 1.0f}  //yellow
    };

    private float[] ver = {
            // FRONT
            -1.0f, -1.0f,  1.0f,  // left-bottom-front
            1.0f, -1.0f,  1.0f,  //  right-bottom-front
            -1.0f,  1.0f,  1.0f,  // left-top-front
            1.0f,  1.0f,  1.0f,  // right-top-front
            // BACK
            1.0f, -1.0f, -1.0f,  // right-bottom-back
            -1.0f, -1.0f, -1.0f,  // left-bottom-back
            1.0f,  1.0f, -1.0f,  // right-top-back
            -1.0f,  1.0f, -1.0f,  // left-top-back
            // LEFT
            -1.0f, -1.0f, -1.0f,  // left-bottom-back
            -1.0f, -1.0f,  1.0f,  // left-bottom-front
            -1.0f,  1.0f, -1.0f,  // left-top-back
            -1.0f,  1.0f,  1.0f,  // left-top-front
            // RIGHT
            1.0f, -1.0f,  1.0f,  // right-bottom-front
            1.0f, -1.0f, -1.0f,  // right-bottom-back
            1.0f,  1.0f,  1.0f,  // right-top-front
            1.0f,  1.0f, -1.0f,  // right-top-back
            // TOP
            -1.0f,  1.0f,  1.0f,  //left-top-front
            1.0f,  1.0f,  1.0f,  // right-top-front
            -1.0f,  1.0f, -1.0f,  //left-top-back
            1.0f,  1.0f, -1.0f,  // right-top-back
            // BOTTOM
            -1.0f, -1.0f, -1.0f,   //left-bottom-back
            1.0f, -1.0f, -1.0f,   //right-bottom-back
            -1.0f, -1.0f,  1.0f,  //left-bottom-front
            1.0f, -1.0f,  1.0f   // right-bottom-front
    };

    public Shapes_Square_3D() {
        ByteBuffer bb = ByteBuffer.allocateDirect(ver.length * 4);
        bb.order(ByteOrder.nativeOrder());
        verBuffer = bb.asFloatBuffer();
        verBuffer.put(ver);
        verBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, verBuffer);

        for (int i = 0; i < num; i++) {
            gl.glColor4f(colors[i][0],
                    colors[i][1],
                    colors[i][2],
                    colors[i][3]);
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, i*4, 4);
        }
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }

}
