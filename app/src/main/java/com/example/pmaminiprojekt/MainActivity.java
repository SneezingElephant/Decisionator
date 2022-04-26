package com.example.pmaminiprojekt;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pmaminiprojekt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    public static String wheelInput1 = "", wheelInput2 = "", wheelInput3 = "", wheelInput4 = "", wheelInput5 = "", wheelInput6 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public String getWheelInput1() {
        return wheelInput1;
    }

    public String getWheelInput2() {
        return wheelInput2;
    }

    public String getWheelInput3() {
        return wheelInput3;
    }

    public String getWheelInput4() {
        return wheelInput4;
    }

    public String getWheelInput5() {
        return wheelInput5;
    }

    public String getWheelInput6() {
        return wheelInput6;
    }

    public void setWheelInput1(String wheelInput1) {
        this.wheelInput1 = wheelInput1;
    }

    public void setWheelInput2(String wheelInput2) {
        this.wheelInput2 = wheelInput2;
    }

    public void setWheelInput3(String wheelInput3) {
        this.wheelInput3 = wheelInput3;
    }

    public void setWheelInput4(String wheelInput4) {
        this.wheelInput4 = wheelInput4;
    }

    public void setWheelInput5(String wheelInput5) {
        this.wheelInput5 = wheelInput5;
    }

    public void setWheelInput6(String wheelInput6) {
        this.wheelInput6 = wheelInput6;
    }
}