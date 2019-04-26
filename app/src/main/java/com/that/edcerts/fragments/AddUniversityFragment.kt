package com.that.edcerts.fragments

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        buttonAddUniversity.setOnClickListener {
            startActivity(HomeActivity.newIntent(context))
        }
    }

    companion object {
        fun newInstance(): AddUniversityFragment {
            return AddUniversityFragment()
        }
    }
}