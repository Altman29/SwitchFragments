package com.yidian.fragmenttest;

import android.app.Fragment;
import android.content.Context;

/**
 * Created by bmc on 2017/11/23.
 */

public class FragmentLandFactory {

    private Context mContext;
    public FragmentLandFactory(Context mContext) {
        this.mContext = mContext;
    }

    public Fragment createFragment(String fragmentName){

        Fragment fragment = null;
        switch(fragmentName){
            case "BlankFragment2":
                fragment= new BlankFragment2();

                break;
            case "BlankFragment3":
                fragment= new BlankFragment3();

                break;
            case "BlankFragment5":
                fragment= new BlankFragment5();

                break;
            case "BlankFragment6":
                fragment= new BlankFragment6();

                break;
            case "BlankFragment8":
                fragment= new BlankFragment8();

                break;
            case "BlankFragment9":
                fragment= new BlankFragment9();

                break;

        }
        return fragment;
    }




}
