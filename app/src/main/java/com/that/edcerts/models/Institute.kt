package com.that.edcerts.models

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import org.json.JSONObject

class Institute(title: String, list: List<Certificate>) : ExpandableGroup<Certificate>(title, list) {
    fun add(certifcate: JSONObject) {
        this.items.add(Certificate(name = certifcate["Program"] as String))
    }
}