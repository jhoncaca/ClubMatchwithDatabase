package com.nawstuff.cahyadi.clubmatch2.presenter

import com.google.gson.Gson
import com.nawstuff.cahyadi.clubmatch2.TestContextProvider
import com.nawstuff.cahyadi.clubmatch2.api.ApiRequest
import com.nawstuff.cahyadi.clubmatch2.api.TheSportApi
import com.nawstuff.cahyadi.clubmatch2.model.Event
import com.nawstuff.cahyadi.clubmatch2.model.EventResponse
import com.nawstuff.cahyadi.clubmatch2.view.fragment.next.NextPresenter
import com.nawstuff.cahyadi.clubmatch2.view.fragment.next.NextView

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class NextEventPresenterTest {

    @Mock
    private lateinit var view: NextView

    @Mock
    private lateinit var gson: Gson

    @Mock
    lateinit var apiRequest: ApiRequest

    private lateinit var presenter: NextPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextPresenter(view, apiRequest, gson, TestContextProvider())
    }

    @Test
    fun testGetNextEvent() {
        val events: MutableList<Event> = mutableListOf()
        val response = EventResponse(events)
        val paramEvent = "eventsnextleague"

        Mockito.`when`(gson.fromJson(apiRequest.doRequest(TheSportApi.getSchedule(paramEvent)),
            EventResponse::class.java)).thenReturn(response)

        presenter.getEventList(paramEvent)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEventList(events)
        Mockito.verify(view).hideLoading()
    }






}