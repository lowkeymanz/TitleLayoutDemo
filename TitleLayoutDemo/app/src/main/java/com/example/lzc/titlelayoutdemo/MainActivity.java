package com.example.lzc.titlelayoutdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.lzc.titlelayoutdemo.view.TitleLayout;
import com.githang.statusbar.StatusBarCompat;

/**
 * 类描述：测试类
 * 创建人：zz
 * 创建时间：2017/2/21 16:27
 */
public class MainActivity extends AppCompatActivity {

    private TitleLayout titleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.setStatusBarColor(this, android.R.color.holo_red_light, true);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        titleLayout = ((TitleLayout) findViewById(R.id.titlelayout_id));
        titleLayout.setOnClickListener(TitleLayout.LEFT_MENU, new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击了左侧",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
