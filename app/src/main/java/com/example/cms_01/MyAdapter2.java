package com.example.cms_01;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyviewHolder> {
    String [] Heading={
            "Student 1",
            "Student 2",
            "Student 3",
            "Student 4",
            "Student 5",
            "Student 6",
            "Student 7",
            "Student 8",
            "Student 9",
            "Student 10",



    };
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_studentlist,parent,false);
        return new MyviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.tv2.setText(Heading[position]);

    }
    @Override
    public int getItemCount() {

        return Heading.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView tv2;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tv2=itemView.findViewById(R.id.tv2);

        }
    }

}
