package com.geoinformation.locationinandroidstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StreetViewMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view_menu);

    }

    public void Button_clicked(@SuppressWarnings("UnusedParameters") View view){

        Intent intent = new Intent (this,StreetView.class);
        EditText svmText =(EditText)findViewById(R.id.SVM_search_txt);
        String SomeString = svmText.getText().toString();
        intent.putExtra("SearchText", SomeString);
        startActivity(intent);

    }
}
