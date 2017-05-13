package com.geoinformation.locationinandroidstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Search_Clicked(@SuppressWarnings("UnusedParameters") View view){
        Intent intent = new Intent (this,MapsActivity.class);
        startActivity(intent);
    }

    public void Drawing_Clicked(@SuppressWarnings("UnusedParameters") View view){
        Intent intent = new Intent (this,DrawingMapsActivity.class);
        startActivity(intent);
    }

    public void StreetView_Clicked(@SuppressWarnings("UnusedParameters") View view)
    {
        Intent intent = new Intent(this,StreetViewMenu.class);
        startActivity(intent);
    }

}
