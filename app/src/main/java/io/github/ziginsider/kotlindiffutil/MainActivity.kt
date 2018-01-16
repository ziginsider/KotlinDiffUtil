package io.github.ziginsider.kotlindiffutil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import io.github.ziginsider.kotlindiffutil.adapter.DiffUtilCallback
import io.github.ziginsider.kotlindiffutil.adapter.UserAdapter
import io.github.ziginsider.kotlindiffutil.mock.MockDataProvider
import io.github.ziginsider.kotlindiffutil.model.User
import io.github.ziginsider.kotlindiffutil.utils.toast
import io.github.ziginsider.kotlindiffutil.adapter.listener.UserClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UserClickListener {

    private var recyclerAdapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = MockDataProvider().data

        updateAdapter(users)



        bottomNavigation.setOnNavigationItemSelectedListener {
            item: MenuItem ->
            when (item.itemId) {
                R.id.sortName -> {
                    users.sortBy { it.name }
                    updateAdapter(users)
                    toast("fff")
                }
                R.id.sortAge -> {
                    users.sortBy { it.age }
                    //updateAdapter(users)
                    //setUpRecyclerView(users)
                    val result = recyclerAdapter?.getDiffUtilResult(users)
                    recyclerAdapter?.setItems(users)
                    result?.dispatchUpdatesTo(recyclerAdapter)

                }
                R.id.delEven -> {}
            }
            true
        }
    }

    private fun updateAdapter(userList: List<User>) {
        recyclerAdapter?.update(userList) ?: setUpRecyclerView(userList)
    }

    private fun setUpRecyclerView(userList: List<User>) {
        recyclerAdapter = UserAdapter(userList, this)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
            adapter = recyclerAdapter
            //scheduleLayoutAnimation()
        }
    }

    override fun onUserClicked(user: User) {
        toast("I'm user ${user.name}")
    }
}

