package com.that.edcerts.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

open class BaseActivity : AppCompatActivity() {

    companion object {
        private val PERMISSIONS_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermissions()
    }

    fun requestPermissions() {
        val reqPermissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val pendingPermissions = ArrayList<String>()

        for (i in reqPermissions.indices) {
            if (ContextCompat.checkSelfPermission(this,
                            reqPermissions[i]) != PackageManager.PERMISSION_GRANTED) {
                pendingPermissions.add(reqPermissions[i])
            }
        }

        if (pendingPermissions.size > 0) {
            ActivityCompat.requestPermissions(this,
                    pendingPermissions.toTypedArray(),
                    PERMISSIONS_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSIONS_REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                finishAffinity()
            }
        }
    }

}
