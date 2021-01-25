package com.example.learningenglish.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.learningenglish.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimaisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimaisFragment extends Fragment implements View.OnClickListener{

    ImageView imgDog, imgCat, imgLion, imgCow, imgSheep, imgMonkey;
    MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimaisFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimaisFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimaisFragment newInstance(String param1, String param2) {
        AnimaisFragment fragment = new AnimaisFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animais, container, false);

        imgDog = view.findViewById(R.id.imgDog);
        imgCat = view.findViewById(R.id.imgCat);
        imgLion = view.findViewById(R.id.imgLion);
        imgMonkey = view.findViewById(R.id.imgMonkey);
        imgSheep = view.findViewById(R.id.imgSheep);
        imgCow = view.findViewById(R.id.imgCow);

        imgDog.setOnClickListener(this);
        imgCat.setOnClickListener(this);
        imgLion.setOnClickListener(this);
        imgMonkey.setOnClickListener(this);
        imgSheep.setOnClickListener(this);
        imgCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if( mediaPlayer != null && mediaPlayer.isPlaying() ){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgDog:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.dog);
                playSound();
                break;
            case R.id.imgCat:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.cat);
                playSound();
                break;
            case R.id.imgLion:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.lion);
                playSound();
                break;
            case R.id.imgMonkey:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.monkey);
                playSound();
                break;
            case R.id.imgSheep:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.sheep);
                playSound();
                break;
            case R.id.imgCow:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.cow);
                playSound();
                break;
        }
    }

    public void playSound(){
        if( mediaPlayer != null ){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }
}