package com.yidian.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, FragmentTestListener {

    private Button btn1,btn2,btn3;
    private TextView tv_title;
    private FrameLayout fl_1,fl_2,fl_3;
    private FragmentTransaction transaction;
    private BlankFragment1 fragment1;
    private BlankFragment2 fragment2;
    private BlankFragment3 fragment3;
    private BlankFragment4 fragment4;
    private BlankFragment5 fragment5;
    private BlankFragment6 fragment6;
    private BlankFragment7 fragment7;
    private BlankFragment8 fragment8;
    private BlankFragment9 fragment9;

    private FragmentLandFactory fragmentLandFactory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentLandFactory=new FragmentLandFactory(this);
        initView();
    }

    private void initView() {
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2) ;
        btn3= (Button) findViewById(R.id.btn3) ;
        tv_title= (TextView) findViewById(R.id.tv_title);
        fl_1= (FrameLayout) findViewById(R.id.fl_1);
        fl_2= (FrameLayout) findViewById(R.id.fl_2);
        fl_3= (FrameLayout) findViewById(R.id.fl_3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        fragment1=new BlankFragment1();
        fragment4=new BlankFragment4();
        fragment7=new BlankFragment7();

        fragment1.setListener(this);
        fragment4.setListener(this);
        fragment7.setListener(this);

        transaction=getFragmentManager().beginTransaction();
        transaction.add(R.id.fl_1,fragment1,"BlankFragment1");
        transaction.add(R.id.fl_2,fragment4,"BlankFragment4");
        transaction.add(R.id.fl_3,fragment7,"BlankFragment7");
        transaction.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                tv_title.setText("布局一");
                fl_1.setVisibility(View.VISIBLE);
                fl_2.setVisibility(View.GONE);
                fl_3.setVisibility(View.GONE);
                break;
            case R.id.btn2:
                tv_title.setText("布局二");
                fl_1.setVisibility(View.GONE);
                fl_2.setVisibility(View.VISIBLE);
                fl_3.setVisibility(View.GONE);
                break;
            case R.id.btn3:
                tv_title.setText("布局三");
                fl_1.setVisibility(View.GONE);
                fl_2.setVisibility(View.GONE);
                fl_3.setVisibility(View.VISIBLE);
                break;
        }


    }

    @Override
    public void onFragmentBack(Fragment startFragment, String endFragmentName, Bundle bundle) {
        transaction=getFragmentManager().beginTransaction();
        transaction.remove(startFragment);
        transaction.show(getFragmentManager().findFragmentByTag(endFragmentName));
        startFragment.onDestroy();
        transaction.commit();
    }

    @Override
    public void onFragmentAdd(Fragment startFragment, String endFragmentName, Bundle bundle) {
        transaction=getFragmentManager().beginTransaction();
        transaction.hide(startFragment);
        fragmentAddition(transaction,endFragmentName,bundle);
        transaction.commit();
    }

    private void fragmentAddition(FragmentTransaction transaction, String endFragmentName, Bundle bundle) {

        switch(endFragmentName){
            case "BlankFragment2":
                BlankFragment2 fragment2= (BlankFragment2) fragmentLandFactory.createFragment(endFragmentName);
                fragment2.setListener(MainActivity.this);
                transaction.add(R.id.fl_1,fragment2,endFragmentName);

                break;

            case "BlankFragment3":
                BlankFragment3 fragment3= (BlankFragment3) fragmentLandFactory.createFragment(endFragmentName);
                fragment3.setListener(MainActivity.this);
                transaction.add(R.id.fl_1,fragment3,endFragmentName);

                break;
            case "BlankFragment5":
                BlankFragment5 fragment5= (BlankFragment5) fragmentLandFactory.createFragment(endFragmentName);
                fragment5.setListener(MainActivity.this);
                transaction.add(R.id.fl_2,fragment5,endFragmentName);

                break;
            case "BlankFragment6":
                BlankFragment6 fragment6= (BlankFragment6) fragmentLandFactory.createFragment(endFragmentName);
                fragment6.setListener(MainActivity.this);
                transaction.add(R.id.fl_2,fragment6,endFragmentName);

                break;
            case "BlankFragment8":
                BlankFragment8 fragment8= (BlankFragment8) fragmentLandFactory.createFragment(endFragmentName);
                fragment8.setListener(MainActivity.this);
                transaction.add(R.id.fl_3,fragment8,endFragmentName);

                break;
            case "BlankFragment9":
                BlankFragment9 fragment9= (BlankFragment9) fragmentLandFactory.createFragment(endFragmentName);
                fragment9.setListener(MainActivity.this);
                transaction.add(R.id.fl_3,fragment9,endFragmentName);

                break;

        }

    }


}
