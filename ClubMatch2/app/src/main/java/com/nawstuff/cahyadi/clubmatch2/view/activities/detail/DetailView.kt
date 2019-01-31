package com.nawstuff.cahyadi.clubmatch2.view.activities.detail

import com.nawstuff.cahyadi.clubmatch2.model.Event
import com.nawstuff.cahyadi.clubmatch2.model.Team

interface DetailView {
    fun hideLoading()
    fun showLoading()
    fun showEventList(data: List<Event>, home: List<Team>, away: List<Team>)
}