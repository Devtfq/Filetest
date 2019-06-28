package com.thawfeeqstudios.sahamedthwfeeq.filetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tt;
    private String pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bb = findViewById(R.id.bb);
        tt = findViewById(R.id.tt);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Filechoose.class);
                startActivityForResult(intent,6);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 6 && resultCode == RESULT_OK){
            pp = data.getStringExtra("mypath");
            tt.setText(pp);
        }
    }
}
