package com.developer.harshi.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> studentArrayList;
    RecyclerView recyclerView;
    EditText etName;
    EditText etCourse;
    Button btnAdd;
    StudentRecyclerAdapter studentRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student_layout);
        studentArrayList = generateStudents();
        recyclerView = (RecyclerView) findViewById(R.id.rv_1);
        etName = (EditText) findViewById(R.id.etName);
        etCourse = (EditText) findViewById(R.id.etCourse);
        studentRecyclerAdapter = new StudentRecyclerAdapter(studentArrayList,this);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,4));to display in grid manner 4 displays no of collumns we can change it to any
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));//to display in reverse order
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//to display originally
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));//to display in reverse order horizontally
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));//to dislay originally in horizontal direction
        recyclerView.setAdapter(studentRecyclerAdapter);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });
    }
    public void addStudent(){
        String name = etName.getText().toString();
        String course = etCourse.getText().toString();
        studentArrayList.add(new Student(name,course));
        studentRecyclerAdapter.notifyDataSetChanged();
        etName.getText().clear();
        etCourse.getText().clear();

    }
    static ArrayList<Student> generateStudents(){
        ArrayList<Student> newStudents = new ArrayList<>();


        return newStudents;
    }
}
