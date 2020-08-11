package com.example.internal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class view extends AppCompatActivity {
    static Button b1;
    static LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        b1=(Button)findViewById(R.id.btnview);
        layout=(LinearLayout)findViewById(R.id.outer);

        if(MainActivity.list.size()>0){
            for(Contact contact:MainActivity.list){
                TextView tv=new TextView(this);
                tv.setText(contact.toString());
                tv.setTextSize(20);
                layout.addView(tv);
            }
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),MainActivity.class));
                finish();
            }
        });

    }

}
