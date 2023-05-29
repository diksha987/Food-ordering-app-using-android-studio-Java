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

public class Pizza_Intent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_intent);
        ImageView im1 = findViewById(R.id.imageView5);
        ImageView im2 = findViewById(R.id.pizza5);

        im1.setOnCreateContextMenuListener(this);

        im1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                PopupMenu popupMenu =  new PopupMenu(Pizza_Intent.this,im1);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_pasta_1,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public  boolean onMenuItemClick(MenuItem menuItem){
                        Toast.makeText(Pizza_Intent.this , "Added to cart",Toast.LENGTH_SHORT).show();
                        MainActivity.items.add("MIX VEG PIZZA 100/-");
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
                PopupMenu popupMenu =  new PopupMenu(Pizza_Intent.this,im2);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_pizza_2,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public  boolean onMenuItemClick(MenuItem menuItem){
                        Toast.makeText(Pizza_Intent.this , "Added to cart",Toast.LENGTH_SHORT).show();
                        MainActivity.items.add("CAPSICUM CHEESE PIZZA 400/-");
                        MainActivity.cost.add(400);
                        return true;
                    }

                });
                popupMenu.show();
            }

        });

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
                Intent intent = new Intent(Pizza_Intent.this,PASTA_CUST.class);
                startActivity(intent);
                return true;
        }

        return false;
    }
}