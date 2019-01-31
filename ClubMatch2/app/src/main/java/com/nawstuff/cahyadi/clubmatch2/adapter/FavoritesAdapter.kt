package com.nawstuff.cahyadi.clubmatch2.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nawstuff.cahyadi.clubmatch2.R
import com.nawstuff.cahyadi.clubmatch2.database.FavoriteParamsDB
import com.nawstuff.cahyadi.clubmatch2.view.FootBallMatchUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

import java.text.SimpleDateFormat
import java.util.*

class FavoritesAdapter(
    private val favorite: List<FavoriteParamsDB>,
    private val listener: (FavoriteParamsDB) -> Unit
) :
    RecyclerView.Adapter<FavoriteViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FavoriteViewHolder {
        return FavoriteViewHolder(FootBallMatchUI().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = favorite.size

    override fun onBindViewHolder(p0: FavoriteViewHolder, p1: Int) {
        p0.bindItem(favorite[p1], listener)
    }

}

class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val timeSchedule: TextView = view.find(R.id.txt_schedule)
    private val homeTeam: TextView = view.find(R.id.txt_hometeam)
    private val homeScore: TextView = view.find(R.id.txt_homescore)
    private val awayScore: TextView = view.find(R.id.txtawayscore)
    private val awayTeam: TextView = view.find(R.id.txt_awayteam)

    fun bindItem(favorite: FavoriteParamsDB, listener: (FavoriteParamsDB) -> Unit) {

        val timeEvent = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            .parse(favorite.eventTime)
        val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
            .format(timeEvent)

        timeSchedule.text = dateEvent.toString()
        homeTeam.text = favorite.homeTeam
        homeScore.text = favorite.homeScore
        awayScore.text = favorite.awayScore
        awayTeam.text = favorite.awayTeam

        itemView.onClick {
            listener(favorite)
        }
    }
}

