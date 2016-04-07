package com.example.benidictdulce.opengl_shape_texture_3d.shapes_3D;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Benidict Dulce on 4/7/2016.
 */
public class Shapes_Triangle_3D {
    private FloatBuffer verBuffer;
    private ByteBuffer inBuffer;
    private FloatBuffer colBuffer;

    private float[] ver = {
            -1.0f, -1.0f, -1.0f,
            1.0f, -1.0f, -1.0f,
            1.0f, -1.0f,  1.0f,
            -1.0f, -1.0f,  1.0f,
            0.0f,  1.0f,  0.0f
    };

    private float[] colors = {
            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f
    };

    private byte[] ind = {
            2, 4, 3,
            1, 4, 2,
            0, 4, 1,
            4, 0, 3
    };



    public Shapes_Triangle_3D(){
        ByteBuffer vbb = ByteBuffer.allocateDirect(ver.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        verBuffer = vbb.asFloatBuffer();
        verBuffer.put(ver);
        verBuffer.position(0);


        inBuffer = ByteBuffer.allocateDirect(ind.length);
        inBuffer.put(ind);
        inBuffer.position(0);


        ByteBuffer cb = ByteBuffer.allocateDirect(colors.length * 4);
        cb.order(ByteOrder.nativeOrder());
        colBuffer = cb.asFloatBuffer();
        colBuffer.put(colors);
        colBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, verBuffer);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colBuffer);


        gl.glDrawElements(GL10.GL_TRIANGLES, ind.length, GL10.GL_UNSIGNED_BYTE, inBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
