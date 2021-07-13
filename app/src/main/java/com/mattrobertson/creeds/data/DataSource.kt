package com.mattrobertson.creeds.data

import com.mattrobertson.creeds.data.Creeds.*
import com.mattrobertson.creeds.data.creeds.apostlesCreed
import com.mattrobertson.creeds.data.creeds.athanasianCreed
import com.mattrobertson.creeds.data.creeds.chalcedonianCreed
import com.mattrobertson.creeds.data.creeds.niceneCreed
import com.mattrobertson.creeds.model.creed.Creed

object DataSource {

    fun getCreed(creed: Creeds): Creed {
        return when (creed) {
            Apostles -> apostlesCreed
            Nicene -> niceneCreed
            Athanasian -> athanasianCreed
            Chalcedonian -> chalcedonianCreed
        }
    }

}