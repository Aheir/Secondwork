package com.example.experiment_3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button actBtn,anonBtn,tagBtn,inBtn,outBtn,bkBtn,cfgBtn,pgsBtn;
    private Context context = MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actBtn = findViewById(R.id.actL);
        anonBtn = findViewById(R.id.anonL);
        tagBtn = findViewById(R.id.tagL);
        inBtn = findViewById(R.id.inL);
        outBtn = findViewById(R.id.outL);
        bkBtn = findViewById(R.id.bkL);
        cfgBtn = findViewById(R.id.cfg);
        pgsBtn = findViewById(R.id.pgs);

        //Activity
        actBtn.setOnClickListener(this);

        //内部类
        InListener listener = new InListener();
        inBtn.setOnClickListener(listener);

        //匿名内部类
        anonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView textView = findViewById(R.id.txt);
                textView.setText("点击了采用匿名内部类的监听器");
            }
        });


        //外部类
        final TextView textView = findViewById(R.id.txt);
        outBtn.setOnClickListener(new OutClickListener(textView));

        //ButterKnife
        ButterKnife.bind(this);

        //系统信息
        cfgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ConfigurationTest.class);
                startActivity(intent);
            }
        });

        //进度条模拟
        pgsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProgressDialogTest.class);
                startActivity(intent);
            }
        });
    }

    //Activity
    public void onClick(View view) {
        final TextView textView = findViewById(R.id.txt);
        textView.setText("点击了采用Activity的监听器");
    }

    //绑定到标签
    public void tag(View view){
        TextView textView=findViewById(R.id.txt);
        textView.setText("点击了采用绑定到标签的监听器");
       }

    //内部类
    class InListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            final TextView textView = findViewById(R.id.txt);
            textView.setText("点击了采用内部类的监听器");
        }
    }

    //ButterKnife
    @OnClick(R.id.bkL)
    public void butterKnifeClick(){
        final TextView textView = findViewById(R.id.txt);
        textView.setText("点击了采用ButterKnife绑定的监听器");
    }
}

    //外部类
class OutClickListener implements View.OnClickListener{

    private TextView textView;

    OutClickListener(TextView textView){
        this.textView = textView;
    }

    @Override
    public void onClick(View view) {
        textView.setText("点击了采用外部类的监听器");
    }
}