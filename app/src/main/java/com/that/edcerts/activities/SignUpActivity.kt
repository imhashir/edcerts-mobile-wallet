package com.that.edcerts.activities

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.that.edcerts.fragments.SignUpFragment

class SignUpActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return SignUpFragment.newInstance()
    }

    companion object {
        fun newIntent(context: Context?) : Intent {
            return Intent(context, SignUpActivity::class.java)
        }
    }

}
