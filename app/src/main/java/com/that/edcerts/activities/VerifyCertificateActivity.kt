package com.that.edcerts.activities

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.that.edcerts.fragments.VerifyCertificateFragment

class VerifyCertificateActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return VerifyCertificateFragment.newInstance()
    }

    companion object {
        fun newIntent(context: Context?) : Intent {
            return Intent(context, VerifyCertificateActivity::class.java)
        }
    }

}
