package com.that.edcerts.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import com.that.edcerts.R

abstract class SingleFragmentActivity : BaseActivity() {

    abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fm = getSupportFragmentManager()
        var fragment = fm.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            fragment = createFragment()
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }
}
