package com.example.gisilk.onlineorder2.com.functions.Admin;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gisilk.onlineorder2.R;
import com.example.gisilk.onlineorder2.com.functions.OrderLiquor.Liquor;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class ManageLiquor extends AppCompatActivity {

    EditText txtAddLiquor;
    ListView lv;
    Button btnAdd;

    RecyclerView mLiquorList;
    DatabaseReference liqourdb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_liquor);

        txtAddLiquor = findViewById(R.id.txtItem);
        lv = findViewById(R.id.liquorList);
        lv.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);

        btnAdd = findViewById(R.id.btn_add);


        liqourdb= FirebaseDatabase.getInstance().getReference().child("Hotel").child("Liquor");

        mLiquorList=(RecyclerView)findViewById(R.id.liquorList);
        mLiquorList.setHasFixedSize(true);
        mLiquorList.setLayoutManager(new LinearLayoutManager(this));




        /*final List<String> liquors = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liquors) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.WHITE);

                return  view;

            }
        };
        lv.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liquors.add(0, txtAddLiquor.getText().toString());
                txtAddLiquor.setText("");
                txtAddLiquor.findFocus();
                arrayAdapter.notifyDataSetChanged();
            }
        });*/

    }


    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<Liquor,LiquorV>
    }




    public static class LiqourViewHolder extends RecyclerView.ViewHolder{
        View mView;


        public LiqourViewHolder(View itemView) {
            super(itemView);

            mView=itemView;
        }

        public void setName(String name){
            TextView userNameView=(TextView)mView.findViewById(R.id.user_single_name);
            userNameView.setText(name);

        }

        public void setUsersStatus(String status){
            TextView userStatusView=(TextView)mView.findViewById(R.id.user_single_status);
            userStatusView.setText(status);
        }

        public void setUsersImage(final String thumb_image, final Context context){
            final CircleImageView userImageView=(CircleImageView)mView.findViewById(R.id.user_single_image);

            //Picasso.with().load(url).placeholder(R.drawable.default_pic).into(imageView);
            //Picasso.get().load(thumb_image).placeholder(R.drawable.user).tag(context).into(userImageView);
            Picasso.get().load(thumb_image).networkPolicy(NetworkPolicy.OFFLINE)
                    .placeholder(R.drawable.user).into(userImageView, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    Picasso.get().load(thumb_image).placeholder(R.drawable.user).tag(context).into(userImageView);

                }
            });

        }

    }




}
