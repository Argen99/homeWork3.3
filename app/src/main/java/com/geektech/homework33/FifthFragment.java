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

public class FifthFragment extends Fragment {

    private TextView textView5;
    private Button button5;
    private static final String BUNDLE_KEY5 = "key.bundle";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView5 = view.findViewById(R.id.tv_5);
        button5 = view.findViewById(R.id.btn_5);

        Bundle bundle5 = getArguments();
        if (bundle5 != null){
            String text5 = bundle5.getString(BUNDLE_KEY5);
            textView5.setText(text5);
        }

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container1, new FirstFragment()).commit();
            }
        });

    }
    public static FifthFragment newInstance(String text5){
        FifthFragment fragment5 = new FifthFragment();
        Bundle bundle5 = new Bundle();
        bundle5.putString(BUNDLE_KEY5,text5);
        fragment5.setArguments(bundle5);
        return fragment5;
    }
}