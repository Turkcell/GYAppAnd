package com.turkcell.gelecegiyazanlar.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.splunk.mint.Mint;
import com.turkcell.curio.CurioClient;
import com.turkcell.gelecegiyazanlar.R;
import com.turkcell.gelecegiyazanlar.adapterlisteners.ListDrawerAdapter;
import com.turkcell.gelecegiyazanlar.configurations.GYConfiguration;
import com.turkcell.gelecegiyazanlar.databinding.ActivityMainBinding;
import com.turkcell.gelecegiyazanlar.fragments.BlogFragment;
import com.turkcell.gelecegiyazanlar.fragments.EgitimFragment;
import com.turkcell.gelecegiyazanlar.fragments.ElcilerFragment;
import com.turkcell.gelecegiyazanlar.fragments.EtkinlikFragment;
import com.turkcell.gelecegiyazanlar.models.DrawerItems;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    private static int save = -1;
    private Toolbar toolbar;
    private String mTitleString;
    private ArrayList<DrawerItems> drawerItemsArrayList = new ArrayList<>();
    TextView textView;
    private ActionBarDrawerToggle drawerToggle;
    private ListDrawerAdapter navigationDrawerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mTitleString=getResources().getString(R.string.sayfa_baslik_gelecegi_yazanlar);

        Mint.initAndStartSession(MainActivity.this, GYConfiguration.SPLUNK_ID);

        CurioClient.getInstance(this).getPushData(getIntent());

        CurioClient.getInstance(this).startSession();

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        textView = (TextView) findViewById(R.id.titleCenter);
        textView.setText(mTitleString);

        //Liste doldurma metodumuz
        Yukle();

        // Baþlangýç ekran fragmentý
        FragmentManager ft = getSupportFragmentManager();
        ft.beginTransaction()
                .replace(R.id.fragment, new EgitimFragment())
                .commit();

        //Menü Listesi Oluþturma

        navigationDrawerAdapter = new ListDrawerAdapter(drawerItemsArrayList);
        activityMainBinding.listViewLeftlist.setAdapter(navigationDrawerAdapter);
        initDrawer();

        GYConfiguration.checkInternetConnectionShowDialog(MainActivity.this);

        /**
         * liste itemlarýna týklanma ve geçiþ için kullanýlan kýsým.
         */
        activityMainBinding.listViewLeftlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                activityMainBinding.drawerLayout.closeDrawers();

                parent.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.drawer_secilen_renk));

                if (save != -1 && save != position) {
                    parent.getChildAt(save).setBackgroundColor(getResources().getColor(android.R.color.white));
                }

                save = position;

                FragmentManager ft = getSupportFragmentManager();
                switch (position) {
                    case 0:
                        mTitleString = getString(R.string.sayfa_baslik_egitim);

                        ft.beginTransaction()
                                .replace(R.id.fragment, new EgitimFragment())
                                .commit();
                        view.setBackgroundColor(getResources().getColor(R.color.drawer_secilen_renk));
                        break;
                    case 1:
                        mTitleString = getString(R.string.sayfa_baslik_blog);

                        ft.beginTransaction()
                                .replace(R.id.fragment, new BlogFragment())
                                .commit();
                        view.setBackgroundColor(getResources().getColor(R.color.drawer_secilen_renk));
                        break;
                    case 2:
                        mTitleString = getString(R.string.sayfa_baslik_etkinlik);

                        ft.beginTransaction()
                                .replace(R.id.fragment, new EtkinlikFragment())
                                .commit();
                        view.setBackgroundColor(getResources().getColor(R.color.drawer_secilen_renk));
                        break;
                    case 3:
                        mTitleString = getString(R.string.sayfa_baslik_gelistirici);

                        ft.beginTransaction()
                                .replace(R.id.fragment, new ElcilerFragment())
                                .commit();
                        view.setBackgroundColor(getResources().getColor(R.color.drawer_secilen_renk));
                        break;
                    default:
                        view.setBackgroundColor(getResources().getColor(android.R.color.white));
                        break;
                }
                textView.setText(mTitleString);
            }
        });
    }

    private void initDrawer() {

        drawerToggle = new ActionBarDrawerToggle(this, activityMainBinding.drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        activityMainBinding.drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this, AramaActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Liste elemanlarýný doldurduk.
     */
    public void Yukle() {
        drawerItemsArrayList.add(new DrawerItems(R.drawable.egitimicon, getString(R.string.sol_menu_egitim)));
        drawerItemsArrayList.add(new DrawerItems(R.drawable.blogicon, getString(R.string.sol_menu_blog)));
        drawerItemsArrayList.add(new DrawerItems(R.drawable.etkinlikicon, getString(R.string.sol_menu_etkinlik)));
        drawerItemsArrayList.add(new DrawerItems(R.drawable.gelistiriciicon, getString(R.string.sol_menu_gelistirici)));
    }

    @Override
    public void onBackPressed() {
        if (activityMainBinding.drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            activityMainBinding.drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onStart() {
        CurioClient.getInstance(getApplicationContext()).startScreen(MainActivity.this, "Eðitimler", "sample");

        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        CurioClient.getInstance(getApplicationContext()).endScreen(MainActivity.this);
        if (isFinishing()) {
            CurioClient.getInstance(this).endSession();
        }
    }


}
