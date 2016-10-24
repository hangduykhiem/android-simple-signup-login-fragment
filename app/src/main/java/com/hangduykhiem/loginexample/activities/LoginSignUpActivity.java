package com.hangduykhiem.loginexample.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hangduykhiem.loginexample.R;
import com.hangduykhiem.loginexample.fragments.ChooseFragment;
import com.hangduykhiem.loginexample.fragments.LoginFragment;
import com.hangduykhiem.loginexample.fragments.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Starting Activity
 *
 * Created by hangduykhiem on 10/24/16.
 */
public class LoginSignUpActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private ChooseFragment chooseFragment;
    private LoginFragment loginFragment;
    private SignUpFragment signUpFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login_signup_layout);

        // Init fragments
        chooseFragment = new ChooseFragment();
        loginFragment = new LoginFragment();
        signUpFragment = new SignUpFragment();

        // Open chooseFragment in Login Activity
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.a_login_content, chooseFragment,
                chooseFragment.getClass().getName()).commit();
    }

    /**
     * Navigate to Login, duh
     */
    public void navigateToLogin() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        hideAllVisibleFragment(ft);
        if (!loginFragment.isAdded()){
            ft.add(R.id.a_login_content, loginFragment, loginFragment.getClass().getName());
        } else {
            ft.show(loginFragment);
        }
        ft.addToBackStack(null).commit();
    }

    /**
     * Navigate to SignUp, duh
     */
    public void navigateToSignUp() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        hideAllVisibleFragment(ft);
        if (!loginFragment.isAdded()){
            ft.add(R.id.a_login_content, signUpFragment , signUpFragment.getClass().getName());
        } else {
            ft.show(signUpFragment);
        }
        ft.addToBackStack(null).commit();
    }


    /**
     * Get All Visible Fragment
     * @return {@link List} of all visible {@link Fragment}
     */
    private List<Fragment> getVisibleFragments(){

        // We have 3 fragments, so initialize the arrayList to 3 to optimize memory
        List<Fragment> result = new ArrayList<>(3);

        // Add each visible fragment to the result
        if (chooseFragment.isVisible()){
            result.add(chooseFragment);
        }
        if (loginFragment.isVisible()){
            result.add(loginFragment);
        }
        if (signUpFragment.isVisible()){
            result.add(signUpFragment);
        }

        return result;
    }

    /**
     * Hide all visible fragment
     *
     * @return FragmentTransaction, so that the chain of FragmentTransaction can continue
     */
    private FragmentTransaction hideAllVisibleFragment(FragmentTransaction fragmentTransaction){
        for (Fragment fragment: getVisibleFragments()){
            fragmentTransaction.hide(fragment);
        }
        return fragmentTransaction;
    }
}
