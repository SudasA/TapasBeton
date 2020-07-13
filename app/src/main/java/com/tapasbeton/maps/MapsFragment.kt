package com.tapasbeton.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tapasbeton.R


class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap


    companion object {
        var mapFragment : SupportMapFragment?=null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.activity_maps, container, false)

        mapFragment = childFragmentManager.findFragmentById(
            R.id.map
        ) as SupportMapFragment
        mapFragment?.getMapAsync(this)

        return rootView
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val kolodishi = LatLng(53.938818, 27.762208)
        val zoomLevel = 9f
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(kolodishi, zoomLevel))
        map.addMarker(
            MarkerOptions().position(kolodishi).title("РБУ ТАПАС ПЛЮС, аг. Колодищи, ул. Чкалова, 37").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))

        map.uiSettings.setZoomControlsEnabled(true)
        setMapLongClick(map)



    }

    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener { latLng ->
            // A Snippet is Additional text that's displayed below the title.
//            val snippet = String.format(
//                Locale.getDefault(),
//                "Lat: %1$.5f, Long: %2$.5f",
//                latLng.latitude,
//                latLng.longitude
//            )

            val snippet = getString(R.string.lst_lng, latLng.latitude, latLng.longitude)

            map.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(getString(R.string.dropped_pin))
                    .snippet(snippet)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            )
        }
    }


}





