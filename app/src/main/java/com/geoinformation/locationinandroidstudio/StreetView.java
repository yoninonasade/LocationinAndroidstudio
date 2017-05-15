package com.geoinformation.locationinandroidstudio;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import java.io.IOException;
import java.util.List;


public class StreetView  extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {

    LatLng latLng = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);
        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.street_view_panorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);


        Bundle bundle = getIntent().getExtras();
        String tempText = bundle.getString("SearchText");

        List<Address> addressList = null ;



        Geocoder geocoder = new Geocoder(this);

        try {
            addressList = geocoder.getFromLocationName(tempText, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (addressList != null) {
            Address address = addressList.get(0);
            //v = new LatLng(address.getLatitude(), address.getLongitude());
            latLng = new LatLng(address.getLatitude(),address.getLongitude());

        }





    }

    @Override
    public void onStreetViewPanoramaReady(final StreetViewPanorama streetViewPanorama) {

        streetViewPanorama.setPosition(new LatLng(latLng.latitude, latLng.longitude));
    }


}



