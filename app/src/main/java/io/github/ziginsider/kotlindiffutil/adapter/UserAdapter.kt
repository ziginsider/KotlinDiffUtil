package io.github.ziginsider.kotlindiffutil.adapter

import android.support.v7.util.DiffUtil
import android.view.View
import io.github.ziginsider.kotlindiffutil.R
import io.github.ziginsider.kotlindiffutil.model.User
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Created by zigin on 16.01.2018.
 */

class UserAdapter(users: List<User>,
                  private val itemClick: User.() -> Unit = {})
    : AbstractAdapter<User>(users, R.layout.item_view) {

    override fun onItemClick(itemView: View, position: Int) {
        itemList[position].itemClick()
    }

    fun update(newItems: List<User>) {
        updateAdapterWithDiffResult(calculateDiff(newItems))
    }

    private fun updateAdapterWithDiffResult(result: DiffUtil.DiffResult) {
        result.dispatchUpdatesTo(this)
    }

    private fun calculateDiff(newItems: List<User>) =
            DiffUtil.calculateDiff(DiffUtilCallback(itemList, newItems))

    override fun View.bind(item: User) {
        userName.text = item.name
        userAge.text = item.age.toString()
    }

}