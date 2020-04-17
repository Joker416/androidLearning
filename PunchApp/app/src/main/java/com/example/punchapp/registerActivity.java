package com.example.punchapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
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
//                Toast.makeText(registerActivity.this,"Return", Toast.LENGTH_SHORT).show();
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
        final Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText captchaText = findViewById(R.id.codeText);
                EditText pwdText = findViewById(R.id.pwdText);
                EditText pwdCheckText = findViewById(R.id.checkPwdText);
                RadioButton teacher = findViewById(R.id.teacherRegBtn);
                RadioButton student = findViewById(R.id.studentRegBtn);
                inputCode = captchaText.getText().toString().toLowerCase();
                String inputPwd = pwdText.getText().toString();
                String pwdCheck = pwdCheckText.getText().toString();
                String trueCode = realCode.toLowerCase();
                if(inputCode.equals(trueCode) && inputPwd.equals(pwdCheck)) {
                    if(!teacher.isChecked() && !student.isChecked()){
                        Toast.makeText(registerActivity.this, "请选择您的身份", Toast.LENGTH_SHORT).show();
                    }
                    else if(teacher.isChecked() && !student.isChecked()){
                        codeDialogCreate();
                    }
                    else{
                        Toast.makeText(registerActivity.this, "学生注册成功", Toast.LENGTH_SHORT).show();
                        finish();

                    }
//                    Toast.makeText(registerActivity.this, "register succeed", Toast.LENGTH_SHORT).show();
                }
                else{
//                    Log.d(TAG, "fuck realCode = " + realCode);
//                    Log.d(TAG, "fuck inputCode = " + inputCode);
                    if(!inputPwd.equals(pwdCheck))
                        Toast.makeText(registerActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    if(!inputCode.equals(realCode))
                        Toast.makeText(registerActivity.this, "验证码输入错误", Toast.LENGTH_SHORT).show();
                    recreateCaptcha();
                    pwdText.setText("");
                    pwdCheckText.setText("");
                }
            }
        });

        //验证码生成
        createCaptcha();

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

    public void codeDialogCreate(){
        final EditText et = new EditText(this);
        et.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        new AlertDialog.Builder(this).setTitle("请输入教师专用码")
                .setIcon(android.R.drawable.ic_dialog_email)
                .setView(et)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String input = et.getText().toString();
                        if (input.equals("")) {
                            Toast.makeText(getApplicationContext(), "请输入教师专用码" + input, Toast.LENGTH_LONG).show();
                            recreateCaptcha();
                        }
                        else if(input.equals("123456")){
                            Toast.makeText(registerActivity.this, "教师注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(registerActivity.this, "专用码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }


    //验证码生成
    public void createCaptcha(){
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

    //重置验证码
    public void recreateCaptcha(){
        createCaptcha();
        EditText captchaInput = findViewById(R.id.codeText);
        captchaInput.setText("");
    }

}
