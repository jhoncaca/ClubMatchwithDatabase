package com.nawstuff.cahyadi.clubmatch2.utilities

import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext


open class CoroutinesContexProvider {
    open val main: CoroutineContext by lazy { UI }
}