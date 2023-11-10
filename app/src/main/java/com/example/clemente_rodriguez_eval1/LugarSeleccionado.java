package com.example.clemente_rodriguez_eval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LugarSeleccionado extends AppCompatActivity {

    Button volver;
    Button volveryfav;
    ImageView imagenLugar;
    TextView labelLugar;
    TextView labelFavoritos;
    TextView labelDescripcion;
    String fav1;
    String fav2;
    String fav3;
    String fav4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar_seleccionado);

        //busco los componentes de la vista
        volver=findViewById(R.id.btnVolver);
        volveryfav=findViewById(R.id.btnVolverFav);
        imagenLugar= findViewById(R.id.imgLugar);
        labelLugar=findViewById(R.id.lblNomLugar);
        labelFavoritos=findViewById(R.id.lblFavLugar);
        labelDescripcion=findViewById(R.id.lblDesc);

        //sacamos del intent la imagen y la colocamos
        int imagenReferencia = getIntent().getIntExtra("clave_Imagen", 0);
        imagenLugar.setImageResource(imagenReferencia);

        //lo mismo con el nombre y el numero de favoritos
        String lugar = getIntent().getStringExtra("lugar");
        fav1 = getIntent().getStringExtra("fav_gug");
        fav2 = getIntent().getStringExtra("fav_museo");
        fav3 = getIntent().getStringExtra("fav_mercado");
        fav4 = getIntent().getStringExtra("fav_sanma");

        //los introduzco en los componentes
        labelLugar.setText(lugar);

        if(lugar.equals("Guggenheim")){
            labelFavoritos.setText(fav1);
            labelDescripcion.setText("La entrada general permite conocer la Colección del Museo Guggenheim Bilbao, así \ncomo visitar las exposiciones temporales vigentes, y recorrer el interior del edificio, \nconsiderado una obra emblemática de la arquitectura contemporánea.");
        } else if (lugar.equals("Museo Vellas Artes")) {
            labelFavoritos.setText(fav2);
            labelDescripcion.setText("El Museo de Bellas Artes de Bilbao ofrece un recorrido en el que pueden descubrirse los principales artistas, \nestilos y escuelas del arte occidental a través de obras representativas.");
        }
        else if (lugar.equals("Mercado de la Rivera")) {
            labelFavoritos.setText(fav3);
            labelDescripcion.setText("El Mercado de La Ribera ha conseguido mantener su esencia a lo largo de su larga historia, \nque suma ya varios siglos. Su principal valor es la tradicional calidad, variedad y frescura del género que ofrece. \nSi te gusta la cocina rebosante de sabor y tradición, aquí encontrarás todos los ingredientes de nuestro entorno rural y costero \nque conforman el recetario culinario tradicional vasco: verduras de las huertas vizcaínas, pescados recién llegados a puerto, \ncarnes criadas con mimo por nuestros ganaderos... ¡Calidad suprema!");
        }else{
            labelFavoritos.setText(fav4);
            labelDescripcion.setText("Recorre ‘La Catedral del fútbol’, el estadio galardonado con premios al mejor edificio deportivo del mundo. \nSiente las sensaciones que viven los futbolistas y aficionados en San Mamés, la casa de “los leones”.\n" +
                    "Disfruta de un recorrido inolvidable y experimenta el fútbol desde dentro.");
        }


        //vuelvo a La pantalla principal sin mandar favoritos
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vuelvo a Pantalla principal
                volver();
            }
        });

        //vuelvo a La pantalla principal con favoritos actualizado
        volveryfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVolveryfav();
            }
        });
    }

    public void volver(){
        //declaro el intent, quiero ir a la pantalla principal
        Intent mandar = new Intent(LugarSeleccionado.this, PantallaPrincipal.class);
        mandar.putExtra("lugar",labelLugar.getText().toString());
        mandar.putExtra("fav_gug", fav1);
        mandar.putExtra("fav_museo", fav2);
        mandar.putExtra("fav_mercado", fav3);
        mandar.putExtra("fav_sanma", fav4);

        //lo mando
        startActivity(mandar);
    }

    public void setVolveryfav(){
        //declaro el intent, quiero ir a la pantalla principal
        Intent mandar = new Intent(LugarSeleccionado.this, PantallaPrincipal.class);

        //introduzco en el intent el nombre del lugar
        mandar.putExtra("lugar",labelLugar.getText().toString());

        //le mando el numero de favoritos actualizado
        int suma = Integer.valueOf(labelFavoritos.getText().toString().split(":")[1].trim())+1;
        String favStr="Favoritos: "+suma;

        if( labelLugar.getText().equals("Guggenheim")){
            fav1 =favStr;
        } else if (labelLugar.getText().equals("Museo Vellas Artes")) {
            fav2 =favStr;
        }else if (labelLugar.getText().equals("Mercado de la Rivera")) {
            fav3 =favStr;
        }else{
            fav4 = favStr;
        }

        mandar.putExtra("fav_gug", fav1);
        mandar.putExtra("fav_museo", fav2);
        mandar.putExtra("fav_mercado", fav3);
        mandar.putExtra("fav_sanma", fav4);

        //lo mando
        startActivity(mandar);
    }
}