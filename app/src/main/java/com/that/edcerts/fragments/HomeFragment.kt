package com.that.edcerts.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.that.edcerts.activities.CertificateActivity
import com.that.edcerts.models.Certificate
import com.that.edcerts.models.Institute
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.single_certificate_layout.view.*
import kotlinx.android.synthetic.main.single_institute_certs_layout.view.*
import java.util.*


class HomeFragment : Fragment() {

    open var holde: InstituteHolder? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.that.edcerts.R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var certificatesInst1: ArrayList<Certificate> = ArrayList<Certificate>()
        certificatesInst1.add(Certificate("NU Certificate 1"))
        certificatesInst1.add(Certificate("NU Certificate 2"))
        certificatesInst1.add(Certificate("NU Certificate 3"))
        certificatesInst1.add(Certificate("NU Certificate 4"))

        var certificatesInst2: ArrayList<Certificate> = ArrayList<Certificate>()
        certificatesInst2.add(Certificate("LUMS Certificate 1"))
        certificatesInst2.add(Certificate("LUMS Certificate 2"))
        certificatesInst2.add(Certificate("LUMS Certificate 3"))
        certificatesInst2.add(Certificate("LUMS Certificate 4"))

        var nucesUni = Institute("NUCES", certificatesInst1)
        var lumsUni = Institute("LUMS", certificatesInst2)

        var institutes: ArrayList<Institute> = ArrayList<Institute>()
        institutes.add(nucesUni)
        institutes.add(lumsUni)

        instituteList.adapter = InstituteCertificateAdapter(institutes)
        instituteList.layoutManager = LinearLayoutManager(context)
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    private inner class InstituteCertificateAdapter(groups: List<ExpandableGroup<*>>?) : ExpandableRecyclerViewAdapter<InstituteHolder, CertificateHolder>(groups) {

        override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): InstituteHolder {
            return InstituteHolder(LayoutInflater.from(context).inflate(com.that.edcerts.R.layout.single_institute_certs_layout, parent, false))
        }

        override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): CertificateHolder {
            return CertificateHolder(LayoutInflater.from(context).inflate(com.that.edcerts.R.layout.single_certificate_layout, parent, false))
        }

        override fun onBindChildViewHolder(holder: CertificateHolder?, flatPosition: Int, group: ExpandableGroup<*>?, childIndex: Int) {
            var certificate = group!!.items[childIndex] as Certificate
            holder!!.bindView(certificate)
        }

        override fun onBindGroupViewHolder(holder: InstituteHolder?, flatPosition: Int, group: ExpandableGroup<*>?) {
            holder!!.bindView(group as Institute)
        }
    }

    inner class InstituteHolder(itemView: View) : GroupViewHolder(itemView) {
        private var listener: OnGroupClickListener? = null
        fun bindView(institute: Institute) = with(itemView) {
            itemView.instituteTitle.text = institute.title
        }

        override fun onClick(v: View?) {
            super.onClick(v)

            val animation = AnimationUtils.loadAnimation(context, com.that.edcerts.R.anim.fadein)
            itemView.startAnimation(animation)

            if (v != null && v.isSelected == false) {
                v.isSelected = true
            } else if (v != null && v.isSelected == true)
                v.isSelected = false
        }
    }

    inner class CertificateHolder(itemView: View) : ChildViewHolder(itemView) {

        fun bindView(certificate: Certificate) = with(itemView) {
            itemView.certificateTitle.text = certificate.certificateName
            itemView.setOnClickListener { startActivity(CertificateActivity.newIntent(context)) }
        }
    }
}