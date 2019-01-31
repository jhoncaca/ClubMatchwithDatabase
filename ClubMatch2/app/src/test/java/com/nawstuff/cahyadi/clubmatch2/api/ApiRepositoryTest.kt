package com.nawstuff.cahyadi.clubmatch2.api

import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

class ApiRepositoryTest {

    @Test
    fun testPreEventApi() {
        val apiRepository = Mockito.mock(ApiRequest::class.java)
        val url = TheSportApi.getPrevEvent("4328")
        apiRepository.doRequest(url)
        Mockito.verify(apiRepository).doRequest(url)
    }

    @Test
    fun testNextEventApi() {
        val apiRequest = Mockito.mock(ApiRequest::class.java)
        val url = TheSportApi.getNextEvent("4328")
        apiRequest.doRequest(url)
        Mockito.verify(apiRequest).doRequest(url)
    }

}