package com.example.clemente_rodriguez_eval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class PantallaPrincipal extends AppCompatActivity {
    ImageView fotoGuggen;
    ImageView fotoMuseo;
    ImageView fotoMercado;
    ImageView fotoSanma;
    TextView favGuggen;
    TextView favMuseo;
    TextView favMercado;
    TextView favSanma;
    TextView nomGuggen;
    TextView nomMuseo;
    TextView nomMercado;
    TextView nomSanma;
    String lugar;
    String fav1;
    String fav2;
    String fav3;
    String fav4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        // Aqui recojo si me manda devuelta si se ha aumentado favoritos y de que lugar se ha aumentado
        lugar = getIntent().getStringExtra("lugar");

        //Busco las imagenes
        fotoGuggen = findViewById(R.id.imgGuggen);
        fotoMuseo = findViewById(R.id.imgMuseo);
        fotoMercado = findViewById(R.id.imgMercado);
        fotoSanma = findViewById(R.id.imgSanma);

        //recojo los label de favoritos
        favGuggen = findViewById(R.id.lblFavGuggen);
        favMuseo = findViewById(R.id.lblFavMuseo);
        favMercado = findViewById(R.id.lblFavMercado);
        favSanma = findViewById(R.id.lblFavSanma);

        //recojo los nombres de los lugares
        nomGuggen = findViewById(R.id.lblGuggen);
        nomMuseo = findViewById(R.id.lblMuseo);
        nomMercado = findViewById(R.id.lblMercado);
        nomSanma = findViewById(R.id.lblSanma);

        //Si lugar tiene contenido con el nombre de los lugares se actualiza los favoritos
        if (lugar != null) {
            fav1 = getIntent().getStringExtra("fav_gug");
            fav2 = getIntent().getStringExtra("fav_museo");
            fav3 = getIntent().getStringExtra("fav_mercado");
            fav4 = getIntent().getStringExtra("fav_sanma");

            favGuggen.setText(fav1);
            favMuseo.setText(fav2);
            favMercado.setText(fav3);
            favSanma.setText(fav4);

        }
        //clickable de Guggenheim
        fotoGuggen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al pulsar en la imagen de Guggenheim manda la foto, su nombre y sus favoritos a la ventana LugarSeleccionado
                Intent mandar = new Intent(PantallaPrincipal.this, LugarSeleccionado.class);
                mandar.putExtra("clave_Imagen", R.drawable.gugenheim);
                mandar.putExtra("lugar", nomGuggen.getText().toString());
                mandar.putExtra("fav_gug", favGuggen.getText().toString());
                mandar.putExtra("fav_museo", favMuseo.getText().toString());
                mandar.putExtra("fav_mercado", favMercado.getText().toString());
                mandar.putExtra("fav_sanma", favSanma.getText().toString());
                startActivity(mandar);
            }
        });

        //clickable de Museo de vellas artes
        fotoMuseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al pulsar en la imagen de Museo manda la foto, su nombre y sus favoritos a la ventana LugarSeleccionado
                Intent mandar = new Intent(PantallaPrincipal.this, LugarSeleccionado.class);
                mandar.putExtra("clave_Imagen", R.drawable.museovellasartes);
                mandar.putExtra("lugar", nomMuseo.getText().toString());
                mandar.putExtra("fav_gug", favGuggen.getText().toString());
                mandar.putExtra("fav_museo", favMuseo.getText().toString());
                mandar.putExtra("fav_mercado", favMercado.getText().toString());
                mandar.putExtra("fav_sanma", favSanma.getText().toString());
                startActivity(mandar);
            }
        });

        //clickable de Mercado de la rivera
        fotoMuseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al pulsar en la imagen de Mercado manda la foto, su nombre y sus favoritos a la ventana LugarSeleccionado
                Intent mandar = new Intent(PantallaPrincipal.this, LugarSeleccionado.class);
                mandar.putExtra("clave_Imagen", R.drawable.mercadorivera);
                mandar.putExtra("lugar", nomMercado.getText().toString());
                mandar.putExtra("fav_gug", favGuggen.getText().toString());
                mandar.putExtra("fav_museo", favMuseo.getText().toString());
                mandar.putExtra("fav_mercado", favMercado.getText().toString());
                mandar.putExtra("fav_sanma", favSanma.getText().toString());
                startActivity(mandar);
            }
        });

        //clickable de San Mames
        fotoMuseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al pulsar en la imagen de San Mames manda la foto, su nombre y sus favoritos a la ventana LugarSeleccionado
                Intent mandar = new Intent(PantallaPrincipal.this, LugarSeleccionado.class);
                mandar.putExtra("clave_Imagen", R.drawable.sanmames);
                mandar.putExtra("lugar", nomSanma.getText().toString());
                mandar.putExtra("fav_gug", favGuggen.getText().toString());
                mandar.putExtra("fav_museo", favMuseo.getText().toString());
                mandar.putExtra("fav_mercado", favMercado.getText().toString());
                mandar.putExtra("fav_sanma", favSanma.getText().toString());
                startActivity(mandar);
            }
        });

    }
}