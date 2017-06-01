package com.androidcamp.jobbies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class AddNewJobActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_job);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar_items, menu);

        try {
            String displayName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            String emailAddress = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            Uri pic_url = FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl();

            ImageView personImage = (ImageView) findViewById(R.id.personImage);
            Picasso.with(getApplicationContext()).load(pic_url).into(personImage);

            TextView personDisplayName = (TextView) findViewById(R.id.personDisplayNameTextView);
            personDisplayName.setText(displayName);

            TextView personEmailTextView = (TextView) findViewById(R.id.emailTextView);
            personEmailTextView.setText(emailAddress);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (id == R.id.find) {

            Intent MyOffersActivity = new Intent(AddNewJobActivity.this, ListActivity.class);
            startActivity(MyOffersActivity);
        }
        else if (user == null) {
            Intent AuthenticationActivity = new Intent(AddNewJobActivity.this, AuthenticationActivity.class);
            startActivity(AuthenticationActivity);
        } else if (id == R.id.offer) {
                //WE ARE ALREADY IN THIS ACTIVITY
                //Intent MyOffersActivity = new Intent(AddNewJobActivity.this, AddNewJobActivity.class);
                //startActivity(MyOffersActivity);
            } else if (id == R.id.account_settings) {
                // Handle the camera action
            } else if (id == R.id.my_offers) {
                Intent MyOffersActivity = new Intent(AddNewJobActivity.this, MyOffers.class);
                startActivity(MyOffersActivity);
            } else if (id == R.id.applicants) {

            } else if (id == R.id.my_applications) {
                Intent intent = new Intent(AddNewJobActivity.this, MyApplications.class);
                startActivity(intent);
            } else if (id == R.id.app_settings) {

            }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
            FirebaseNotificationHandler.getsInstance(AddNewJobActivity.this).
                    registerDatabaseListener(UserIDs.getsInstance().getCurrentUserId());
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
            FirebaseNotificationHandler.getsInstance(AddNewJobActivity.this).
                    unregisterDatabaseListener(UserIDs.getsInstance().getCurrentUserId());

    }
}
