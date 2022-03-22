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
import android.widget.Toast;

public class FirstFragment extends Fragment {

    private Button button1;
    private EditText editText;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button1 = view.findViewById(R.id.btn1);
        editText = view.findViewById(R.id.edit_text);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().isEmpty()) {
                    requireActivity().getSupportFragmentManager().beginTransaction().
                            replace(R.id.container1, SecondFragment.newInstance(editText.getText().
                                    toString())).addToBackStack("").commit();
                }else{
                    editText.setError("Это поле не должно быть пустым");
                    Toast.makeText(getActivity(),"Заполните поле", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}