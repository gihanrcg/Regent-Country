package com.example.gisilk.onlineorder2.com.functions.Admin;

import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gisilk.onlineorder2.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.BitSet;

public class LiquorManagement extends AppCompatActivity {

    private int REQUEST_CODE = 1;
    private static final int Galley_Intent = 2;
    ImageView liquorImage;
    Button btnUpload;
    private StorageReference mStorageref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor_management);

        mStorageref = FirebaseStorage.getInstance().getReference();

        liquorImage = (ImageView) findViewById(R.id.uploadImageView);

        liquorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent uploadimage = new Intent(Intent.ACTION_PICK);
//                uploadimage.setType("image/*");
//                startActivityForResult(uploadimage, Galley_Intent);

                Intent up = new Intent();
                up.setType("image/*");
                up.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(up,"Select image"),REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null ) {
            try {
                Uri uri = data.getData();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                liquorImage.setImageBitmap(bitmap);


                StorageReference uploadImageRef = mStorageref.child(data.getData().toString());

                Toast.makeText(LiquorManagement.this,"Selection Done",Toast.LENGTH_SHORT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(LiquorManagement.this,"Selection Cancelled",Toast.LENGTH_SHORT);
        }

    }
}
