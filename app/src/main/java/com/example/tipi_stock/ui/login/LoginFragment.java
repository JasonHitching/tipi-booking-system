package com.example.tipi_stock.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tipi_stock.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginFragment extends Fragment {

    View rootView;
    private FirebaseAuth firebaseAuthenticator;
    TextInputLayout emailTextLayout, passwordTextLayout;
    private Button loginButton, registerButton;


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = inflater.inflate(R.layout.login_fragment, null);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        firebaseAuthenticator = FirebaseAuth.getInstance();
        loginButton = rootView.findViewById(R.id.login_button);
        registerButton = rootView.findViewById(R.id.register_button);
        emailTextLayout = rootView.findViewById(R.id.login_email_text);
        passwordTextLayout = rootView.findViewById(R.id.password_text_field);



        registerButton.setOnClickListener(registerView -> {
            NavHostFragment.findNavController(this).navigate(
                    R.id.action_loginFragment_to_registerFragment);
        });

        loginButton.setOnClickListener(loginView -> {
            String passwordText = passwordTextLayout.getEditText().getText().toString();
            String emailText = emailTextLayout.getEditText().getText().toString();
            userSignIn(emailText, passwordText);
        });
    }

    /**
     * Method that uses the firebase services to confirm user inputted credentials
     * @param userEmail
     * @param userPassword
     */
    private void userSignIn(String userEmail, String userPassword) {
        firebaseAuthenticator.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(requireActivity(), (OnCompleteListener<AuthResult>) task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = firebaseAuthenticator.getCurrentUser();
                        // Update UI
                    } else {
                        Toast.makeText(getActivity(), "Credentials didn't match, try again or register!",
                                Toast.LENGTH_SHORT).show();
                        //Update UI
                    }
                });
    }
}
