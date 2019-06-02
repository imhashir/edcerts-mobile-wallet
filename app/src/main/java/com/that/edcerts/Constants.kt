package com.that.edcerts

import android.os.Environment
import java.io.File

class Constants {
    companion object {
        val APP_DIRECTORY = Environment.getExternalStorageDirectory().absolutePath + File.separator + "Edcerts"
        val PASSPHRASE = "mnemonic"
        val WALLET_FILE = "wallet.file"
        val WALLET_PASS = "testpass"

        val SHARED_PREF_FILE = "wallet.file"
    }
}
