package com.hangduykhiem.loginexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.hangduykhiem.loginexample.R;
import com.hangduykhiem.loginexample.activities.LoginSignUpActivity;

/**
 * Fragment to choose sign in or login
 *
 * Created by hangduykhiem on 10/24/16.
 */

public class ChooseFragment extends Fragment implements OnClickListener {

    private Button signUpButton;
    private Button logInButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_choose_layout, container, false);
        logInButton = (Button) v.findViewById(R.id.f_choose_log_in);
        logInButton.setOnClickListener(this);
        signUpButton = (Button) v.findViewById(R.id.f_choose_sign_up);
        signUpButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == logInButton.getId()) {
            ((LoginSignUpActivity) getActivity()).navigateToLogin();
        } else if (view.getId() == signUpButton.getId()) {
            ((LoginSignUpActivity) getActivity()).navigateToSignUp();
        }
    }
}
