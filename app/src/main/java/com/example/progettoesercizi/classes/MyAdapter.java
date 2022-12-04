package com.example.progettoesercizi.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.progettoesercizi.R;
import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Auto> {

    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Auto> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_of_samplelistview, null);
            viewHolder = new ViewHolder(
                    convertView.findViewById(R.id.marcaAuto),
                    convertView.findViewById(R.id.modelloAuto)
            );
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Auto auto = getItem(position);
        viewHolder.getMarcaView().setText(auto.getMarca().toUpperCase());
        viewHolder.getModelloView().setText("- "+auto.getModello().toLowerCase());
        return convertView;
    }

    public class ViewHolder {

        private TextView marcaView;
        private TextView modelloView;

        public TextView getMarcaView() {
            return marcaView;
        }

        public TextView getModelloView() {
            return modelloView;
        }

        public ViewHolder(TextView marcaView, TextView modelloView) {
            this.marcaView = marcaView;
            this.modelloView = modelloView;
        }
    }

}
