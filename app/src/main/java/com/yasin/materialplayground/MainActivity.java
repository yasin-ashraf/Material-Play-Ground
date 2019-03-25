package com.yasin.materialplayground;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        applyWindowInsets();
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

    private void applyWindowInsets() {
        drawerLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        drawerLayout.setOnApplyWindowInsetsListener((view, windowInsets) -> {

            /*ViewGroup.MarginLayoutParams lpToolbar = (ViewGroup.MarginLayoutParams) toolbar
                    .getLayoutParams();
            lpToolbar.topMargin += windowInsets.getSystemWindowInsetTop();
            lpToolbar.leftMargin += windowInsets.getSystemWindowInsetLeft();
            lpToolbar.rightMargin += windowInsets.getSystemWindowInsetRight();
            toolbar.setLayoutParams(lpToolbar);*/

            // clear this listener so insets aren't re-applied
            drawerLayout.setOnApplyWindowInsetsListener(null);
            return windowInsets.consumeSystemWindowInsets();
        });
    }

}
