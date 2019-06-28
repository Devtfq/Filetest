package com.thawfeeqstudios.sahamedthwfeeq.filetest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Filechoose extends AppCompatActivity {
    List<Product> products;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filechoose);
        recyclerView=findViewById(R.id.rr);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        File cc = new File("/sdcard/");
        fill(cc);

    }
    public void fill(File file){
        File[] fol = file.listFiles();
        products = new ArrayList<>();
        if(!file.getName().equalsIgnoreCase("sdcard")){
            products.add(0,new Product("...",file.getParent(),"back"));
        }
        try{
            for(File ff:fol){
                if(ff.isDirectory()){
                    products.add(new Product(ff.getName(),ff.getAbsolutePath(),"folder"));
                }
                else {
                    products.add(new Product(ff.getName(),ff.getAbsolutePath(),"filo"));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Productadapter productadapter = new Productadapter(this, products);
        recyclerView.setAdapter(productadapter);
        productadapter.setonitemclick(new Onitemclick() {
            @Override
            public void clicked(int position, int id) {
                if(id == -1){
                    @SuppressLint("DefaultLocale") String k= String.format("parent %d",position);
                   Toast.makeText(Filechoose.this,k,Toast.LENGTH_SHORT).show();
                    Product o = products.get(position);
                    if(((o.getfimg()).equalsIgnoreCase("folder") ) || ((o.getfimg()).equalsIgnoreCase("back"))){
                        fill(new File(o.getfpath()));
                    }
                    else{
                        sendy(o.getfpath());
                    }

                }
                else{
                    Toast.makeText(Filechoose.this,"element",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void sendy(String k){
        Intent intent=new Intent();
        intent.putExtra("mypath",k);
        setResult(RESULT_OK,intent);
        finish();
    }
}
