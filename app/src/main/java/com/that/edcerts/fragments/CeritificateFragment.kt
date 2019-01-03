package com.that.edcerts.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.that.edcerts.R

class CeritificateFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_certificate, container, false)
    }

    companion object {
        fun newInstance() : CeritificateFragment{
            return CeritificateFragment()
        }
    }
}