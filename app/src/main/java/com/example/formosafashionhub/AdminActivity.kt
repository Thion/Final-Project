package com.example.formosafashionhub

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.util.UUID

class AdminActivity : AppCompatActivity() {
    private lateinit var itemTitleEditText: EditText
    private lateinit var itemDescriptionEditText: EditText
    private lateinit var itemPriceEditText: EditText
    private lateinit var itemImageView: ImageView
    private lateinit var saveItemButton: Button
    private lateinit var updateItem: Button
    private lateinit var databaseReference: DatabaseReference
    var fileUri: Uri? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)


        itemTitleEditText = findViewById(R.id.mEdtItemName)
        itemDescriptionEditText = findViewById(R.id.mEdtDescription)
        itemPriceEditText = findViewById(R.id.mEdtPrice)
        itemImageView = findViewById(R.id.ItemimageView)
        saveItemButton = findViewById(R.id.BtnSave)
        updateItem = findViewById(R.id.BtnUpdate)


        itemImageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(intent, "Choose image to upload"), 22
            )
        }

        saveItemButton.setOnClickListener {
            saveItem()
            uploadImage()
        }
        updateItem.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun uploadImage() {
        if (fileUri != null) {
            val progressDialog = ProgressDialog(this)
            val ref: StorageReference = FirebaseStorage.getInstance().getReference().child(UUID.randomUUID().toString())

            progressDialog.setTitle("Uploading")
            progressDialog.setMessage("Uploading your image...")
            progressDialog.show()


            ref.putFile(fileUri!!).addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(applicationContext, "Image Uploaded.", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                progressDialog.dismiss()
                Toast.makeText(applicationContext, "Failed to upload image", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 22 && resultCode == RESULT_OK && data != null && data.data != null) {

            fileUri = data.data
            try {

                val bitmap: Bitmap =
                    MediaStore.Images.Media.getBitmap(contentResolver, fileUri);
                itemImageView.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun saveItem() {
        val itemName = itemTitleEditText.text.toString().trim()
        val itemDescription = itemDescriptionEditText.text.toString().trim()
        val itemPrice = itemPriceEditText.text.toString().trim()

        if (itemName.isNotEmpty() && itemDescription.isNotEmpty() && itemPrice.isNotEmpty()) {

            val itemId = databaseReference.child("items").push().key
            val item = Item(itemName, itemDescription, itemPrice, image = String())

            databaseReference.child("items").child(itemId!!).setValue(item)
                .addOnSuccessListener {
                    Toast.makeText(this, "Item saved successfully", Toast.LENGTH_SHORT)
                        .show()
                    clearFields()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error saving item", Toast.LENGTH_SHORT)
                        .show()
                }
        } else {
            Log.d(TAG, "Please fill in all the fields")
        }


    }

    private fun clearFields() {
        itemTitleEditText.text.clear()
        itemDescriptionEditText.text.clear()
        itemPriceEditText.text.clear()
        itemImageView.setImageDrawable(null)
    }
}

