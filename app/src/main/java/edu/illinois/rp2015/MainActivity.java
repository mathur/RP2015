package edu.illinois.rp2015;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import edu.illinois.rp2015.adapters.SpeakersAdapter;
import edu.illinois.rp2015.fragments.AboutFragment;
import edu.illinois.rp2015.fragments.FAQFragment;
import edu.illinois.rp2015.fragments.HomeFragment;
import edu.illinois.rp2015.fragments.MapsFragment;
import edu.illinois.rp2015.fragments.ScheduleFragment;
import edu.illinois.rp2015.fragments.SpeakersFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    public static double width;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            navigationView = (NavigationView) findViewById(R.id.navigation_view);
            if(!navigationView.getMenu().getItem(0).isChecked() && !drawerLayout.isDrawerOpen(Gravity.LEFT)){
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        width = displaymetrics.widthPixels;

        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if(menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()){
                    case R.id.about:
                        AboutFragment aboutFragment = new AboutFragment();
                        FragmentTransaction aboutFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        aboutFragmentTransaction.replace(R.id.frame, aboutFragment);
                        aboutFragmentTransaction.commit();
                        return true;
                    case R.id.schedule:
                        ScheduleFragment scheduleFragment = new ScheduleFragment();
                        FragmentTransaction scheduleFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        scheduleFragmentTransaction.replace(R.id.frame, scheduleFragment);
                        scheduleFragmentTransaction.commit();
                        return true;
                    case R.id.faq:
                        FAQFragment faqFragment = new FAQFragment();
                        FragmentTransaction faqFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        faqFragmentTransaction.replace(R.id.frame, faqFragment);
                        faqFragmentTransaction.commit();
                        return true;
                    case R.id.speakers:
                        SpeakersFragment speakersFragment = new SpeakersFragment();
                        FragmentTransaction speakerFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        speakerFragmentTransaction.replace(R.id.frame, speakersFragment);
                        speakerFragmentTransaction.commit();
                        return true;
                    case R.id.maps:
                        MapsFragment mapsFragment = new MapsFragment();
                        FragmentTransaction mapsFragmentTransaction = getSupportFragmentManager().beginTransaction();
                        mapsFragmentTransaction.replace(R.id.frame, mapsFragment);
                        mapsFragmentTransaction.commit();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(),"Something went wrong!",Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onResume() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        super.onResume();
    }
}
