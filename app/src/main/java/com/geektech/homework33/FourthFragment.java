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


public class FourthFragment extends Fragment {

    private TextView textView4;
    private Button button4;
    private static final String BUNDLE_KEY4 = "key.bundle";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView4 = view.findViewById(R.id.tv_4);
        button4 = view.findViewById(R.id.btn_4);

        Bundle bundle4 = getArguments();
        if (bundle4 !=null){
            String text4 = bundle4.getString(BUNDLE_KEY4);
            textView4.setText(text4);
        }

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container1,FifthFragment.newInstance(textView4.getText().
                                toString())).addToBackStack("").commit();
            }
        });
    }


    public static FourthFragment newInstance(String text4){
        FourthFragment fragment4 = new FourthFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putString(BUNDLE_KEY4,text4);
        fragment4.setArguments(bundle4);
        return fragment4;
    }
}