package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import androidx.annotation.NonNull;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> items = new ArrayList<String>();
    public static ArrayList<Integer> cost = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void cart(View view)
    {
        Intent intent = new Intent(MainActivity.this,Food_cart.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options,menu);
        return true;
    }
   public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this,"PASTA IS SELECTED", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Pasta_intent.class);
                startActivity(i);
                return true;

            case R.id.item2:
                Toast.makeText(this,"PIZZA IS SELECTED", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.item21:
                Toast.makeText(this,"PIZZA (VEG) IS SELECTED", Toast.LENGTH_SHORT).show();
                i = new Intent(getApplicationContext(), Pizza_Intent.class);
                startActivity(i);
                return true;

            case R.id.item22:
                Toast.makeText(this,"PIZZA (NON VEG) IS SELECTED", Toast.LENGTH_SHORT).show();
                i = new Intent(getApplicationContext(), Pizza_non_veg.class);
                startActivity(i);
                return true;

            case R.id.sc:
                Intent intent = new Intent(MainActivity.this,Food_cart.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}