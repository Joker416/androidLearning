package com.example.punchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.clz.view.customtoolbar.CustomToolBar;

public class registerActivity extends AppCompatActivity {

    private static final String TAG = "registerActivity";

    private String realCode;
    private String inputCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        //配置标题栏
        CustomToolBar toolBar = findViewById(R.id.toolbar);
        toolBar.setTitle("注册");
        toolBar.setLeftOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(registerActivity.this,"Return", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //头像选择按钮
        Button iconButton = findViewById(R.id.iconButton);
        iconButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(registerActivity.this, iconChoiceActivity.class);
                startActivityForResult(intent, 0x11);
                Toast.makeText(registerActivity.this, "icon Changed", Toast.LENGTH_SHORT).show();
            }
        });
        setRoundIcon(R.drawable.images);
        //圆形图
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.images);
//        RoundedBitmapDrawable circleDrawable = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.images));
//        circleDrawable.getPaint().setAntiAlias(true);
//        circleDrawable.setCornerRadius(Math.max(bitmap.getWidth(), bitmap.getHeight()));
//        ImageView image3 = findViewById(R.id.iconView);
//        image3.setImageDrawable(circleDrawable);

        //注册按钮相关
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText captchaText = findViewById(R.id.codeText);
                EditText pwdText = findViewById(R.id.pwdText);
                EditText pwdCheckText = findViewById(R.id.checkPwdText);
                inputCode = captchaText.getText().toString().toLowerCase();
                String inputPwd = pwdText.getText().toString();
                String pwdCheck = pwdCheckText.getText().toString();
                if(inputCode.equals(realCode) && inputPwd.equals(pwdCheck)) {
                    Toast.makeText(registerActivity.this, "register succeed", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
//                    Log.d(TAG, "fuck realCode = " + realCode);
//                    Log.d(TAG, "fuck inputCode = " + inputCode);
                    if(!inputPwd.equals(pwdCheck))
                        Toast.makeText(registerActivity.this, "two different pwd", Toast.LENGTH_SHORT).show();
                    if(!inputCode.equals(realCode))
                        Toast.makeText(registerActivity.this, "wrong captcha", Toast.LENGTH_SHORT).show();
                    ImageView captchaView = findViewById(R.id.capthaView);
                    captchaView.setImageBitmap(Captcha.getInstance().createBitmap());
                    realCode = Captcha.getInstance().getCode();
                    captchaText.setText("");
                    pwdText.setText("");
                    pwdCheckText.setText("");
                }
            }
        });

        //验证码生成
        final ImageView captchaView = findViewById(R.id.capthaView);
        captchaView.setImageBitmap(Captcha.getInstance().createBitmap());
        realCode = Captcha.getInstance().getCode().toLowerCase();
        captchaView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                captchaView.setImageBitmap(Captcha.getInstance().createBitmap());
                realCode = Captcha.getInstance().getCode();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0x11:
                if(resultCode == RESULT_OK){
                    int imageId = data.getIntExtra("imageId", 0);
                    setRoundIcon(imageId);
                }
                break;
            default:
        }
    }

    //将imageView封装为圆形
    public void setRoundIcon(int imageId){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageId);
        RoundedBitmapDrawable circleDrawable = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), imageId));
        circleDrawable.getPaint().setAntiAlias(true);
        circleDrawable.setCornerRadius(Math.max(bitmap.getWidth(), bitmap.getHeight()));
        ImageView image3 = findViewById(R.id.iconView);
        image3.setImageDrawable(circleDrawable);
    }
}
