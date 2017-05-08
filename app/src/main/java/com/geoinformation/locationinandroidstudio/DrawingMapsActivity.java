package com.geoinformation.locationinandroidstudio;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

public class DrawingMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng SCE = new LatLng(31.807255, 34.658314);
        mMap.addMarker(new MarkerOptions().position(SCE).title("SCE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SCE));
    }

    public void Add_Circle_clicked(@SuppressWarnings("UnusedParameters") View view){
        @SuppressWarnings("UnusedAssignment")
            Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(31.807255, 34.658314))
                .radius(10000)
                .strokeColor(Color.RED)
                .fillColor(Color.WHITE));
    }

    public void Remove_clicked(@SuppressWarnings("UnusedParameters") View view){

        //circle.remove();
        //polyline.remove();
        mMap.clear();
    }

    public void Add_Polyline_Clicked(@SuppressWarnings("UnusedParameters") View view) {

        LatLng WestWall = new LatLng(31.776719, 35.234507);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(WestWall));
        @SuppressWarnings("UnusedAssignment") Polyline polyline = mMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(31.779952, 35.233720),
                        new LatLng(31.780423, 35.237111),
                        new LatLng(31.776153, 35.237754),
                        new LatLng(31.775603, 35.234467),
                        new LatLng(31.779952, 35.233720)
                        ));
    }

    public void draw_Polygon_Clicked(@SuppressWarnings("UnusedParameters") View view) {

        LatLng PortLand = new LatLng(45.548346, -122.633106);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PortLand));

        List<LatLng> polygon = new ArrayList<>();
        polygon.add(new LatLng(45.522585, -122.685699));
        polygon.add(new LatLng(45.534611, -122.708873));
        polygon.add(new LatLng(45.530883, -122.678833));
        polygon.add(new LatLng(45.547115, -122.667503));
        polygon.add(new LatLng(45.530643, -122.660121));
        polygon.add(new LatLng(45.533529, -122.636260));
        polygon.add(new LatLng(45.521743, -122.659091));
        polygon.add(new LatLng(45.510677, -122.648792));
        polygon.add(new LatLng(45.515008, -122.664070));
        polygon.add(new LatLng(45.502496, -122.669048));
        polygon.add(new LatLng(45.515369, -122.678489));
        polygon.add(new LatLng(45.506346, -122.702007));
        polygon.add(new LatLng(45.522585, -122.685699));
        mMap.addPolygon(new PolygonOptions()
                .addAll(polygon)
                .fillColor(Color.parseColor("#3bb2d0")));
    }

}


