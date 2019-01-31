package com.nawstuff.cahyadi.clubmatch2.view.fragment.prev

import com.nawstuff.cahyadi.clubmatch2.model.Event

interface PrevView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}