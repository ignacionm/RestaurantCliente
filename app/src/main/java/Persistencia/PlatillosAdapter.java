package Persistencia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.itson.restaurantcliente.R;

import java.util.List;

/**
 * Created by Nacho on 11/29/2015.
 */
public class PlatillosAdapter<Platillos> extends ArrayAdapter<Platillos> {
    public PlatillosAdapter(Context context, List<Platillos> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView = convertView;

        if (null == convertView) {
            listItemView = inflater.inflate(R.layout.formato_menu,parent,false);
        }

        TextView nombre = (TextView)listItemView.findViewById(R.id.txtNombreMenu);
        TextView ingrediente = (TextView)listItemView.findViewById(R.id.txtIngredienteMenu);
        TextView precio = (TextView)listItemView.findViewById(R.id.txtPrecioMenu);

        Negocio.Platillos item = (Negocio.Platillos) getItem(position);
        nombre.setText(item.getNombre());
        ingrediente.setText(item.getIngredientes());
        precio.setText(item.getPrecio());

        return listItemView;
    }
}

