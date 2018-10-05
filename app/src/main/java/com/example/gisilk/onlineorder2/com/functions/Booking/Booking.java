package com.example.gisilk.onlineorder2.com.functions.Booking;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.gisilk.onlineorder2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Booking extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private Spinner dropdown;
    private boolean availability;
    private List<String> roomList;
    private ArrayAdapter<String> adapter;
    private Button buttonAvailability;
    private Activity context;
    private ValueEventListener mSendEventListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        context = this;
        buttonAvailability = (Button) findViewById(R.id.btn_checkAvailability);
        roomList = new ArrayList<>();
        dropdown = findViewById(R.id.spinner1);
        databaseReference =  FirebaseDatabase.getInstance().getReference("Hotel/Rooms");

        buttonAvailability.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });
//        ValueEventListener valueEventListener = new ValueEventListener(){
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Log.i("booking", "asdasdasdasdsadsadsadsadsadsadsad : ");
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                //
//            }
//        };
//        databaseReference.addValueEventListener(valueEventListener);
//        mSendEventListner = valueEventListener;
//         Read from the database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    roomList.add(ds.getKey());
                }
//                databaseReference.removeEventListener(context);
                setValuesToSpinner();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.i("booking", "error : " + error);
            }
        });

    }

    public void setValuesToSpinner(){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, roomList);
        dropdown.setAdapter(adapter);
    }
}
