package com.that.edcerts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    }

    companion object {
        fun newInstance() : SignUpFragment{
            return SignUpFragment()
        }
    }
}