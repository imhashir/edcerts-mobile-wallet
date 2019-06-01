package com.that.edcerts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.that.edcerts.R
import kotlinx.android.synthetic.main.fragment_verify_cert.*
import java.util.*

class VerifyCertificateFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_verify_cert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonDone.setOnClickListener { activity!!.finish() }
        makeProgress(1)
    }

    companion object {
        fun newInstance() : VerifyCertificateFragment{
            return VerifyCertificateFragment()
        }
    }

    fun makeProgress(steps: Int) {
        if(steps > resources.getStringArray(R.array.verification_steps).size) {
            activity!!.runOnUiThread { verificationProgressSteps.done(true) }
            return
        }
        Timer().schedule(object: TimerTask() {
            override fun run() {
                activity!!.runOnUiThread { verificationProgressSteps.go(steps, true) }
                makeProgress(steps + 1)
            }

        }, 1000)
    }
}