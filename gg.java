package com.example.shedavtech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

        import android.app.AlertDialog;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Spinner;
        import android.widget.Toast;
        import java.util.ArrayList;


public class Admin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        final Spinner dropdown=findViewById(R.id.spinner);


        String[] items=new String[]{};


        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter);
        MyDb myDb=new MyDb(this);
        final Button user=findViewById(R.id.button8);
        final SQLiteDatabase db=myDb.getWritableDatabase();
        final SQLiteDatabase dbr=myDb.getReadableDatabase();
        final Button b1=findViewById(R.id.button5);
        Button b2=findViewById(R.id.button6);
        Button b7=findViewById(R.id.button7);
        Button button9=findViewById(R.id.button9);
        Button b10=findViewById (R.id.button10);
        Button but=findViewById (R.id.button12);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbr.rawQuery("SELECT * FROM purchases",null);
                StringBuffer buffer=new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("item name:" +c.getString(0)+"\n");
                    buffer.append("item ID:" +c.getString(1)+"\n");

                }
                showMessage("Item details",buffer.toString());
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbr.rawQuery("SELECT * FROM repairs",null);
                StringBuffer buffer=new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("item name:" +c.getString(0)+"\n");
                    buffer.append("item ID:" +c.getString(1)+"\n");

                }
                showMessage("Item details",buffer.toString());
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent (Admin.this, Purchases.class);
                startActivity (n);
            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(getApplicationContext(),Login.class);
                startActivity(j);
            }
        });

        Cursor cur=dbr.rawQuery("SELECT * FROM customers",null);
        final ArrayList<String> purchases = new ArrayList<> ();
        int x = 0;
        while (cur.moveToNext ()) {
            String item = cur.getString (0);
            String itemID = item;
            purchases .add (itemID);
            x++;
        }



        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext (), Repairs.class);
                startActivity(i);


            }
        });

        Cursor cu=dbr.rawQuery("SELECT * FROM customer ",null);
        final ArrayList<String> Rooms = new ArrayList<> ();
        x = 0;
        //int total_price = 0;

        while (cu.moveToNext ()) {
            String number = cu.getString (0);
            String price = cu.getString (1);
            //total_price += Integer.valueOf (price);
            String result = number + " " + price;
            Rooms.add (result);
            x++;
        }


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(getApplicationContext (), Delete.class);
                startActivity(ii);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cc=dbr.rawQuery("SELECT * FROM customers",null);
                StringBuffer buffer=new StringBuffer();
                while (cc.moveToNext())
                {
                    buffer.append("Name: " +cc.getString(0)+"\n");
                    buffer.append("Username: " +cc.getString(1)+"\n");
                    buffer.append("Email: " +cc.getString(2)+"\n");
                    buffer.append("Pass: " +cc.getString(3)+"\n\n");

                }
                showMessage("Users Registered",buffer.toString());
            }
        });


    }
    public void showMessage(String title,String message) { AlertDialog.Builder builder=new AlertDialog.Builder(this); builder.setCancelable(true); builder.setTitle(title); builder.setMessage(message); builder.show(); }



}

