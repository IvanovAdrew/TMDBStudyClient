package com.example.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTvShowBinding
import com.example.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter
    private lateinit var tvshowViewModel: TvShowViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)

        this.tvshowViewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)
        initRecyclerView()
        binding.swipeRefresh.setOnRefreshListener {
            updateTvshows()
        }
    }

    private fun initRecyclerView() {
        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvshowRecyclerView.adapter = adapter
        displayPopularTvshows()
    }

    private fun displayPopularTvshows() {
        binding.tvshowProgressBar.visibility= View.VISIBLE
        val responceLiveData = this.tvshowViewModel.getTvShows()
        responceLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility= View.GONE
            }else{
                binding.tvshowProgressBar.visibility= View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun updateTvshows(){
        val response = this.tvshowViewModel.updateTvShows()
        response.observe(this, Observer {
            Log.i("MYTAG",it.toString())
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.swipeRefresh.isRefreshing = false
            }else{
                binding.swipeRefresh.isRefreshing = false
            }

        })
    }
}