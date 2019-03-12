package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    Toolbar toolbar;

    FragmentHomepage homepage;
    FragmentCatalog catalog;
    FragmentCommunication communication;
    FragmentShop shop;

    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        manager=getSupportFragmentManager();

        homepage=new FragmentHomepage();
        catalog=new FragmentCatalog();
        communication=new FragmentCommunication();
        shop=new FragmentShop();

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this,ContentVideo.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_upload:
                startActivity(new Intent(MainActivity.this,ActivityUpload.class));
                break;
            case R.id.nav_favor:
                startActivity(new Intent(MainActivity.this,ActivityFavor.class));
                break;
            case R.id.nav_message:
                startActivity(new Intent(MainActivity.this,ActivityMessage.class));
                break;
            case R.id.nav_share:
                startActivity(new Intent(MainActivity.this,ActivityUpload.class));
                break;
            case R.id.nav_setting:
                startActivity(new Intent(MainActivity.this,ActivitySetting.class));
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction=manager.beginTransaction();
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("首页");
                    transaction.replace(R.id.fl_container,homepage);
                    transaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle("分类");
                    transaction.replace(R.id.fl_container,catalog);
                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    toolbar.setTitle("动态");
                    transaction.replace(R.id.fl_container,communication);
                    transaction.commit();
                    return true;
                case R.id.navigation_shop:
                    toolbar.setTitle("商城");
                    transaction.replace(R.id.fl_container,shop);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

}
