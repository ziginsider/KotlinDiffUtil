package io.github.ziginsider.kotlindiffutil.adapter

import android.support.v7.util.DiffUtil
import android.view.View
import io.github.ziginsider.kotlindiffutil.R
import io.github.ziginsider.kotlindiffutil.adapter.listener.UserClickListener
import io.github.ziginsider.kotlindiffutil.model.User
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Created by zigin on 16.01.2018.
 */

class UserAdapter(users: List<User>,
                  private val userClickListener: UserClickListener)
    : AbstractAdapter<User>(users, R.layout.item_view) {

    override fun onItemClick(itemView: View, position: Int) {
        userClickListener.onUserClicked(itemList[position])
    }

    fun update(newItems: List<User>) {
        val result = DiffUtil.calculateDiff(DiffUtilCallback(itemList, newItems))
        itemList = newItems
        result.dispatchUpdatesTo(this)
    }

    fun getDiffUtilResult(newItems: List<User>) = DiffUtil.calculateDiff(DiffUtilCallback(itemList, newItems))

    fun setItems(newItems: List<User>) {
        itemList = newItems
    }

    override fun View.bind(item: User) {
        userName.text = item.name
        userAge.text = item.age.toString()
        when(item.age) {
            in 0..7 -> userImage.setImageResource(R.drawable.user12)
            in 8..15 -> userImage.setImageResource(R.drawable.user9)
            in 16..23 -> userImage.setImageResource(R.drawable.user11)
            in 24..30 -> userImage.setImageResource(R.drawable.user3)
            in 31..39 -> userImage.setImageResource(R.drawable.user7)
            in 40..50 -> userImage.setImageResource(R.drawable.user8)
            in 51..58 -> userImage.setImageResource(R.drawable.user4)
            in 59..67 -> userImage.setImageResource(R.drawable.user1)
            in 68..76 -> userImage.setImageResource(R.drawable.user6)
            in 77..85 -> userImage.setImageResource(R.drawable.user2)
            in 85..92 -> userImage.setImageResource(R.drawable.user10)
            in 93..100 -> userImage.setImageResource(R.drawable.user5)
        }
    }
}