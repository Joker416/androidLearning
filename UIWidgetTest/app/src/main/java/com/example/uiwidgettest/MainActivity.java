package com.example.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_text;
    private ImageView imageView;
    private ProgressBar progressBar;
    private int img_number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button button = findViewById(R.id.button);
//        edit_text = findViewById(R.id.edit_text);
//        imageView = findViewById(R.id.image_view);
//        progressBar = findViewById(R.id.progress_bar);
//        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Wanna change the img?");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(img_number == 0) {
                            ++img_number;
                            imageView.setImageResource(R.drawable.img_2);
                        }
                        else{
                            --img_number;
                            imageView.setImageResource(R.drawable.img_1);
                        }
                    }
                });
                dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edit_text.setText("Sorry");
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }
}
