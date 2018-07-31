package com.borisruzanov.russianwives.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.borisruzanov.russianwives.R;
import com.borisruzanov.russianwives.zHOLD.StatusActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileSettingsActivity extends AppCompatActivity {
//
//    private DatabaseReference mUserDatabase;
//    private FirebaseUser mCurrentUser;


    //Android Layout

//    private CircleImageView mDisplayImage;
//    private TextView mName;
//    private TextView mStatus;
//
//    private Button mStatusBtn;
//    private Button mImageBtn;

    LinearLayout image;
    TextView tvName;
    TextView tvStatus;
    TextView tvVisitorsCount;
    TextView tvLikesCount;
    Button btnGetMoreLikes;
    TextView tvStaticAbout;
    ListView listSettings;
    TextView tvStaticYouMayAlsoLike;
    //TODO Add recyclerView


//
//    private static final int GALLERY_PICK = 1;
//
//    // Storage Firebase
//    private StorageReference mImageStorage;
//
//    private ProgressDialog mProgressDialog;
//
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        image = (LinearLayout)findViewById(R.id.profile_settings_linear_image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeImage = new Intent(ProfileSettingsActivity.this, EditUserInfo.class);
                startActivity(changeImage);
            }
        });

//        imgImage = (CircleImageView) findViewById(R.id.settings_image);
//        mName = (TextView) findViewById(R.id.settings_tv_display_name);
//        mStatus = (TextView) findViewById(R.id.settings_tv_status);
//
//        mStatusBtn = (Button) findViewById(R.id.settings_status_btn);
//        mImageBtn = (Button) findViewById(R.id.settings_image_btn);
//
//        mImageStorage = FirebaseStorage.getInstance().getReference();
//
//        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
//
//        String current_uid = mCurrentUser.getUid();
//
//
//
//        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);
//        mUserDatabase.keepSynced(true);

//        mUserDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                String name = dataSnapshot.child("name").getValue().toString();
//                final String image = dataSnapshot.child("image").getValue().toString();
//                String status = dataSnapshot.child("status").getValue().toString();
//                String thumb_image = dataSnapshot.child("thumb_image").getValue().toString();
//
//                mName.setText(name);
//                mStatus.setText(status);
//
//                if(!image.equals("default")) {
//
//                    //Picasso.with(ProfileSettingsActivity.this).load(image).placeholder(R.drawable.default_avatar).into(mDisplayImage);
//
//                    Picasso.with(ProfileSettingsActivity.this).load(image).networkPolicy(NetworkPolicy.OFFLINE)
//                            .placeholder(R.drawable.default_avatar).into(mDisplayImage, new Callback() {
//                        @Override
//                        public void onSuccess() {
//
//                        }
//
//                        @Override
//                        public void onError() {
//
//                            Picasso.with(ProfileSettingsActivity.this).load(image).placeholder(R.drawable.default_avatar).into(mDisplayImage);
//
//                        }
//                    });
//
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


//        mStatusBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String status_value = mStatus.getText().toString();
//
//                Intent status_intent = new Intent(ProfileSettingsActivity.this, StatusActivity.class);
//                status_intent.putExtra("status_value", status_value);
//                startActivity(status_intent);
//
//            }
//        });


//        mImageBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Intent galleryIntent = new Intent();
//                galleryIntent.setType("image/*");
//                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
//
//                startActivityForResult(Intent.createChooser(galleryIntent, "SELECT IMAGE"), GALLERY_PICK);
//
//
//                /*
//                CropImage.activity()
//                        .setGuidelines(CropImageView.Guidelines.ON)
//                        .start(ProfileSettingsActivity.this);
//                        */
//
//            }
//        });


    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == GALLERY_PICK && resultCode == RESULT_OK){
//
//            Uri imageUri = data.getData();
//
//            CropImage.activity(imageUri)
//                    .setAspectRatio(1, 1)
//                    .setMinCropWindowSize(500, 500)
//                    .start(this);
//
//            //Toast.makeText(ProfileSettingsActivity.this, imageUri, Toast.LENGTH_LONG).show();
//
//        }
//
//
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//
//            if (resultCode == RESULT_OK) {
//
//
//                mProgressDialog = new ProgressDialog(ProfileSettingsActivity.this);
//                mProgressDialog.setTitle("Uploading Image...");
//                mProgressDialog.setMessage("Please wait while we upload and process the image.");
//                mProgressDialog.setCanceledOnTouchOutside(false);
//                mProgressDialog.show();
//
//
//                Uri resultUri = result.getUri();
//
//                File thumb_filePath = new File(resultUri.getPath());
//
//                String current_user_id = mCurrentUser.getUid();
//
//
//                Bitmap thumb_bitmap = null;
//                try {
//                    thumb_bitmap = new Compressor(this)
//                            .setMaxWidth(200)
//                            .setMaxHeight(200)
//                            .setQuality(75)
//                            .compressToBitmap(thumb_filePath);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                thumb_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                final byte[] thumb_byte = baos.toByteArray();
//
//
//                StorageReference filepath = mImageStorage.child("profile_images").child(current_user_id + ".jpg");
//                final StorageReference thumb_filepath = mImageStorage.child("profile_images").child("thumbs").child(current_user_id + ".jpg");
//
//
//
//                filepath.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
//
//                        if(task.isSuccessful()){
//
//                            final String download_url = task.getResult().getDownloadUrl().toString();
//
//                            UploadTask uploadTask = thumb_filepath.putBytes(thumb_byte);
//                            uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> thumb_task) {
//
//                                    String thumb_downloadUrl = thumb_task.getResult().getDownloadUrl().toString();
//
//                                    if(thumb_task.isSuccessful()){
//
//                                        Map update_hashMap = new HashMap();
//                                        update_hashMap.put("image", download_url);
//                                        update_hashMap.put("thumb_image", thumb_downloadUrl);
//
//                                        mUserDatabase.updateChildren(update_hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<Void> task) {
//
//                                                if(task.isSuccessful()){
//
//                                                    mProgressDialog.dismiss();
//                                                    Toast.makeText(ProfileSettingsActivity.this, "Success Uploading.", Toast.LENGTH_LONG).show();
//
//                                                }
//
//                                            }
//                                        });
//
//
//                                    } else {
//
//                                        Toast.makeText(ProfileSettingsActivity.this, "Error in uploading thumbnail.", Toast.LENGTH_LONG).show();
//                                        mProgressDialog.dismiss();
//
//                                    }
//
//
//                                }
//                            });
//
//
//
//                        } else {
//
//                            Toast.makeText(ProfileSettingsActivity.this, "Error in uploading.", Toast.LENGTH_LONG).show();
//                            mProgressDialog.dismiss();
//
//                        }
//
//                    }
//                });
//
//
//
//            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//
//                Exception error = result.getError();
//
//            }
//        }
//
//
//    }
//
//
//    public static String random() {
//        Random generator = new Random();
//        StringBuilder randomStringBuilder = new StringBuilder();
//        int randomLength = generator.nextInt(20);
//        char tempChar;
//        for (int i = 0; i < randomLength; i++){
//            tempChar = (char) (generator.nextInt(96) + 32);
//            randomStringBuilder.append(tempChar);
//        }
//        return randomStringBuilder.toString();
//    }
//

}