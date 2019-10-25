package com.juaracoding.todolist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<ToDoModel> dataItemList;

    public ExampleAdapter(ArrayList<ToDoModel> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_example_list, parent, false);
        Penampung penampung = new Penampung(view);
        return penampung;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        TextView txtTitle = ((Penampung)holder).txtTitle;
        TextView txtTanggal = ((Penampung)holder).txtTanggal;
        txtTitle.setText(dataItemList.get(position).getTitle());
        txtTanggal.setText(dataItemList.get(position).getTanggal().toString());
        ImageView imageView =  ((Penampung)holder).imageView;
    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }


    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtTitle;
        public TextView txtTanggal;
        public ImageView imageView;
        public Penampung(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitle = (TextView) itemView.findViewById(R.id.txtNama);
            txtTanggal = (TextView) itemView.findViewById(R.id.txtTanggal);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtTitle.getText());
        }
    }

    static class Penampung2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtTitle;
        public TextView txtTanggal;
        public Penampung2(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtTanggal = (TextView) itemView.findViewById(R.id.txtTanggal);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtTitle.getText());
        }
    }
}
