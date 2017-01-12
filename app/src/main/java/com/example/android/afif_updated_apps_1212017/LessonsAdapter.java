package com.example.android.afif_updated_apps_1212017;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by android on 12/01/2017.
 */

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.MyViewHolder> {

    private List<Lessons> lessonsList;
    private Context c ;



    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, date;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Toast.makeText(view.getContext(),"is Cliked!",Toast.LENGTH_LONG).show();

                    Intent i =new Intent(view.getContext(), fragmentActivity.class);
                    view.getContext().startActivity(i);

                }
            });

        }
    }
    public  LessonsAdapter(List<Lessons> lessonsList,Context c){
        this.lessonsList =lessonsList;
        this.c=c;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Lessons lessons = lessonsList.get(position);
        holder.title.setText(lessons.getTitle());
        holder.date.setText(lessons.getDate());


    }




    @Override
    public int getItemCount() {
        return lessonsList.size();
    }
}

