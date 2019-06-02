package com.that.edcerts.controllers

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.that.edcerts.Constants
import org.web3j.crypto.Bip39Wallet
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import java.io.File


class WalletController {

    companion object {
        val TAG = "WalletController"
    }

    fun createNewWallet(context: Context): Bip39Wallet {
        var appDirectory = File(Constants.APP_DIRECTORY)

        if(!appDirectory.exists())
            appDirectory.mkdirs()


        var wallet = WalletUtils.generateBip39Wallet("testpass", appDirectory)

        val editor = context.getSharedPreferences(Constants.SHARED_PREF_FILE, MODE_PRIVATE).edit()
        editor.putString(Constants.PASSPHRASE, wallet.mnemonic)
        editor.putString(Constants.WALLET_FILE, wallet.filename)

        editor.apply()

        return wallet
    }

    fun getWallet(context: Context): Bip39Wallet {
        val mnemonic = context.getSharedPreferences(Constants.SHARED_PREF_FILE, MODE_PRIVATE).getString(Constants.PASSPHRASE, "")
        val filename = context.getSharedPreferences(Constants.SHARED_PREF_FILE, MODE_PRIVATE).getString(Constants.WALLET_FILE, "")

        return Bip39Wallet(filename, mnemonic)
    }

    fun loginWallet(context: Context, mnemonic: String?): Credentials {
        val editor = context.getSharedPreferences(Constants.SHARED_PREF_FILE, MODE_PRIVATE).edit()
        editor.putString(Constants.PASSPHRASE, mnemonic)
        editor.apply()

        return WalletUtils.loadBip39Credentials(Constants.WALLET_PASS, mnemonic)
    }

    fun getCredentials(context: Context): Credentials {
        val mnemonic = context.getSharedPreferences(Constants.SHARED_PREF_FILE, MODE_PRIVATE).getString(Constants.PASSPHRASE, "")
        val filename = context.getSharedPreferences(Constants.SHARED_PREF_FILE, MODE_PRIVATE).getString(Constants.WALLET_FILE, "")

        return WalletUtils.loadBip39Credentials(Constants.WALLET_PASS, mnemonic)
    }

    fun isLoggedIn(context: Context): Boolean {
        return context.getSharedPreferences(Constants.SHARED_PREF_FILE, MODE_PRIVATE).getString(Constants.PASSPHRASE, null) != null
    }

    fun logout(context: Context) {
        context.getSharedPreferences(Constants.SHARED_PREF_FILE, MODE_PRIVATE)
                .edit()
                .putString(Constants.PASSPHRASE, null).apply()
    }
}
