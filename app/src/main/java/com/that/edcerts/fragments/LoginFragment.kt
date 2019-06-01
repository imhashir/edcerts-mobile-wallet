package com.that.edcerts.fragments

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.that.edcerts.R
import com.that.edcerts.activities.HomeActivity
import com.that.edcerts.activities.SignUpActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    var set = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_login_start, container, false)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ic_logo.setOnClickListener {
            addAnimationOperations()
        }

        buttonLogin.setOnClickListener {
            startActivity(HomeActivity.newIntent(context))
        }

        buttonCreateWallet.setOnClickListener {
            startActivity(SignUpActivity.newIntent(context))
        }
    }

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addAnimationOperations() {
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        if (set == false) {
            constraint2.clone(context, com.that.edcerts.R.layout.fragment_login)
        } else {
            constraint2.clone(context, com.that.edcerts.R.layout.fragment_login_start)
        }

        TransitionManager.beginDelayedTransition(root, ChangeBounds())
        val constraint = constraint2
        set = !set
        constraint.applyTo(root)
        root.visibility = View.VISIBLE
    }

}