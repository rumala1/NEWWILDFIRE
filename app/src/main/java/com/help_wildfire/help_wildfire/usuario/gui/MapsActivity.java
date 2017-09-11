package com.help_wildfire.help_wildfire.usuario.gui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.help_wildfire.help_wildfire.R;
import com.help_wildfire.help_wildfire.usuario.gui.dominio.Usuario;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
    private static final String MANTER_CONECTADO = "manter_conectado";
    private static final String PREFERENCE_NAME = "LoginActivityPreferences";
    //Context context = getApplicationContext();
    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final String TAG = "MapsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        try {
            mMap.setMyLocationEnabled(true);
        }catch (SecurityException ex){
            Log.e(TAG, "Error", ex);
        }

        // Marcador em um incendio no Arizona
        LatLng sydney = new LatLng(34.836540, -111.469175);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Wildfire in Arizona"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void onBackPressed(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor     = sharedPreferences.edit();
        editor.putBoolean(MANTER_CONECTADO, false);
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        editor.clear();
        editor.commit();
        startActivity(intent);
        finish();
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Toast.makeText(getApplicationContext(), "coord"+ latLng.toString(),Toast.LENGTH_SHORT).show();
    }
}
