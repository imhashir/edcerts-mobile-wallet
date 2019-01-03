package com.that.edcerts.activities

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.that.edcerts.fragments.CeritificateFragment

class CertificateActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return CeritificateFragment.newInstance()
    }

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, CertificateActivity::class.java)
        }
    }

}
