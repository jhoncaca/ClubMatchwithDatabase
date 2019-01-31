package com.nawstuff.cahyadi.clubmatch2.view.activities.detail

import com.google.gson.Gson
import com.nawstuff.cahyadi.clubmatch2.api.ApiRequest
import com.nawstuff.cahyadi.clubmatch2.api.TheSportApi
import com.nawstuff.cahyadi.clubmatch2.model.EventResponse
import com.nawstuff.cahyadi.clubmatch2.model.TeamResponse
import com.nawstuff.cahyadi.clubmatch2.utilities.CoroutinesContexProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg


class DetailPresenter (private val view: DetailView,
                       private val apiRequest: ApiRequest,
                       private val gson: Gson,
                       private val context: CoroutinesContexProvider = CoroutinesContexProvider()) {
    fun getEventDetail(idEvent: String?, idHomeTeam: String?, idAwayTeam: String?) {
        view.showLoading()

        async(context.main) {
            val eventDetail = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailEvent(idEvent)),
                    EventResponse::class.java)
            }
            val badgeHome = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getHomeBadge(idHomeTeam)),
                    TeamResponse::class.java)
            }
            val badgeAway = bg {
                gson.fromJson(apiRequest.doRequest(TheSportApi.getAwayBadge(idAwayTeam)),
                    TeamResponse::class.java)
            }
            view.showEventList(eventDetail.await().match, badgeHome.await().teams,
                badgeAway.await().teams)
            view.hideLoading()
        }
    }
}