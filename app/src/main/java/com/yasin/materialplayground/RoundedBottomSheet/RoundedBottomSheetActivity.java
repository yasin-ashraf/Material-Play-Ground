package com.yasin.materialplayground.RoundedBottomSheet;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.yasin.materialplayground.R;

/**
 * Created by im_yasinashraf started on 20/3/19.
 */
public class RoundedBottomSheetActivity extends AppCompatActivity implements View.OnClickListener,BottomSheetDialog.OnOptionSelectedListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounded_bottom_sheet);

        MaterialButton roundedBottomSheet = findViewById(R.id.rounded_bottom_sheet);
        roundedBottomSheet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.rounded_bottom_sheet) {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.show(getSupportFragmentManager(), BottomSheetDialog.class.getName());
        }

    }

    @Override
    public void OnOptionSelected(int option) {

    }
}
