package com.mattrobertson.creeds.ui.composables.creeds

import com.mattrobertson.creeds.data.creeds.apostlesCreed
import com.mattrobertson.creeds.data.creeds.athanasianCreed
import com.mattrobertson.creeds.data.creeds.chalcedonianCreed
import com.mattrobertson.creeds.data.creeds.niceneCreed
import com.mattrobertson.creeds.model.creed.Creed

sealed class CreedTab(val creed: Creed) {
    object Apostles : CreedTab(apostlesCreed)
    object Nicene : CreedTab(niceneCreed)
    object Athanasian : CreedTab(athanasianCreed)
    object Chalcedonian : CreedTab(chalcedonianCreed)
}