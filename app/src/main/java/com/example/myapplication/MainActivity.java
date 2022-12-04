package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button mBthLogin;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private ImageView ivSign;
    private ImageView ivLock;
    private ImageView ivDoor;
    private ImageView ivUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView设置内容视图
        //R.文件名表示引用文件夹中的文件
        setContentView(R.layout.activity_main);
        initView();
        initLogin();

    }
    //初始化
    private void initView(){
        ivSign=findViewById(R.id.img_main_sign);
        ivLock=findViewById(R.id.img_main_lock);
        ivDoor=findViewById(R.id.img_main_door);
        mBthLogin=findViewById(R.id.btn_main_login);
        mEtUsername=findViewById(R.id.editText1);
        mEtPassword=findViewById(R.id.editText2);
        ivUser=findViewById(R.id.img_main_user);
    }
    //登录
    private void initLogin(){
        mBthLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }

        });

    }
    //登录方法
    private void login (){
        String username=mEtUsername.getText().toString();
        String password=mEtPassword.getText().toString();
        String setUsername="123456";
        String setPassword="123456";
        if(username.equals(setUsername)&&password.equals(setPassword)){
            loginSuccess(username,password);
            Intent intent=new Intent(this,MainActivity2.class);
            startActivity(intent);

        }else{
            loginFailure();
        }
    }
    //登录成功
    private void loginSuccess(String username,String password){
        Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();

    }
    //登陆失败
    private void loginFailure(){
        Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
    }



//    //生成一个验证码
//    private static String getCode() {
//        //创建一个集合添加大写和小写字母
//        ArrayList<Character> list = new ArrayList<>();
//        for (int i = 0; i < 26; i++) {
//            list.add((char) ('a' + i));
//            list.add((char) ('A' + i));
//        }
//        StringBuilder sb=new StringBuilder();
//        Random r = new Random();
//        for (int i = 0; i < 4; i++) {
//            //获取随机索引
//            int getIndex = r.nextInt(list.size());
//            char c = list.get(getIndex);
//            sb.append(c);
//        }
//        //把一个随机数字添加到末尾
//        int number = r.nextInt(10);
//        sb.append(number);
//        //打乱数字和字母的顺序
//        //把字符串变为字符数组
//        char[] arr = sb.toString().toCharArray();
//        //把最后一个索引与随即索引交换位置
//        int randomIndex=r.nextInt(3);
//        char temp=arr[arr.length-1];
//        arr[arr.length-1]=arr[randomIndex];
//        arr[randomIndex]=temp;
//        //将arr转化为String并返回
//        return new String(arr);
//    }
}