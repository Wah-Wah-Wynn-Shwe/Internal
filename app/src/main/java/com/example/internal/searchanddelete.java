package com.example.internal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class searchanddelete extends AppCompatActivity {
    static Button b1,b2,b3;
    static EditText t1;
    static TextView t2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchanddelete);

        b1=(Button)findViewById(R.id.btnsearch);
        b2=(Button)findViewById(R.id.btndelete);
        b3=(Button)findViewById(R.id.btnbsandd);
        t1=(EditText) findViewById(R.id.etname1);
        t2=(TextView) findViewById(R.id.tvresult);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getApplication(),MainActivity.class));
               finish();
            }
        });



    }
    public void search(){
        for(Contact contact:MainActivity.list){
            if(contact.getName().equals(t1.getText().toString())){
                t2.setText("Found\n"+contact.toString());
                return;
            }
        }
        t2.setText("Not Found");
    }

    private void delete(){
        int length=MainActivity.list.size();
        for(Contact contact:MainActivity.list){
            if(contact.getName().equals(t1.getText().toString()))
                MainActivity.list.remove(contact);
        }


        if(length==MainActivity.list.size()){
            Toast.makeText(getApplicationContext(),"Not Contact Exited", Toast.LENGTH_SHORT).show();
            return;
        }
        String msg="";
        for(Contact contact:MainActivity.list){
            msg+=contact.toString()+"\n";

        }
        try{
            FileOutputStream fi=openFileOutput("mytext1.txt",MODE_APPEND);
            fi.write(msg.getBytes());

            fi.close();
            Toast.makeText(getApplicationContext(),"Conatct Deleted",Toast.LENGTH_SHORT).show();
            t1.setText("");
            t2.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
