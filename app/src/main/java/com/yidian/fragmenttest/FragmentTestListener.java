package com.yidian.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by bmc on 2017/11/23.
 */

public interface FragmentTestListener {

    public void onFragmentBack(Fragment startFragment, String endFragemntName, Bundle bundle);
    public void onFragmentAdd(Fragment startFragment, String endFragmentName, Bundle bundle);


}
