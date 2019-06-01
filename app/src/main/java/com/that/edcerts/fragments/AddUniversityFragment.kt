package com.that.edcerts.fragments

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.that.edcerts.R
import com.that.edcerts.activities.HomeActivity
import kotlinx.android.synthetic.main.fragment_add_university.*
import org.json.JSONObject

class AddUniversityFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_university, container, false)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            var url = (arguments!![KEY_HOST] as String) + arguments!![KEY_PATH] as String
            invitationUrl.setText(url)
        }

        var inputObject = JSONObject()
        try {
            inputObject.put(":email", "ljdkjlksj")
            inputObject.put(":pkey", "shfeiuruewiu")
        } catch (ex: Exception) {

        }
        buttonAddUniversity.setOnClickListener {

            var pkey = "lslkdjsakdpodjfslkfsfj"
            var url = "http://192.168.1.8:3000/UpdatePublicKey/f8dccfcf-b5e8-4aee-aed4-85c77b358448/${edittext_email.text}/${pkey}"

            var jsonObjectRequest = JsonObjectRequest(
                    Request.Method.PATCH,
                    url,
                    inputObject,
                    Response.Listener {
                        startActivity(HomeActivity.newIntent(context))
                    },
                    Response.ErrorListener {
                        Log.wtf(TAG, it)
                    })

            Volley.newRequestQueue(activity).add(jsonObjectRequest)
        }
    }

    companion object {
        private val TAG = "AddUniversityFragment"
        private val KEY_PATH = "AddUniversityFragment.path"
        private val KEY_HOST = "AddUniversityFragment.host"


        fun newInstance(): AddUniversityFragment {
            return AddUniversityFragment()
        }

        fun newInstance(path: String?, host: String?): AddUniversityFragment {
            var fragment = AddUniversityFragment()
            var bundle = Bundle()
            bundle.putString(KEY_PATH, path)
            bundle.putString(KEY_HOST, host)
            fragment.arguments = bundle
            return fragment
        }
    }
}