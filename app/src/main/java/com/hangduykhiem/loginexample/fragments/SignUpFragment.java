package com.hangduykhiem.loginexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hangduykhiem.loginexample.R;

/**
 * Fragment to do SignUp
 *
 * Created by hangduykhiem on 10/24/16.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener{

    Button signUpButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_sign_up_layout, container, false);
        signUpButton = (Button) v.findViewById(R.id.f_signUp_button);
        return v;
    }


    @Override
    public void onClick(View view) {
        //TODO: implement login logic here
    }
}
