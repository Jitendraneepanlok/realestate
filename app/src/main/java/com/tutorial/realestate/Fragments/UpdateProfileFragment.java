package com.tutorial.realestate.Fragments;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.tutorial.realestate.Interface.ApiClient;
import com.tutorial.realestate.Interface.ApiInterface;
import com.tutorial.realestate.Model.ChangePassConstant;
import com.tutorial.realestate.Model.ChangePasswordModel;
import com.tutorial.realestate.Model.UpdateProfileConstantModel;
import com.tutorial.realestate.Model.UpdateProfileModel;
import com.tutorial.realestate.Pojo.ChangePassContantPojo;
import com.tutorial.realestate.Pojo.UpdateProfileContant;
import com.tutorial.realestate.Prefrences.SessionManager;
import com.tutorial.realestate.R;
import com.tutorial.realestate.Utiles.Utility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;

import static android.app.Activity.RESULT_OK;

public class UpdateProfileFragment extends Fragment {
    private NavController navController;
    EditText etfirstname, etlastname, etemail_id, etaddress, etpostal, etphone;
    String FirstName, LastName, Email, Address, Postal, Phoneno;
    LinearLayout btn_update;
    CircleImageView ivprofile;
    View view;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private String userChoosenTask;
    private ProgressDialog pDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_update_profile, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        initView();

        return view;
    }

    private void initView() {
        ivprofile = (CircleImageView)view.findViewById(R.id.ivprofile);
        ivprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        etfirstname = (EditText) view.findViewById(R.id.etfirstname);
        etlastname = (EditText) view.findViewById(R.id.etlastname);
        etemail_id = (EditText) view.findViewById(R.id.etemail_id);
        etaddress = (EditText) view.findViewById(R.id.etaddress);
        etpostal = (EditText) view.findViewById(R.id.etpostal);
        etphone = (EditText) view.findViewById(R.id.etphone);
        btn_update = (LinearLayout) view.findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validation();
            }
        });
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library", "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(getActivity());
                if (items[item].equals("Take Photo")) {
                    userChoosenTask ="Take Photo";
                    if(result)
                        checkPermission();
                       // cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask ="Choose from Library";
                    if(result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();

    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CAMERA}, 5);
        } else {
            cameraIntent();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivprofile.setImageBitmap(thumbnail);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ivprofile.setImageBitmap(bm);
    }

    private void Validation() {
        FirstName = etfirstname.getText().toString().trim();
        LastName = etlastname.getText().toString().trim();
        Email = etemail_id.getText().toString().trim();
        Address = etaddress.getText().toString().trim();
        Postal = etpostal.getText().toString().trim();
        Phoneno = etphone.getText().toString().trim();

        if (!FirstName.equals("")){
            if (!LastName.equals("")){
                if (!Email.equals("")){
                    if (!Address.equals("")){
                        if (!Postal.equals("")){
                            if (!Phoneno.equals("")){
                                UpdateProfileApi();
                            }else {
                                etphone.setError("Enter your Phone no. ");
                            }
                        }else {
                            etpostal.setError("Enter your Postal Code");
                        }
                    }else {
                        etaddress.setError("Enter your Address");
                    }
                }else {
                    etemail_id.setError("Enter your email-id");
                }
            }else {
                etlastname.setError("Enter your last Name");
            }
        }else {
            etfirstname.setError("Enter your first Name");
        }

    }

    private void UpdateProfileApi() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        SessionManager sessionManager = new SessionManager(getActivity());
        String UID = sessionManager.getUserData(SessionManager.UID);

        UpdateProfileModel updateProfileModel= new UpdateProfileModel();
        updateProfileModel.setProfileName(FirstName);
        updateProfileModel.setuID(UID);
        updateProfileModel.setCityId(Postal);
        updateProfileModel.setContactCountryCode("+91");
        updateProfileModel.setCountryId("");
        updateProfileModel.setProfileBusinessAddress(Address);
        updateProfileModel.setProfileBusinessTitle(Email);
        updateProfileModel.setProfileContact(Phoneno);
        updateProfileModel.setProfileUseras(LastName);
        updateProfileModel.setStateId("");



        UpdateProfileConstantModel updateProfileConstantModel = new UpdateProfileConstantModel();
        updateProfileConstantModel.setRealstate(updateProfileModel);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UpdateProfileContant> call = apiService.postUpdateProfile(updateProfileConstantModel);
        try {
            call.enqueue(new Callback<UpdateProfileContant>() {
                @Override
                public void onResponse(Call<UpdateProfileContant> call, retrofit2.Response<UpdateProfileContant> response) {
                    if (response.isSuccessful()) {
                        Log.e("Response", "" + response.body().toString());
                        Toast.makeText(getActivity(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();

                       /* etoldpass.setText("");
                        etnewpass.setText("");*/

                        pDialog.dismiss();
                    } else {
                        Toast.makeText(getActivity(), response.body().getRealstate().getResponse(), Toast.LENGTH_SHORT).show();
                        pDialog.cancel();
                    }
                }

                @Override
                public void onFailure(Call<UpdateProfileContant> call, Throwable t) {
                    // Log error here since request failed
                    Toast.makeText(getActivity(), "" + t, Toast.LENGTH_SHORT).show();
                    Log.e("Failer", "" + t);
                    pDialog.dismiss();
                }
            });
        } catch (Exception ex) {
            Log.e("LoginFailer", "" + ex);
            Toast.makeText(getActivity(), "" + ex, Toast.LENGTH_SHORT).show();
            pDialog.dismiss();
        }
    }


}
