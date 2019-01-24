package com.phellipesilva.daggerworkshop.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.phellipesilva.daggerworkshop.R
import com.phellipesilva.daggerworkshop.dagger.DaggerApplicationComponent
import com.phellipesilva.daggerworkshop.dagger.MainModule
import com.phellipesilva.daggerworkshop.database.User
import com.phellipesilva.daggerworkshop.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()

        mainPresenter.getUserFromDatabase()

        swipeRefreshLayout.setOnRefreshListener {
            mainPresenter.updateUsersFromServer()
        }
    }

    fun showUsers(users: List<User>) {
        val mainAdapter = MainAdapter(this, users)
        mainAdapter.setOnUserClickListener { mainPresenter.navigatesToFeatureTwo(it) }
        recyclerView.adapter = mainAdapter

        swipeRefreshLayout.isRefreshing = false
    }

    private fun initPresenter() {
        val applicationComponent = DaggerApplicationComponent.builder().mainModule(MainModule(this)).build()

        val mainInteractor = applicationComponent.getInteractor()
        val navigator = applicationComponent.getNavigator()
        val classA = applicationComponent.getBusinessClassA()
        val classB = applicationComponent.getBusinessClassB()
        mainPresenter = MainPresenter(this, mainInteractor, navigator, classA, classB)
    }
}
