package com.developer.harshi.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Harshi on 6/15/2017.
 */

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder> {
ArrayList<Student> studentArrayList;
    Context context;

    @Override
    public int getItemViewType(int position) {
        Student thisstudent = studentArrayList.get(position);
        if(thisstudent.getCourse().toString().length()<=8){
            return 0;
        }
        return 1;
    }

    public StudentRecyclerAdapter(ArrayList<Student> studentArrayList, Context context) {
        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType)//is called only when new views are created
    {int layouttype=0;
        if(viewType==0){
            layouttype = R.layout.student_layout;
        }
        else if (viewType==1)
        {
            layouttype = R.layout.student_layout2;
        }
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView =li.inflate(layouttype,parent,false);
        StudentViewHolder studentViewHolder = new StudentViewHolder(itemView);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position)//is called always whether view comes recycled or is created
    {
        Student thisstudent = studentArrayList.get(position);
        holder.tvName.setText(thisstudent.getName());
        holder.tvCourse.setText(thisstudent.getCourse());

    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvCourse;
        public StudentViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvCourse = (TextView) itemView.findViewById(R.id.tvCourse);
        }

    }

}
