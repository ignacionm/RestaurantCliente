package com.itson.restaurantcliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnMenu, btnPerfil, btnOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
    }

    public void onClickAbrirMenu(View view){
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }


    public void onClickAbrirPerfil(View view){
        Intent i = new Intent(this, Perfil.class);
        startActivity(i);
    }


    public void onClickAbrirOrden(View view){
        Intent i = new Intent(this, Orden.class);
        startActivity(i);
    }


}
