package com.that.edcerts.fragments

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.that.edcerts.R
import com.that.edcerts.activities.HomeActivity
import kotlinx.android.synthetic.main.fragment_add_university.*

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

        buttonAddUniversity.setOnClickListener {
            startActivity(HomeActivity.newIntent(context))
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