package com.example.storephoto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class UploadImage extends AppCompatActivity {
    private Uri imageUri;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        getSupportActionBar().hide();
        TextView addImage = findViewById(R.id.addimage);
        ProgressBar progressBar = findViewById(R.id.progressbar);
        ImageView imageView = findViewById(R.id.image);
        DatabaseReference root = FirebaseDatabase.getInstance().getReference("Image");
        StorageReference reference = FirebaseStorage.getInstance().getReference();
        findViewById(R.id.showimage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(UploadImage.this, ShowImage.class);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntenet = new Intent();
                galleryIntenet.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntenet.setType("Image/*");
                startActivityForResult(galleryIntenet, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && requestCode == RESULT_OK && data == null){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}