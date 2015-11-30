package com.itson.restaurantcliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.snapshot.IndexedNode;

import java.util.ArrayList;
import java.util.List;

import Negocio.Platillos;
import Persistencia.PlatillosAdapter;

public class Menu extends AppCompatActivity {
    private ArrayList<Platillos> platillos;
    private ListView listaMenu;
    private PlatillosAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //le damos el contexto a la base de datos
        Firebase.setAndroidContext(this);
        //Definios objeto de tipo Firebase
        Firebase ref = new Firebase("https://sunpalace.firebaseio.com/platillos");
        listaMenu = (ListView) findViewById(R.id.listViewMenu);




         //se leen los datos y se guardan en una lista
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //instanciar el array List
                platillos = new ArrayList<Platillos>();
                //Recorrer la base de datos
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Platillos post = postSnapshot.getValue(Platillos.class);

                    platillos.add(new Platillos(post.getNombre().toString(),
                            post.getIngredientes().toString(),
                            post.getPrecio().toString()));
                }

                adaptador = new PlatillosAdapter(getApplicationContext(), platillos);
                listaMenu.setAdapter(adaptador);
                //mostrar siempre el ultimo elemento del listview
                listaMenu.setSelection(listaMenu.getAdapter().getCount() - 1);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("Error: " + firebaseError.getMessage());
            }
        });






    }
}
