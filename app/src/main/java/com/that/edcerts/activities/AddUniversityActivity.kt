package com.that.edcerts.activities

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.that.edcerts.fragments.AddUniversityFragment

class AddUniversityActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return if(intent.data != null) {
            var path = intent.data.path
            var host = intent.data.host
            AddUniversityFragment.newInstance(path, host)
        } else{
            AddUniversityFragment.newInstance()
        }
    }

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, AddUniversityActivity::class.java)
        }
    }

}
