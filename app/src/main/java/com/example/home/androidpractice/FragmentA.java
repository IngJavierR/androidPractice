package com.example.home.androidpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jrodriguez on 29/05/17.
 */

public class FragmentA extends Fragment {

    private Button btnAdd;
    private TextView txtResult;

    private int firstNumber = 0, secondNumber = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        /*Bundle bundle = getArguments();
        final int firtsNum = bundle.getInt(Constants.FIRST_NUM, 0);
        final int secondNum = bundle.getInt(Constants.SECOND_NUM, 0);*/

        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        txtResult = (TextView) view.findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTwoNumbers(firstNumber, secondNumber);
            }
        });
        return view;
    }

    private void addTwoNumbers(int firtsNum, int secondNum) {
        int result = firtsNum + secondNum;
        txtResult.setText("Result: " + result);
    }

    public void setData(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
}
