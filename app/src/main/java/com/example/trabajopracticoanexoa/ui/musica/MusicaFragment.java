package com.example.trabajopracticoanexoa.ui.musica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.trabajopracticoanexoa.R;
import com.example.trabajopracticoanexoa.databinding.FragmentMusicaBinding;

public class MusicaFragment extends Fragment {

    private FragmentMusicaBinding binding;
    private MusicaViewModel musicaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        musicaViewModel = new ViewModelProvider(this).get(MusicaViewModel.class);

        binding = FragmentMusicaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnPlay.setOnClickListener(view -> {
            musicaViewModel.startPlaying(getContext(), R.raw.song_never_gonna_give_you_up);
        });

        binding.btnPause.setOnClickListener(view -> {
            musicaViewModel.pausePlaying();
        });

        binding.btnStop.setOnClickListener(view -> {
            musicaViewModel.stopPlaying();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        if (musicaViewModel != null) {
            musicaViewModel.stopPlaying();
        }
    }
}