package com.example.sajal.onlinedb_prk;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sajal on 28-06-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder> {
JSONArray jsonArray;



    public RecyclerViewAdapter(JSONArray jArray){

        jsonArray=jArray;

    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        try {
            JSONObject jObject = jsonArray.getJSONObject(position);
            holder.ngo_image.setImageResource(R.drawable.sample_0);
            holder.ngo_name.setText(jObject.getString("name"));
            holder.ngo_email.setText(jObject.getString("email"));
            holder.ngo_mobile.setText(jObject.getString("mobile"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        CardView cardView;
        ImageView ngo_image;
        TextView ngo_name,ngo_email,ngo_mobile;
        public ContactViewHolder(View view){
            super(view);
            view.setOnClickListener(this);
            cardView=(CardView)view.findViewById(R.id.card_view);
            ngo_image=(ImageView)view.findViewById(R.id.ngo_image);
            ngo_name=(TextView)view.findViewById(R.id.ngo_name);
            ngo_email=(TextView)view.findViewById(R.id.ngo_email);
            ngo_mobile=(TextView)view.findViewById(R.id.ngo_contact);
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "clickevent", Toast.LENGTH_LONG).show();
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment myFragment = new Ngo_details();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container,myFragment).commit();
        }
    }
}
