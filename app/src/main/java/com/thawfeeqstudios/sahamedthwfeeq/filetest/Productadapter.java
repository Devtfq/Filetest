package com.thawfeeqstudios.sahamedthwfeeq.filetest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.List;

public class Productadapter extends RecyclerView.Adapter<Productadapter.Productviewholder> {
    private Context mm;
    private List<Product> products;
    private Onitemclick onitemclick;

    Productadapter(Context mm, List<Product> products) {
        this.mm = mm;
        this.products = products;
    }
    public void  setonitemclick(Onitemclick onitemclick){
        this.onitemclick=onitemclick;
    }

    @NonNull
    @Override
    public Productviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mm).inflate(R.layout.layout,null);
        return new Productviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Productviewholder holder, final int position) {
        Product product = products.get(position);
        holder.ttv.setText(product.getfname());
        String uu= "drawable/" + product.getfimg();
        int ir = mm.getResources().getIdentifier(uu,null,mm.getPackageName());
        Drawable iii= mm.getResources().getDrawable(ir);
        holder.ii.setImageDrawable(iii);
        holder.rrrr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onitemclick.clicked(position,-1);
            }
        });
        holder.ii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onitemclick.clicked(position,2);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class Productviewholder extends RecyclerView.ViewHolder{
        TextView ttv;
        ImageView ii;
        RelativeLayout rrrr;
        Productviewholder(View itemview){
            super(itemview);
            ttv = itemview.findViewById(R.id.ttv);
            ii = itemview.findViewById(R.id.ii);
            rrrr = itemview.findViewById(R.id.rrrr);
        }

    }
}
