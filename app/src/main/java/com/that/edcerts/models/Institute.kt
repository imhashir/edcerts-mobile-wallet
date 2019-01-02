package com.that.edcerts.models

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class Institute(title: String, list: List<Certificate>) : ExpandableGroup<Certificate>(title, list) {
    
}