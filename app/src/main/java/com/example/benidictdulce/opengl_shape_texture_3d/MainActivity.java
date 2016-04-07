package com.example.benidictdulce.opengl_shape_texture_3d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.benidictdulce.opengl_shape_texture_3d.moving_shape.Moving_Shape;
import com.example.benidictdulce.opengl_shape_texture_3d.shapes.Shapes;
import com.example.benidictdulce.opengl_shape_texture_3d.shapes_3D.Shapes_3D;

public class MainActivity extends Activity {

    Button btn_shapes,  btn_shapes_3d, btn_moving;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_shapes = (Button) findViewById(R.id.btn_shapes);

        btn_shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shapes = new Intent(context, Shapes.class);
                startActivity(shapes);
            }
        });


        btn_shapes_3d = (Button) findViewById(R.id.btn_shapes_3d);
        btn_shapes_3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Dshapes = new Intent(context, Shapes_3D.class);
                startActivity(Dshapes);
            }
        });

        btn_moving = (Button) findViewById(R.id.btn_moving);
        btn_moving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mshape = new Intent(context, Moving_Shape.class);
                startActivity(mshape);
            }
        });
    }
}
