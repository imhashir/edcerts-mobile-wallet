package com.that.edcerts.fragments

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.that.edcerts.R
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
                .setIconNormalColor(-0x27bceb)
                .setIconPressedColor(-0x40c9f4)
                .setLabelColor(-0x27bceb)
                .setWrapper(0)
        )
        items.add(RFACLabelItem<Int>()
                .setLabel("Verify")
                .setResId(R.drawable.ic_verify)
                .setIconNormalColor(-0xb1cbd2)
                .setIconPressedColor(-0xc1d8dd)
                .setLabelColor(-0xb1cbd2)
                .setLabelSizeSp(14)
                .setWrapper(1)
        )
        items.add(RFACLabelItem<Int>()
                .setLabel("Info")
                .setResId(R.drawable.ic_info)
                .setIconNormalColor(-0xfa9100)
                .setIconPressedColor(-0xf2acfe)
                .setLabelColor(-0xfa9100)
                .setWrapper(2)
        )
        rfaContent
                .setItems(items as List<RFACLabelItem<Any>>?)
                .setIconShadowColor(-0x777778)
        fabOptionsHelper = RapidFloatingActionHelper(
                context,
                fabLayout,
                fabCertificateOptions,
                rfaContent
        ).build()
    }

    override fun onRFACItemIconClick(position: Int, item: RFACLabelItem<Int>?) {
        Snackbar.make(view!!, "Option: " + position + " Clicked!", Snackbar.LENGTH_LONG).show()
        fabOptionsHelper!!.toggleContent()
    }

    override fun onRFACItemLabelClick(position: Int, item: RFACLabelItem<Int>?) {
        Snackbar.make(view!!, "Option text: " + position + " Clicked!", Snackbar.LENGTH_LONG).show()
        fabOptionsHelper!!.toggleContent()
    }

    companion object {
        fun newInstance() : CertificateFragment{
            return CertificateFragment()
        }
    }
}