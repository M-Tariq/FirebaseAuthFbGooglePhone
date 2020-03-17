package com.figuredin.firebaseauthfbgooglephone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    TextView userDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userDetails=findViewById(R.id.user_details);
    }

    public void signOutClick(View view) {
       FirebaseAuth.getInstance().signOut();
       startActivity(new Intent(this, MainActivity.class));
       finish();
    }

    public void showDetailsClick(View view) {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        userDetails.setText("NAme: "+ user.getDisplayName()+"\nEmail: "+user.getEmail()+"\nUid:"+user.getUid());
    }

}
