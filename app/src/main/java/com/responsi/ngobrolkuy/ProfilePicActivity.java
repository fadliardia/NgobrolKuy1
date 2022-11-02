package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePicActivity extends AppCompatActivity {
    private CircleImageView image;
    private ImageButton tambahfoto;

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        image = findViewById(R.id.profilePic);

        tambahfoto = findViewById(R.id.imagetambah);
        tambahfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });
    }

    public void lanjut(View view) {
        Intent lanjut = new Intent(ProfilePicActivity.this, HomeActivity.class);
        startActivity(lanjut);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Cancel input image", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (requestCode == GALLERY_REQUEST_CODE){
            if (data != null){
                try {
                    imageUri = data.getData();
                    Bitmap bmp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    image.setImageBitmap(bmp);
                }
                catch (IOException e){
                    Toast.makeText(this, "gabisa ke load", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}