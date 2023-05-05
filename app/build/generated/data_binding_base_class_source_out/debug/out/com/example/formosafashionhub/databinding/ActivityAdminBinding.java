// Generated by view binder compiler. Do not edit!
package com.example.formosafashionhub.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.formosafashionhub.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdminBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button BtnSave;

  @NonNull
  public final Button BtnUpdate;

  @NonNull
  public final ImageView ItemimageView;

  @NonNull
  public final EditText mEdtDescription;

  @NonNull
  public final EditText mEdtItemName;

  @NonNull
  public final EditText mEdtPrice;

  private ActivityAdminBinding(@NonNull ConstraintLayout rootView, @NonNull Button BtnSave,
      @NonNull Button BtnUpdate, @NonNull ImageView ItemimageView,
      @NonNull EditText mEdtDescription, @NonNull EditText mEdtItemName,
      @NonNull EditText mEdtPrice) {
    this.rootView = rootView;
    this.BtnSave = BtnSave;
    this.BtnUpdate = BtnUpdate;
    this.ItemimageView = ItemimageView;
    this.mEdtDescription = mEdtDescription;
    this.mEdtItemName = mEdtItemName;
    this.mEdtPrice = mEdtPrice;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.BtnSave;
      Button BtnSave = ViewBindings.findChildViewById(rootView, id);
      if (BtnSave == null) {
        break missingId;
      }

      id = R.id.BtnUpdate;
      Button BtnUpdate = ViewBindings.findChildViewById(rootView, id);
      if (BtnUpdate == null) {
        break missingId;
      }

      id = R.id.ItemimageView;
      ImageView ItemimageView = ViewBindings.findChildViewById(rootView, id);
      if (ItemimageView == null) {
        break missingId;
      }

      id = R.id.mEdtDescription;
      EditText mEdtDescription = ViewBindings.findChildViewById(rootView, id);
      if (mEdtDescription == null) {
        break missingId;
      }

      id = R.id.mEdtItemName;
      EditText mEdtItemName = ViewBindings.findChildViewById(rootView, id);
      if (mEdtItemName == null) {
        break missingId;
      }

      id = R.id.mEdtPrice;
      EditText mEdtPrice = ViewBindings.findChildViewById(rootView, id);
      if (mEdtPrice == null) {
        break missingId;
      }

      return new ActivityAdminBinding((ConstraintLayout) rootView, BtnSave, BtnUpdate,
          ItemimageView, mEdtDescription, mEdtItemName, mEdtPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
