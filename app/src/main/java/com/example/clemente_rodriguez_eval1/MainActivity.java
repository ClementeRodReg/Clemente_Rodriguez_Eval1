package com.example.clemente_rodriguez_eval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imgViewLogo);
        imageView.setImageResource(R.drawable.logo);

        //Boton al darle a la imagen nos envia a la siguiente vista
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // con intent declaramos que nos lleve de esta vista a la especificada a continuacion
                startActivity(new Intent(MainActivity.this, PantallaPrincipal.class));
            }
        });

    }
}
