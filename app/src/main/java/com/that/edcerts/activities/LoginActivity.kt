package com.that.edcerts.activities

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.that.edcerts.fragments.LoginFragment

class LoginActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return LoginFragment.newInstance()
    }

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

}