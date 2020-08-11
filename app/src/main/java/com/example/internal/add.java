package com.example.internal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class add extends AppCompatActivity {
    static Button b1,b2;
    static EditText t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        b1=(Button)findViewById(R.id.btns);
        b2=(Button)findViewById(R.id.btnbadd);
        t1=(EditText)findViewById(R.id.etname);
        t2=(EditText)findViewById(R.id.etph);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),MainActivity.class));
                finish();
            }
        });

    }
    public void write(){
        Contact contact=new Contact(t1.getText().toString(),t2.getText().toString());
        MainActivity.list.add(contact);

        try{
            String msg=t1.getText().toString()+","+t2.getText().toString();
            FileOutputStream fi=openFileOutput("mytext1.txt", MODE_APPEND);
            fi.write(msg.getBytes());
            fi.close();
            Toast.makeText(getApplicationContext(),"New Contact Saved",Toast.LENGTH_SHORT).show();
            t1.setText("");
            t2.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
