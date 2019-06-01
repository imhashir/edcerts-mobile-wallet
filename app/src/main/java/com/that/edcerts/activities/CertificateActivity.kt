package com.that.edcerts.activities

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.that.edcerts.fragments.CertificateFragment

class CertificateActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return CertificateFragment.newInstance()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CertificateActivity::class.java)
        }
    }
}
