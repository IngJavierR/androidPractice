package com.example.home.androidpractice;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HomeActivity extends AppCompatActivity  implements FragmentManager.OnBackStackChangedListener{

    FragmentManager manager;
    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        manager = getFragmentManager();
        manager.addOnBackStackChangedListener(this);
    }

    public void addFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("AddFragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.addToBackStack("RemFragA");
            transaction.commit();
        }
    }

    public void addFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("AddFragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {

        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.addToBackStack("RemFragB");
            transaction.commit();
        }
    }

    public void replaceByFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("RepByFragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("RepByFragB");
        transaction.commit();
    }

    public void attachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.addToBackStack("AttachFragA");
            transaction.commit();
        }
    }

    public void detachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.addToBackStack("DetachFragA");
            transaction.commit();
        }
    }

    public void showFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentA != null) {
            transaction.show(fragmentA);
            transaction.addToBackStack("ShowFragA");
            transaction.commit();
        }
    }

    public void hideFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentA != null) {
            transaction.hide(fragmentA);
            transaction.addToBackStack("HideFragA");
            transaction.commit();
        }
    }

    public void dummyBackButtonClick(View view) {
        manager.popBackStack();
    }

    public void pop_AddFragA_Inclusive_Transaction(View view) {
        manager.popBackStack("AddFragA", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void pop_AddFragB_Transaction(View view) {
        manager.popBackStack("AddFragB", 0);
    }

    @Override
    public void onBackStackChanged() {

        int length = manager.getBackStackEntryCount();

        StringBuilder msg = new StringBuilder("");

        for(int i = length - 1; i >= 0; i--){
            msg.append("Index ").append(i).append(" : ");
            msg.append(manager.getBackStackEntryAt(i).getName());
            msg.append(" \n");
        }
        Log.i(TAG, "\n" + msg.toString() + "\n");
    }

    @Override
    public void onBackPressed() {

        if(manager.getBackStackEntryCount() > 0){
            manager.popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
