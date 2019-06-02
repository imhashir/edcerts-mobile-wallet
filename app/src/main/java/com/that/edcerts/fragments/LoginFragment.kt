package com.that.edcerts.fragments

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.that.edcerts.R
import com.that.edcerts.activities.HomeActivity
import com.that.edcerts.activities.SignUpActivity
import com.that.edcerts.controllers.WalletController
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    var set = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(WalletController().isLoggedIn(context!!)) {
            startActivity(HomeActivity.newIntent(context))
            activity!!.finish()
        }
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
            var creds = WalletController().loginWallet(context!!, edittext_passphrase.text.trim().toString())

            Log.i(TAG, "Wallet Address: " + creds.address)
            Log.i(TAG, "Priv Key: " + creds.ecKeyPair.privateKey)
            Log.i(TAG, "Pub Key: " + creds.ecKeyPair.publicKey)

            startActivity(HomeActivity.newIntent(context))
            activity!!.finish()
        }

        buttonCreateWallet.setOnClickListener {
            startActivity(SignUpActivity.newIntent(context))
        }
    }

    companion object {
        val TAG = "LoginFragment"
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