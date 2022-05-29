package com.example.wochenendeplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import Model.SaveInDb;


public class MainActivity extends AppCompatActivity {
        private GoogleSignInClient mGoogleSignInClient;
        private FirebaseAuth firebaseAuth;
        private SignInButton googleSignIn;
        private static final String TAG = "GoogleActivity";
        private int RC_SIGN_UP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)) //web_client_id kommt automatisch von Google Konto
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        googleSignIn = findViewById(R.id.sign_in_button);
        googleSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signUp();
            }
            private void signUp() {

                Log.i(TAG, "signUp__: ");
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                //TODO
                startActivityForResult(signInIntent,RC_SIGN_UP);
            }
        });
        Log.d("Database","I'm here!");
        SaveInDb save = new SaveInDb();
        save.saveData();
        Log.d("Database","Congratulation! You write in the DB, maybe");
        }
    @Override
    public void onActivityResult(int getCode, int endCode, @Nullable Intent data){
        super.onActivityResult(getCode, endCode, data);
        //Google Sign Up
        if(getCode == RC_SIGN_UP)
        {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        handleSignUpResult(task);
        }
    }

    private void handleSignUpResult(Task<GoogleSignInAccount> myCompletedTask) {
        try {
        GoogleSignInAccount account = myCompletedTask.getResult(ApiException.class);
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
        FirebaseGoogleAuth(account);
        } catch (ApiException e) {
        Toast.makeText(MainActivity.this,"Sign In Failed",Toast.LENGTH_SHORT).show();
        FirebaseGoogleAuth(null);
        Log.w(TAG, "Google sign in failed", e);
        }

        }

    private void FirebaseGoogleAuth(GoogleSignInAccount myAccount) {
        //check if account is null
        if (myAccount != null)
        {
            AuthCredential myAuthCredential = GoogleAuthProvider.getCredential(myAccount.getIdToken(), null);
            firebaseAuth.signInWithCredential(myAuthCredential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Log.d(TAG, "signInWithCredential:success");
                            Toast.makeText(MainActivity.this, "Authentication Succesful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, Home.class));
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                            FirebaseUser mUser = firebaseAuth.getCurrentUser();
                            updateUI(mUser);
                            }
                    }
                }
            );
        }
        else{
        Toast.makeText(MainActivity.this, "acc failed", Toast.LENGTH_SHORT).show();
        }
        }

    private void updateUI(FirebaseUser firebaseUser) {
        GoogleSignInAccount mAccount = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (mAccount != null) {
            String mPersonName = mAccount.getDisplayName();
            String mPersonEmail = mAccount.getEmail();
        }
    }
}
