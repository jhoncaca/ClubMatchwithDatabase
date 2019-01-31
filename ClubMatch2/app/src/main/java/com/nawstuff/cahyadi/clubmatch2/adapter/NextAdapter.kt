package com.nawstuff.cahyadi.clubmatch2.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nawstuff.cahyadi.clubmatch2.R
import com.nawstuff.cahyadi.clubmatch2.model.Event
import com.nawstuff.cahyadi.clubmatch2.model.Team
import com.nawstuff.cahyadi.clubmatch2.view.FootBallMatchUI
import com.nawstuff.cahyadi.clubmatch2.view.activities.detail.DetailActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity


class NextAdapter(private val matchs: List<Event>) : RecyclerView.Adapter<NextViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NextViewHolder {
        return NextViewHolder(FootBallMatchUI().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = matchs.size

    override fun onBindViewHolder(p0: NextViewHolder, p1: Int) {
        p0.bindItem((matchs[p1]))
    }


}

class NextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val timSchedule: TextView = view.find(R.id.txt_schedule)
    private val homeTeam: TextView = view.find(R.id.txt_hometeam)
    private val homeScore: TextView = view.find(R.id.txt_homescore)
    private val awayScore: TextView = view.find(R.id.txtawayscore)
    private val awayTeam: TextView = view.find(R.id.txt_awayteam)

    fun bindItem(matches: Event) {
        timSchedule.text = matches.dateEvent
        homeTeam.text = matches.strHomeTeam
        homeScore.text = matches.intHomeScore
        awayScore.text = matches.intAwayScore
        awayTeam.text = matches.strAwayTeam

        val ctx = itemView.context

        itemView.setOnClickListener {
            ctx.startActivity<DetailActivity>(
                ctx.getString(R.string.item_eventdetail_id) to matches.idEvent,
                ctx.getString(R.string.item_home_id) to matches.idHomeTeam,
                ctx.getString(R.string.item_away_id) to matches.idAwayTeam
            )
        }
    }


}