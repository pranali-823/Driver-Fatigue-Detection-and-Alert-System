package com.example.artemis.dfds_app;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    private final int PICK_CONTACT = 0;
    private static final String TAG = "ContactActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(i, PICK_CONTACT);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addContactItems();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult()");
        if (requestCode == PICK_CONTACT) {
            if (resultCode == Activity.RESULT_OK) {
                Uri contactsData = data.getData();
                CursorLoader loader = new CursorLoader(this, contactsData, null, null, null, null);
                Cursor c = loader.loadInBackground();
                if (c.moveToFirst()) {
                    Log.i(TAG, "Contacts ID: " + c.getString(c.getColumnIndex(ContactsContract.Contacts._ID)));
                    Log.i(TAG, "Contacts Name: " + c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                    Log.i(TAG, "Contacts Phone Number: " + c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                    Log.i(TAG, "Contacts Photo Uri: " + c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Photo.PHOTO_URI)));
                    //int img = Integer.parseInt(c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Photo.PHOTO_URI)));
                    //String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    //String no = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


                }
            }
        }
    }

    public void addContactItems() {

        final ArrayList<Contact> contacts = new ArrayList<>();

        final ListView contactListView = (ListView) findViewById(R.id.list);

        int img = R.drawable.user;
        String name = "Jane Doe";
        String no = "+919876543210";

        contacts.add(new Contact(img,name,no));
        contactListView.setAdapter(new ContactAdapter(ContactActivity.this, contacts));

    }
}