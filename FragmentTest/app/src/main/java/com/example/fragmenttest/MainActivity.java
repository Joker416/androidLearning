package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int btn_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
//        replaceFragment(new RightFragment());
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                if(btn_count == 0) {
                    ++btn_count;
//                    replaceFragment(new AnotherRightFragment());
                }
                else if(btn_count == 1){
                    --btn_count;
//                    replaceFragment(new RightFragment());
                }
                break;
            default:
                break;
        }
    }

//    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.right_layout, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
