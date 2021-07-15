package com.mattrobertson.creeds.ui.composables.catechisms

import com.mattrobertson.creeds.data.catechisms.childrensCatechism
import com.mattrobertson.creeds.data.catechisms.robertsonCatechism
import com.mattrobertson.creeds.data.catechisms.wlc
import com.mattrobertson.creeds.data.catechisms.wsc
import com.mattrobertson.creeds.model.catechism.Catechism

sealed class CatechismTab(val catechism: Catechism) {
    object WestminsterShorter : CatechismTab(wsc)
    object WestminsterLarger : CatechismTab(wlc)
    object Childrens : CatechismTab(childrensCatechism)
    object Robertson : CatechismTab(robertsonCatechism)
}