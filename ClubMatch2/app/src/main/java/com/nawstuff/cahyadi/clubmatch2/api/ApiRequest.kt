package com.nawstuff.cahyadi.clubmatch2.api

import java.net.URL

class ApiRequest {
    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}