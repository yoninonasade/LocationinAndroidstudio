package com.geoinformation.locationinandroidstudio;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;



public class StreetView  extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {

    //EditText street_view_editText = (EditText)findViewById(R.id.StreetViewTextView);
   // Button street_view_button = (Button)findViewById(R.id.btn_StreetView_search);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);
        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.street_view_panorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

    }

    @Override
    public void onStreetViewPanoramaReady(final StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(31.807785, 34.658785));
        Button street_view_button = (Button)findViewById(R.id.btn_StreetView_search);

        street_view_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                streetViewPanorama.setPosition(new LatLng(31.796629, 34.633522));
            }
        });


    }


}



