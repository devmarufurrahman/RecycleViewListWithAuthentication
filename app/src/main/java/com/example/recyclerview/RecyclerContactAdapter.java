package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.viewHolder>{

    Context context;
    List<contactModal> arrContacts;

    private int lastPosition = -1;
    RecyclerContactAdapter(Context context, List<contactModal> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_list, parent, false);
        RecyclerView.ViewHolder viewHolder = new viewHolder(view);
        return (RecyclerContactAdapter.viewHolder) viewHolder;
    }

    public void filterList(List<contactModal> filterList){
        arrContacts = filterList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog updateDialog = new Dialog(context);
                updateDialog.setContentView(R.layout.add_contact);
                updateDialog.setCancelable(true);
                updateDialog.show();
                EditText editName = updateDialog.findViewById(R.id.editName);
                EditText editNumber = updateDialog.findViewById(R.id.editNumber);
                Button updateBtn = updateDialog.findViewById(R.id.saveBtn);
                TextView txtView = updateDialog.findViewById(R.id.newContactHead);


                txtView.setText("Update Contact");
                updateBtn.setText("UPDATE");
                editNumber.setText(arrContacts.get(position).number);
                editName.setText(arrContacts.get(position).name);

                updateBtn.setOnClickListener(new View.OnClickListener() {
                    String nameInput="", numberInput="";
                    @Override
                    public void onClick(View v) {
                        if (!editName.getText().toString().equals("") && !editNumber.getText().toString().equals("")){
                            nameInput = editName.getText().toString();
                            numberInput = editNumber.getText().toString();
                        } else {
                            Toast.makeText(context, "Please Enter Name & Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.set(position,new contactModal(nameInput,numberInput));
                        notifyItemChanged(position);
                        updateDialog.dismiss();
                    }
                });

            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to Delte")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                arrContacts.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();

                return true;
            }
        });

        setAnimation(holder.itemView,position);

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtNumber;
        ImageView imgContact;
        LinearLayout llRow;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }

    private void setAnimation(View viewToAnimate, int position){
        if (position>lastPosition) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);

            viewToAnimate.startAnimation(slideIn);
            lastPosition = position;
        }
    }
}
