package com.that.edcerts.activities

import android.support.v4.app.Fragment
import com.that.edcerts.fragments.LoginFragment

class LoginActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return LoginFragment.newInstance()
    }

}
