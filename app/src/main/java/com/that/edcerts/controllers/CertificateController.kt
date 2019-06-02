package com.that.edcerts.controllers

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class CertificateController(private val mContext: Context?) {
    private var mOnCertificatesFetchedListener: OnCertificatesFetchedListener? = null

    interface OnCertificatesFetchedListener {
        fun onFetched(`object`: JSONArray)
        fun onError(ex: String?)
    }

    fun fetchCertificates(listener: OnCertificatesFetchedListener) {
        mOnCertificatesFetchedListener = listener
        val url = "https://edcert.herokuapp.com/GetDegrees/${WalletController().getCredentials(mContext!!).ecKeyPair.publicKey}"

        val arrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
                Response.Listener { response -> mOnCertificatesFetchedListener!!.onFetched(response) },
                Response.ErrorListener { error ->
                    if(error.networkResponse.statusCode == 404) {
                        Log.i(TAG, "No record found")
                    } else if (error.message != null) {
                        mOnCertificatesFetchedListener!!.onError(error.message)
                        Log.i(TAG, error.message)
                    }
                }
        )

        Volley.newRequestQueue(mContext).add(arrayRequest)
    }

    companion object {

        private val TAG = "CertificateController"
    }

}
