package com.foreach.android.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.foreach.android.R;


public class StartFragment extends Fragment implements View.OnClickListener {

    private Button btnStartGame;
    private Button btnSettings;
    private Button btnAbout_the_game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_start, container, false);
        btnStartGame = (Button)view.findViewById(R.id.btnStart_game);

        btnStartGame.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {

    }
}