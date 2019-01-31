package com.nawstuff.cahyadi.clubmatch2.view.fragment.next

import com.nawstuff.cahyadi.clubmatch2.model.Event


interface NextView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>?)
    fun errorMessage(message: String?)
}