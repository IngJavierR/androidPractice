package com.example.home.androidpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jrodriguez on 29/05/17.
 */

public class FragmentB extends Fragment {

    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b, container, false);

        textView = (TextView) view.findViewById(R.id.txtResult);
        return view;
    }

    public void addTwoNumbersInFragmentB(int num1, int num2){
        int result = num1 +  num2;
        textView.setText("Result: " + result);
    }
}
