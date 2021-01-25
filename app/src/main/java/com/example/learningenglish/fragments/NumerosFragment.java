package com.example.learningenglish.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.learningenglish.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener{

    ImageView imgOne, imgTwo, imgThree, imgFour, imgFive, imgSix;
    MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imgOne = view.findViewById(R.id.imgOne);
        imgTwo = view.findViewById(R.id.imgTwo);
        imgThree = view.findViewById(R.id.imgThree);
        imgFour = view.findViewById(R.id.imgFour);
        imgFive = view.findViewById(R.id.imgFive);
        imgSix = view.findViewById(R.id.imgSix);

        imgOne.setOnClickListener(this);
        imgTwo.setOnClickListener(this);
        imgThree.setOnClickListener(this);
        imgFour.setOnClickListener(this);
        imgFive.setOnClickListener(this);
        imgSix.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgOne:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.one);
                playSound();
                break;
            case R.id.imgTwo:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.two);
                playSound();
                break;
            case R.id.imgThree:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.three);
                playSound();
                break;
            case R.id.imgFour:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.four);
                playSound();
                break;
            case R.id.imgFive:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.five);
                playSound();
                break;
            case R.id.imgSix:
                mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.six);
                playSound();
                break;
        }
    }
}

