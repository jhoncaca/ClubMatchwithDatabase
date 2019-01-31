package com.nawstuff.cahyadi.clubmatch2.presenter

import com.google.gson.Gson
import com.nawstuff.cahyadi.clubmatch2.TestContextProvider
import com.nawstuff.cahyadi.clubmatch2.api.ApiRequest
import com.nawstuff.cahyadi.clubmatch2.api.TheSportApi
import com.nawstuff.cahyadi.clubmatch2.model.Event
import com.nawstuff.cahyadi.clubmatch2.model.EventResponse
import com.nawstuff.cahyadi.clubmatch2.view.fragment.prev.PrevPresenter
import com.nawstuff.cahyadi.clubmatch2.view.fragment.prev.PrevView

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class PrevEventPresenterTest {
    @Mock
    private lateinit var view: PrevView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: PrevPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PrevPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetPrevEvent() {
        val events: MutableList<Event> = mutableListOf()
        val response = EventResponse(events)
        val paramEvent = "eventspastleague"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getSchedule(paramEvent)),
            EventResponse::class.java)).thenReturn(response)

        presenter.getEventList(paramEvent)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(events)
        Mockito.verify(view).hideLoading()
    }







}