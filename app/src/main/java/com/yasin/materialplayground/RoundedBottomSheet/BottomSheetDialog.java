package com.yasin.materialplayground.RoundedBottomSheet;

import android.app.Dialog;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yasin.materialplayground.R;


/**
 * Created by im_yasinashraf started on 5/3/19.
 */
public class BottomSheetDialog extends BottomSheetDialogFragment {

    private final int USE_CAMERA = 1;
    private final int USE_GALLERY = 2;
    private OnOptionSelectedListener onOptionSelectedListener;

    public BottomSheetDialog(OnOptionSelectedListener onOptionSelectedListener) {
        this.onOptionSelectedListener = onOptionSelectedListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public int getTheme() {
        return R.style.RoundedBottomSheetDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_options_bottom_sheet,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

        LinearLayout llUseCamera = view.findViewById(R.id.ll_use_camera);
        LinearLayout llUseGallery = view.findViewById(R.id.ll_use_gallery);
        llUseCamera.setOnClickListener(view1 -> {
            onOptionSelectedListener.OnOptionSelected(USE_CAMERA);
            dismiss();
        });
        llUseGallery.setOnClickListener(view1 -> {
            onOptionSelectedListener.OnOptionSelected(USE_GALLERY);
            dismiss();
        });
    }

    public interface OnOptionSelectedListener {

        void OnOptionSelected(int option);
    }
}
