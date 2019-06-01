package com.that.edcerts.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.that.edcerts.R
import com.that.edcerts.activities.HomeActivity
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonProceed.setOnClickListener { startActivity(HomeActivity.newIntent(context)) }

        var url = "https://makemeapassword.ligos.net/api/v1/passphrase/plain?wc=12&maxCh=128"

        var request = StringRequest (
                Request.Method.GET,
                url,
                Listener {
                    passphase.setText(it.toString())
                },
                Response.ErrorListener {
                    Log.wtf(TAG, it)
                }
        )

        Volley.newRequestQueue(activity).add(request)
    }

    companion object {
        private val TAG = "SignUpFragment"

        fun newInstance() : SignUpFragment{
            return SignUpFragment()
        }
    }
}