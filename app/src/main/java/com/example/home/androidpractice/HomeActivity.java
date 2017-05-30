package com.example.home.androidpractice;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements MyListener{

    FragmentManager manager;
    private int firstNum, secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        manager = getFragmentManager();
        addFragmentA();
        addFragmentB();
    }

    private void addFragmentA() {

        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();
    }

    private void addFragmentB() {

        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentB, fragmentB, "fragB");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int num1, int num2) {
        this.firstNum = num1;
        this.secondNum = num2;
    }

    public void sendDataToFragmentB(View view) {

        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        fragmentB.addTwoNumbersInFragmentB(firstNum, secondNum);
    }
}
