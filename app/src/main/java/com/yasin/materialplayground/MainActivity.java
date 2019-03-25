package com.yasin.materialplayground;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.button.MaterialButton;
import com.yasin.materialplayground.RoundedBottomSheet.RoundedBottomSheetActivity;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private LinearLayout drawer;
    private MaterialButton buttonToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer);
        drawer = findViewById(R.id.menu);
        buttonToggle = findViewById(R.id.button_drawer_toggle);

        setupDrawer();
        buttonToggle.setOnClickListener(view -> drawerLayout.openDrawer(drawer));
        setupDrawerClicks();
    }

    private void setupDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.post(() -> drawerToggle.syncState());
    }

    private void setupDrawerClicks() {
        TextView roundedBottomSheet = findViewById(R.id.tv_rounded_bottom_sheet);
        roundedBottomSheet.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, RoundedBottomSheetActivity.class));
        });
    }
}
