package com.nawstuff.cahyadi.clubmatch2.presenter

import com.google.gson.Gson
import com.nawstuff.cahyadi.clubmatch2.TestContextProvider
import com.nawstuff.cahyadi.clubmatch2.api.ApiRequest
import com.nawstuff.cahyadi.clubmatch2.api.TheSportApi
import com.nawstuff.cahyadi.clubmatch2.model.Event
import com.nawstuff.cahyadi.clubmatch2.model.EventResponse
import com.nawstuff.cahyadi.clubmatch2.model.Team
import com.nawstuff.cahyadi.clubmatch2.model.TeamResponse
import com.nawstuff.cahyadi.clubmatch2.view.activities.detail.DetailPresenter
import com.nawstuff.cahyadi.clubmatch2.view.activities.detail.DetailView

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class DetailEventPresenterTest {
    @Mock
    private lateinit var view: DetailView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: DetailPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetNextEvent() {
        val events: MutableList<Event> = mutableListOf()
        val home: MutableList<Team> = mutableListOf()
        val away: MutableList<Team> = mutableListOf()
        val response = EventResponse(events)
        val homeResponse = TeamResponse(home)
        val awayResponse = TeamResponse(away)
        val idEvent = "526916"
        val idHomeTeam = "134778"
        val idAwayTeam = "133613"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getDetailEvent(idEvent)),
            EventResponse::class.java)).thenReturn(response)
        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getHomeBadge(idHomeTeam)),
            TeamResponse::class.java)).thenReturn(homeResponse)
        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getAwayBadge(idAwayTeam)),
            TeamResponse::class.java)).thenReturn(awayResponse)

        presenter.getEventDetail(idEvent, idHomeTeam, idAwayTeam)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(events, home, away)
        Mockito.verify(view).hideLoading()
    }








}