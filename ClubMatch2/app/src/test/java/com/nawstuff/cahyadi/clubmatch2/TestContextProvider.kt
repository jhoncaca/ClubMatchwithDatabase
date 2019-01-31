package com.nawstuff.cahyadi.clubmatch2

import com.nawstuff.cahyadi.clubmatch2.utilities.CoroutinesContexProvider
import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext

class TestContextProvider : CoroutinesContexProvider(){
    override val main: CoroutineContext = Unconfined
}