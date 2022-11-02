package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChatActivity extends AppCompatActivity {
    private ImageButton balikkk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        balikkk = findViewById(R.id.backbalik);
        balikkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(ChatActivity.this, HomeActivity.class);
                startActivity(pindah);
            }
        });
    }
}