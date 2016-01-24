package com.aai.arch;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import android.widget.Toast;


import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.mikepenz.materialdrawer.Drawer;


public class MainActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;

   // private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private Drawer result;//= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();
      //  mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        result = new DrawerBuilder()
                .withActivity(this)
                .withActionBarDrawerToggleAnimated(true)
                .withActionBarDrawerToggle(true)
                .withDisplayBelowStatusBar(false)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_todos)

                                .withIcon(FontAwesome.Icon.faw_list_ul)
                                .withIdentifier(1),
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_register)
                                .withIcon(FontAwesome.Icon.faw_user)
                                .withIconColor(ContextCompat.getColor(this, R.color.registrate))

                                .withTextColor(ContextCompat.getColor(this, R.color.registrate)),

                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_conectate)
                                .withIcon(FontAwesome.Icon.faw_lock)
                                .withIdentifier(2),
                        new DividerDrawerItem()

                )
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {

                        // Скрываем клавиатуру при открытии Navigation Drawer
                        InputMethodManager inputMethodManager = (InputMethodManager) MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(MainActivity.this.getCurrentFocus().getWindowToken(), 0);


                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                       // showToast("OH!");
                        return false;
                    }
                })
                .build();


        if (toolbar != null) {
            setSupportActionBar(toolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
                actionBar.setTitle("Main");
            }
        }

       // mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
       // mDrawer.setDrawerListener(mDrawerToggle);

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 6) {
                    //case 0:
                    //    return RecyclerViewFragment.newInstance();
                    //case 1:
                    //    return RecyclerViewFragment.newInstance();
                    //case 2:
                    //    return WebViewFragment.newInstance();
                    default:
                            return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 6) {
                    case 0:
                        return "Selection";
                    case 1:
                        return "Actualités";
                    case 2:
                        return "Professionnel";
                    case 3:
                        return "Divertissement";
                    case 4:
                        return "Spanish";
                    case 5:
                        return "Top";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.tab1,
                                getResources().getDrawable(R.drawable.h1, null),
                                getResources().getDrawable(R.drawable.l1, null));
                    case 1:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.tab2,
                                getResources().getDrawable(R.drawable.h2, null),
                                getResources().getDrawable(R.drawable.l2, null));
                    case 2:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.tab3,
                                getResources().getDrawable(R.drawable.h3, null),
                                getResources().getDrawable(R.drawable.l3, null));
                    case 3:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.tab4,
                                getResources().getDrawable(R.drawable.h4, null),
                                getResources().getDrawable(R.drawable.l4, null));
                    case 4:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.tab5,
                                getResources().getDrawable(R.drawable.h5, null),
                                getResources().getDrawable(R.drawable.l5, null));
                    case 5:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.tab6,
                                getResources().getDrawable(R.drawable.h5, null),
                                getResources().getDrawable(R.drawable.l5, null));
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //mDrawerToggle.syncState();
    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) ||
                super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // setupNavigationView(result);
            result.openDrawer();

        }

        return super.onOptionsItemSelected(item);
    }
}
