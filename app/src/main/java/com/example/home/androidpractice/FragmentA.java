package com.example.home.androidpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jrodriguez on 29/05/17.
 */

public class FragmentA extends Fragment {

    private Button button;
    private TextView textView;
    int score;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            score = savedInstanceState.getInt("score_key", 0);
        }

        Toast.makeText(getActivity(), "Score value: " + score, Toast.LENGTH_LONG).show();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        button = (Button) view.findViewById(R.id.button);
        textView = (TextView) view.findViewById(R.id.textView);

        if(savedInstanceState != null){
            textView.setText(savedInstanceState.getString("txt_key"));
            button.setText(savedInstanceState.getString("btn_key", "LOGIN"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText("Dummy Text");
                button.setText("LOGOUT");

                score = 47;
                Toast.makeText(getActivity(), "Score: " + score, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("score_key", score);
        outState.putString("txt_key", textView.getText().toString());
        outState.putString("btn_key", button.getText().toString());
    }
}
