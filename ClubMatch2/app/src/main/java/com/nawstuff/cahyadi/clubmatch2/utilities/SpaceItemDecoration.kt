package com.nawstuff.cahyadi.clubmatch2.utilities

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

//modification code

class SpaceItemDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (outRect != null && parent != null) {
            var position = parent.getChildAdapterPosition(view)
            outRect.left = spacing
            outRect.right = spacing
            outRect.bottom = spacing

            if (position < 1) outRect.top = spacing
        }
    }
}