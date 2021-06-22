package com.example.elderlycaresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    EditText name, mobile, city, blood, weight, age;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        DB = new DBHelper(this);

        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        city = findViewById(R.id.city);
        blood = findViewById(R.id.blood);
        weight = findViewById(R.id.weight);
        age = findViewById(R.id.age);

        getDdetails();
    }

    private void getDdetails() {
        SQLiteDatabase database = DB.getReadableDatabase();
        Cursor cursor1 = database.rawQuery("SELECT * FROM customer", null);
        int count = cursor1.getCount();
        if(count < 1){
            DB.insertCust();
        }
        Cursor cursor = database.rawQuery("SELECT * FROM customer", null);
        cursor.moveToFirst();
        name.setText(cursor.getString(1));
        mobile.setText(cursor.getString(2));
        city.setText(cursor.getString(3));
        blood.setText(cursor.getString(4));
        weight.setText(cursor.getString(5));
        age.setText(cursor.getString(6));
    }

    public void back(View view) {
        startActivity(new Intent(Profile.this, Dashboard.class));
    }

    public void saveDate(View view) {
        DB.updateCustomer((name.getText().toString()), (mobile.getText().toString()), (city.getText().toString()), (blood.getText().toString()),
                        (weight.getText().toString()), (age.getText().toString()));
        Toast.makeText(getApplicationContext(), "Information Updated Successfully", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), Profile.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), Dashboard.class));
    }
}