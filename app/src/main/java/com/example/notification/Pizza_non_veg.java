package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pizza_non_veg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_non_veg);
        ImageView im1 = findViewById(R.id.pn1);
        ImageView im2 = findViewById(R.id.pn2);
        ArrayList<String> arrayList = new ArrayList<String>();

        im1.setOnCreateContextMenuListener(this);

        im1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                PopupMenu popupMenu =  new PopupMenu(Pizza_non_veg.this,im1);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_pizza_nonveg,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public  boolean onMenuItemClick(MenuItem menuItem){
                        Toast.makeText(Pizza_non_veg.this , "Added to cart",Toast.LENGTH_SHORT).show();
                        arrayList.add("CHICKEN PIZZA 250/-");
                        MainActivity.items.add("CHICKEN PIZZA 250/-\"");
                        return true;
                    }

                });
                popupMenu.show();
            }

        });

        im2.setOnCreateContextMenuListener(this);

        im2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                PopupMenu popupMenu =  new PopupMenu(Pizza_non_veg.this,im2);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_pizza_2,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public  boolean onMenuItemClick(MenuItem menuItem){
                        Toast.makeText(Pizza_non_veg.this , "Added to cart",Toast.LENGTH_SHORT).show();
                        arrayList.add("CHICKEN PEPPER PIZZA 450/-");
                        MainActivity.items.add("CHICKEN PEPPER PIZZA 450/-");

                        return true;
                    }

                });
                popupMenu.show();
            }

        });
        Intent intent = new Intent(Pizza_non_veg.this,MainActivity.class);
        intent.putStringArrayListExtra("ORDER_PIZZA_N_VEG",arrayList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu , View v , ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.customize_pasta_1,menu);
    }

    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.pasta_11:
                Toast.makeText(this,"CUSTOMIZE CLICKED",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Pizza_non_veg.this,PASTA_CUST.class);
                startActivity(intent);
                return true;
        }

        return false;
    }
}