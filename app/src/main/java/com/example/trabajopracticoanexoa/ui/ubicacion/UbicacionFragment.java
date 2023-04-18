package com.example.trabajopracticoanexoa.ui.ubicacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trabajopracticoanexoa.databinding.FragmentUbicacionBinding;
import com.google.android.gms.maps.MapView;

public class UbicacionFragment extends Fragment {

    private FragmentUbicacionBinding binding;
    private MapView mapView;
    private UbicacionViewModel ubicacionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ubicacionViewModel = new ViewModelProvider(this).get(UbicacionViewModel.class);

        binding = FragmentUbicacionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mapView = binding.mapView;

        ubicacionViewModel.initMap(this, mapView);

        ubicacionViewModel.getLocationPermissionGranted().observe(getViewLifecycleOwner(), granted -> {
            if (!granted) {
                Toast.makeText(getContext(), "Permiso denegado", Toast.LENGTH_SHORT).show();
            }
        });

        ubicacionViewModel.getMap().observe(getViewLifecycleOwner(), map -> {

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView != null) mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mapView != null) mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mapView != null) mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mapView != null) mapView.onLowMemory();
    }

}