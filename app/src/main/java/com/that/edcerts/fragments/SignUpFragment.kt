package com.that.edcerts.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.that.edcerts.R
import com.that.edcerts.activities.HomeActivity
import com.that.edcerts.controllers.WalletController
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpFragment : Fragment() {
    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_signup, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonProceed.setOnClickListener {
            startActivity(HomeActivity.newIntent(context))
            activity!!.finish()
        }

        var wallet = WalletController().createNewWallet(context!!)
        passphase.setText(wallet.mnemonic)

        passphase.setOnClickListener {
            var manager = activity!!.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", wallet.mnemonic)
            manager.setPrimaryClip(clip)
            Snackbar.make(rootView!!, "Copied to clipboard", Snackbar.LENGTH_LONG).show()
        }

        var creds = WalletController().getCredentials(context!!)
        Log.i(TAG, "Wallet Address: " + creds.address)
        Log.i(TAG, "Priv Key: " + creds.ecKeyPair.privateKey)
        Log.i(TAG, "Pub Key: " + creds.ecKeyPair.publicKey)
    }

    companion object {
        private val TAG = "SignUpFragment"

        fun newInstance() : SignUpFragment{
            return SignUpFragment()
        }
    }
}