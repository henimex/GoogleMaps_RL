package com.hendev.googlemapsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        btnBildirimYap.setOnClickListener {
            val enlem = edtEnlem.text.toString()
            val boylam = edtBoylam.text.toString()

            val konum = LatLng(enlem.toDouble(), boylam.toDouble())
            mMap.addMarker(MarkerOptions()
                .position(konum)
                .title("Home")
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mm2))
            )
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,16f))
            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID

        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        //39.7652588,30.4047304,11
        val sydney = LatLng(39.7652588, 30.4047304)
        mMap.addMarker(MarkerOptions().position(sydney).title("Buradasiniz."))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}