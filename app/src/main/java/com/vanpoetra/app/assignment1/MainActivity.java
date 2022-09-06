package com.vanpoetra.app.assignment1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mShowCount;

    //Sebelumnya saya menggunakan Shared Preferences semuanya berfungsi, dan pada saat menggunakan savedInstanceState:
    //- Rotate screen : input masih tersimpan
    //- Menggunakan tombol home lalu kembali ke aplikasi : input masih tersimpan
    //- Lock screen dan menyalakan kembali: input masih tersimpan
    //- Menggunakan tombol back lalu kembali ke aplikasi : input tidak tersimpman

    //Lalu setelah mengikuti kode yang ada pada Sesi 6 saat Meet Senin malam, menggunakan tombol back masih saja tidak berfungsi
    //Device yang saya gunakan : Redmi 2 (Android 5), Redmi 6 (Android 9), dan Samsung Galaxy A32 (Android 11 & 12)

    //Code by: Irvan Pratama Putra (JVAN-KS04-013)
    //Assignment 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);

        if(savedInstanceState != null) {
            String count = savedInstanceState.getString("count");
            if(mShowCount != null) {
                mShowCount.setText(count);
            }
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count", String.valueOf(mShowCount.getText()));
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle mySavedState) {
        super.onRestoreInstanceState(mySavedState);

        if(mySavedState != null) {
            String count = mySavedState.getString("count");
            if(count != null) {
                mShowCount.setText(count);
            }
        }
    }
}