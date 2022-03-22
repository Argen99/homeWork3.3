package com.geektech.homework33;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView textView2;
    private Button button2;
    private static final String BUNDLE_KEY = "key.bundle";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    public static SecondFragment newInstance(String text){
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY,text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView2 = view.findViewById(R.id.tv_2);
        button2 = view.findViewById(R.id.btn_2);

        Bundle chemodan = getArguments();
        if (chemodan != null){
            String text = chemodan.getString(BUNDLE_KEY);
            textView2.setText(text);
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container1,ThirdFragment.newInstance(textView2.getText().
                                toString())).addToBackStack("").commit();
            }
        });

    }
}