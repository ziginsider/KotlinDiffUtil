package io.github.ziginsider.kotlindiffutil.adapter

import android.support.v7.util.DiffUtil
import io.github.ziginsider.kotlindiffutil.model.User

/**
 * Created by zigin on 16.01.2018.
 */
class DiffUtilCallback(private val oldItems: List<User>,
                                private val newItems: List<User>): DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldItems[oldItemPosition].id == newItems[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldItems[oldItemPosition] == newItems[newItemPosition]
}