package io.github.ziginsider.kotlindiffutil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.github.ziginsider.kotlindiffutil.adapter.UserAdapter
import io.github.ziginsider.kotlindiffutil.mock.MockDataProvider
import io.github.ziginsider.kotlindiffutil.model.User
import io.github.ziginsider.kotlindiffutil.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var recyclerAdapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val users = MockDataProvider().data

        updateAdapter(users)
    }

    private fun updateAdapter(userList: List<User>) {
        recyclerAdapter?.update(userList) ?: setUpRecyclerView(userList)
    }

    private fun setUpRecyclerView(userList: List<User>) {
        recyclerAdapter = UserAdapter(userList, {toast("ddd")})
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
            adapter = recyclerAdapter
            scheduleLayoutAnimation()
        }
    }
}
