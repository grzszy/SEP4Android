package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mainactivity.View.SectionsPagerAdapter;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {


    /**
     * @author Jakob Hansen
     */
    Toolbar toolbar;
    View view;

    /**
     *  onCreate instantiate the tablayout and viewpager
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        checkIfSignedIn();


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
               signOut(view);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Method for Google firebase to check if the user is signed in
     */

    private void checkIfSignedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null)
            Toast.makeText(this, "Welcome ", Toast.LENGTH_SHORT).show();
        else
            startLoginActivity();
    }

    /**
     * Method to start the current activity
     */

    private void startLoginActivity() {
        startActivity(new Intent(this, SignIn.class));
        finish();
    }

    /**
     * Method to logout of application
     * @param v takes the view for logout
     */

    public void signOut(View v) {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        startLoginActivity();
                    }
                });
    }
}