package com.that.edcerts.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ShareCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.that.edcerts.R
import com.that.edcerts.activities.VerifyCertificateActivity
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList
import kotlinx.android.synthetic.main.fragment_certificate.*


class CertificateFragment : Fragment(), RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener<Int> {

    var fabOptionsHelper: RapidFloatingActionHelper? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_certificate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rfaContent = RapidFloatingActionContentLabelList(context)
        rfaContent.setOnRapidFloatingActionContentLabelListListener(this)
        val items = ArrayList<RFACLabelItem<Int>>()
        items.add(RFACLabelItem<Int>()
                .setLabel("Share")
                .setResId(R.drawable.ic_share)
                .setIconNormalColor(-0xFFCC44)
                .setIconPressedColor(-0xffffff)
                .setLabelColor(R.color.colorAccent)
                .setWrapper(0)
        )
        items.add(RFACLabelItem<Int>()
                .setLabel("Verify")
                .setResId(R.drawable.ic_verify)
                .setIconNormalColor(-0xFFCC44)
                .setIconPressedColor(R.color.colorAccent)
                .setLabelColor(R.color.colorPrimary)
                .setLabelSizeSp(14)
                .setWrapper(1)
        )
        items.add(RFACLabelItem<Int>()
                .setLabel("Info")
                .setResId(R.drawable.ic_info)
                .setIconNormalColor(-0xFFCC44)
                .setIconPressedColor(R.color.colorAccent)
                .setLabelColor(R.color.colorPrimary)
                .setWrapper(2)
        )
        rfaContent
                .setItems(items as List<RFACLabelItem<Any>>?)
        fabOptionsHelper = RapidFloatingActionHelper(
                context,
                fabLayout,
                fabCertificateOptions,
                rfaContent
        ).build()
    }

    override fun onRFACItemIconClick(position: Int, item: RFACLabelItem<Int>?) {
        when (position) {
            0 -> { // Share
                val shareIntent = ShareCompat.IntentBuilder.from(activity)
                        .setChooserTitle("Share Certificate")
                        .setType("text/plain")
                        .setText("http://www.nu.edu.pk")
                        .intent
                if (shareIntent.resolveActivity(activity!!.packageManager) != null) {
                    startActivity(shareIntent)
                }
            }
            1 -> { // Verify
                startActivity(VerifyCertificateActivity.newIntent(context))
            }
            2 -> { // Info

            }
        }
        fabOptionsHelper!!.toggleContent()
    }

    override fun onRFACItemLabelClick(position: Int, item: RFACLabelItem<Int>?) {
        onRFACItemIconClick(position, item)
    }

    companion object {
        fun newInstance(): CertificateFragment {
            return CertificateFragment()
        }
    }
}