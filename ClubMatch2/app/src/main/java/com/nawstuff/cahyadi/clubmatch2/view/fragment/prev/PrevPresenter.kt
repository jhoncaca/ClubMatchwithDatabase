package com.nawstuff.cahyadi.clubmatch2.view.fragment.prev

import com.google.gson.Gson
import com.nawstuff.cahyadi.clubmatch2.api.ApiRequest
import com.nawstuff.cahyadi.clubmatch2.api.TheSportApi
import com.nawstuff.cahyadi.clubmatch2.model.EventResponse
import com.nawstuff.cahyadi.clubmatch2.utilities.CoroutinesContexProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class PrevPresenter ( private val view: PrevView,
                      private val apiRequest: ApiRequest,
                      private val gson: Gson,
                      private val context:CoroutinesContexProvider = CoroutinesContexProvider()
){


    fun getEventList(match:String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(
                    apiRequest.doRequest(TheSportApi.getSchedule(match)),
                    EventResponse::class.java
                )
            }
            view.showEventList(data.await().match)
            view.hideLoading()
        }


    }

}