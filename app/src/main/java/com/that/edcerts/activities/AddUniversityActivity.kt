package com.that.edcerts.activities

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.that.edcerts.fragments.AddUniversityFragment
import com.that.edcerts.fragments.LoginFragment

class AddUniversityActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return AddUniversityFragment.newInstance()
    }

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, AddUniversityActivity::class.java)
        }
    }

}
