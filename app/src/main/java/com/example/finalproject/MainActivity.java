package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.finalproject.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new homeFragment());

        binding.bottomNav.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new homeFragment());
                    break;
                case R.id.announcement:
                    replaceFragment(new announcementFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new profileFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new settingsFragment());
                    break;
                case R.id.bottom_concern:
                    replaceFragment(new concernFragment());
                    break;
            }

            return true;
        });

        bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setBackground(null);
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
}