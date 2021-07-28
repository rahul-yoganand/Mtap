package com.example.mtap

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class contentProviders : AppCompatActivity() {
    lateinit var cpListview: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_providers)
        cpListview = findViewById(R.id.cpListView)
        val uriSms: Uri = Uri.parse("content://sms/inbox")
        var fromColumn = arrayOf("body","address")
        var toTextView = intArrayOf(android.R.id.text1,android.R.id.text2)
        var rowLayout = android.R.layout.simple_list_item_2  //C:\Users\Admin\AppData\Local\Android\Sdk\platforms\android-28\data\res\layout
        if(!checkReadSMSPermission()){
            //  onPermissionCallBack = this
            getReadSMSPermission()
        }
        var dataCursor =
            contentResolver.query(uriSms,null,null,null,null,null)

        var adapter: SimpleCursorAdapter =
            SimpleCursorAdapter(this,rowLayout,dataCursor,fromColumn,toTextView,1)
        cpListview.adapter =adapter
    }
    private fun checkReadSMSPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {
                true
            } else {
                false
            }
        } else {
            true
        }
    }
    var REQUEST_READ_SMS_PERMISSION = 123
    var onPermissionCallBack: RequestPermissionAction? = null

    fun getReadSMSPermission() {
        //onPermissionCallBack = onPermissionCallBack
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!checkReadSMSPermission()) {
                requestPermissions(
                    arrayOf(Manifest.permission.READ_SMS),
                    REQUEST_READ_SMS_PERMISSION
                )
                return
            }
        }
        //if (onPermissionCallBack != null) onPermissionCallBack.permissionGranted()
    }


    //fun getReadSmsPermission(){}
    open interface RequestPermissionAction {
        fun permissionDenied()
        fun permissionGranted()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }
}