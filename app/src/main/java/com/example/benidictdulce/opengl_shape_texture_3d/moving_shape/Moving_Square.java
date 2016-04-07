package com.example.benidictdulce.opengl_shape_texture_3d.moving_shape;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Benidict Dulce on 4/7/2016.
 */
public class Moving_Square {
    private FloatBuffer verBuffer;
    private FloatBuffer colBuffer;


    private float[] vt={
            -1.0f, -1.0f, 0.0f,
            1.0f, -1.0f, 0.0f,
            -1.0f, 1.0f, 0.0f,
            1.0f, 1.0f, 0.0f
    };

    private float[] colors = {
            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f
    };

    public Moving_Square(){
        ByteBuffer bb = ByteBuffer.allocateDirect(vt.length * 4);
        bb.order(ByteOrder.nativeOrder());
        verBuffer = bb.asFloatBuffer();
        verBuffer.put(vt);
        verBuffer.position(0);

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

        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vt.length / 3);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
