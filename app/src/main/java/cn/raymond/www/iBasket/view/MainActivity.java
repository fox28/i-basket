package cn.raymond.www.iBasket.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import cn.raymond.www.iBasket.R;
import cn.raymond.www.iBasket.model.utils.MFGT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSkip(View view) {
        MFGT.startActivity(MainActivity.this, TestActivity.class);// 左面进入，右面退出——整体右滑动
    }

    public void onClick(View view) {

    }
}
