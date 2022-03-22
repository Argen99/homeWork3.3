package com.geektech.homework33;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ThirdFragment extends Fragment {

    private TextView textView;
    private Button button;
    private static final String BUNDLE_KEY = "key.bundle";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.tv_3);
        button = view.findViewById(R.id.btn_3);

        Bundle bundle = getArguments();
        if (bundle != null){
            String text = bundle.getString(BUNDLE_KEY);
            textView.setText(text);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container1,FourthFragment.newInstance(textView.getText().
                                toString())).addToBackStack("").commit();
            }
        });
    }



    public static ThirdFragment newInstance(String text){
        ThirdFragment fragment = new ThirdFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY,text);
        fragment.setArguments(bundle);
        return fragment;
    }
}