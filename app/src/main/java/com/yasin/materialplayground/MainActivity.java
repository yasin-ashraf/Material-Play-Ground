package com.yasin.materialplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.yasin.materialplayground.RoundedBottomSheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,BottomSheetDialog.OnOptionSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton roundedBottomSheet = findViewById(R.id.rounded_bottom_sheet);
        roundedBottomSheet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.rounded_bottom_sheet:
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
                bottomSheetDialog.show(getSupportFragmentManager(),BottomSheetDialog.class.getName());
                break;
        }
    }

    @Override
    public void OnOptionSelected(int option) {

    }
}
