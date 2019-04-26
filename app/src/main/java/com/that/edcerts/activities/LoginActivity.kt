package com.that.edcerts.activities

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.support.constraint.ConstraintSet
import android.support.v4.app.Fragment
import android.transition.TransitionManager
import com.that.edcerts.fragments.LoginFragment
import kotlinx.android.synthetic.main.fragment_login.*
import java.lang.Thread.sleep


class LoginActivity : SingleFragmentActivity() {

    class GetWeatherTask(listener: OnTaskCompleted) : AsyncTask<Unit, Unit, Unit>() {
        private var listener: OnTaskCompleted? = null

        init {
            this.listener = listener
        }

        interface OnTaskCompleted {
            fun onTaskCompleted()
        }

        override fun doInBackground(vararg params: Unit?): Unit? {
            sleep(500)
            return null
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            listener?.onTaskCompleted()
        }
    }

    override fun createFragment(): Fragment {
        return LoginFragment.newInstance()
    }

    override fun onResume() {
        super.onResume()
        GetWeatherTask(object : GetWeatherTask.OnTaskCompleted {
            override fun onTaskCompleted() {
                addAnimationOperations()
            }
        }).execute();
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    private fun addAnimationOperations() {
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        if (set == false) {
            constraint2.clone(this, com.that.edcerts.R.layout.fragment_login)
        } else {
            constraint2.clone(this, com.that.edcerts.R.layout.fragment_login_start)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(root)
            val constraint = if (set) constraint1 else constraint2
            constraint.applyTo(root)
            set = !set
        }
    }
}
