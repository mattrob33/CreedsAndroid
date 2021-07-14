package com.mattrobertson.creeds.ui.composables.confessions

import com.mattrobertson.creeds.data.confessions.westminsterConfession
import com.mattrobertson.creeds.model.confession.Confession

sealed class ConfessionTab(val confession: Confession) {
    object Westminster : ConfessionTab(westminsterConfession)
}