package com.example.midterm_lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    String data1[],data2[], ourTitle[];
    int images[];
    Context context;

    public RecyclerAdapter(Context context, String[] data1, String[] data2, int[] images, String title[]) {
        this.data1 = data1;
        this.data2 = data2;
        this.images = images;
        this.context = context;
        this.ourTitle  = title;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_design, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.name.setText(data1[position]);
        holder.bday.setText(data2[position]);
        holder.title.setText(ourTitle[position]);
        holder.personImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, bday, title;
        ImageView personImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            bday = itemView.findViewById(R.id.bday);
            personImg = itemView.findViewById(R.id.personImg);
            title = itemView.findViewById(R.id.title);
        }
    }
}
