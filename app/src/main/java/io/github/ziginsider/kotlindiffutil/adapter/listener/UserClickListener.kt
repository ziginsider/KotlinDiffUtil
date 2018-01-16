package io.github.ziginsider.kotlindiffutil.adapter.listener

import io.github.ziginsider.kotlindiffutil.model.User

/**
 * Created by zigin on 16.01.2018.
 */
interface UserClickListener {
    fun onUserClicked(user: User)
}