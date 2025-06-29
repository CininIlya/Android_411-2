package com.example.fragmentmenuapplication2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar materialToolbar = findViewById(R.id.materialTollBar);
        setSupportActionBar(materialToolbar);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, materialToolbar, R.string.drawer_open, R.string.drawer_close);
                drawerLayout.addDrawerListener(toogle);

        replaceFragment(new FirstPage()); // первая страница

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.first_page) {
                    replaceFragment(new FirstPage());
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.second_page) {
                    replaceFragment(new SecondPage());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (item.getItemId() == R.id.third_page) {
                    replaceFragment(new ThirdPage());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (item.getItemId() == R.id.fourth_page) {
                    replaceFragment(new FouthPage());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });

    }
    // метод после нажатие на пкнкт меню

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit(); // переход на перевую страницу
    }

}