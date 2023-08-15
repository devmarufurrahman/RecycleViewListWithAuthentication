package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerContact;
    EditText searchView;
    FloatingActionButton addContact;

    ArrayList<contactModal> arrContact = new ArrayList<>();

    private  RecyclerContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // id define
        recyclerContact = findViewById(R.id.recyclerContact);
        searchView = findViewById(R.id.searchView);
        addContact = findViewById(R.id.addContact);

        // search option

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterList(charSequence.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });


        // ==================================

        // Add new contact
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_contact);

                EditText editName = dialog.findViewById(R.id.editName);
                EditText editNumber = dialog.findViewById(R.id.editNumber);
                Button saveBtn = dialog.findViewById(R.id.saveBtn);


                saveBtn.setOnClickListener(new View.OnClickListener() {
                    String nameInput= "", numberInput="";
                    @Override
                    public void onClick(View view) {

                        if (!editName.getText().toString().equals("") && !editNumber.getText().toString().equals("")){
                             nameInput = editName.getText().toString();
                             numberInput = editNumber.getText().toString();
                            arrContact.add(new contactModal(nameInput,numberInput));
                            adapter.notifyItemInserted(arrContact.size()-1);
                            recyclerContact.scrollToPosition(arrContact.size()-1);

                            dialog.dismiss();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Name & Number", Toast.LENGTH_SHORT).show();
                        }



                    }
                });

                dialog.show();

            }
        });


        // =================================


        recyclerContact.setLayoutManager(new LinearLayoutManager(this));

        arrContact.add(new contactModal(R.drawable.contact, "Maruf", "01757474700"));
        arrContact.add(new contactModal(R.drawable.contact, "Noman", "01754892489"));
        arrContact.add(new contactModal(R.drawable.contact, "Shakil", "0146879379"));
        arrContact.add(new contactModal(R.drawable.contact, "Niloy", "0135678957"));
        arrContact.add(new contactModal(R.drawable.contact, "Ofid", "0145689895"));
        arrContact.add(new contactModal(R.drawable.contact, "Sadik", "0145987962"));
        arrContact.add(new contactModal(R.drawable.contact, "Badsha", "0175496289"));
        arrContact.add(new contactModal(R.drawable.contact, "Rahul", "0175685659"));
        arrContact.add(new contactModal(R.drawable.contact, "Alamin", "019689585"));
        arrContact.add(new contactModal(R.drawable.contact, "Nasim", "0187569265"));
        arrContact.add(new contactModal(R.drawable.contact, "Rohan", "0176589655"));
        arrContact.add(new contactModal(R.drawable.contact, "Humayun", "0168595265"));
        arrContact.add(new contactModal(R.drawable.contact, "Bayzid", "0158982694"));
        arrContact.add(new contactModal(R.drawable.contact, "Mehedi", "01759+95998"));
        arrContact.add(new contactModal(R.drawable.contact, "Shibly", "017569962"));
        arrContact.add(new contactModal(R.drawable.contact, "Papon", "0156988566"));
        arrContact.add(new contactModal(R.drawable.contact, "Rifat", "0175926695"));


         adapter = new RecyclerContactAdapter(MainActivity.this, arrContact);
        recyclerContact.setAdapter(adapter);


    }

    private void filterList(String text) {
        List<contactModal> filterList = new ArrayList<>();
        for(contactModal items: arrContact){
            if (items.getName().toLowerCase().contains(text.toLowerCase()) || items.getNumber().contains(text.toLowerCase())){
                filterList.add(items);
            }
        }
        adapter.filterList(filterList);
    }


}