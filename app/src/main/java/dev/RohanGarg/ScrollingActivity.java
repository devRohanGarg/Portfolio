package dev.RohanGarg;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                finish();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            //drawerLayout.openDrawer(GravityCompat.START);

            Snackbar.make(findViewById(R.id.coordinator_layout), "Press again to exit", Snackbar.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Email: dev.RohanGarg@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("<3", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    public void display(int ID) {
        Toast.makeText(getApplicationContext(), "This button will launch " + getString(ID), Toast.LENGTH_SHORT).show();
    }

    public void onClickButton1(View view) {
        display(R.string.button_1);
    }

    public void onClickButton2(View view) {
        display(R.string.button_2);
    }

    public void onClickButton3(View view) {
        display(R.string.button_3);
    }

    public void onClickButton4(View view) {
        display(R.string.button_4);
    }

    public void onClickButton5(View view) {
        display(R.string.button_5);
    }

    public void onClickButton6(View view) {
        display(R.string.button_6);
    }
}
