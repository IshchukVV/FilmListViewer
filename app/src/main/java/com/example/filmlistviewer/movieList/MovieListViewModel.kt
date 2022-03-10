package com.example.filmlistviewer.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.filmlistviewer.data.Result
import com.example.filmlistviewer.network.APIService
import com.example.filmlistviewer.network.RetroInstance
import com.example.filmlistviewer.data.MoviePagingSource
import kotlinx.coroutines.flow.Flow

class MovieListViewModel : ViewModel() {
    var apiService: APIService = RetroInstance.getRetrofitInstance().create(
        APIService::class.java
    )

    fun getListData(): Flow<PagingData<Result>> {
        return Pager(config = PagingConfig(pageSize = 20, maxSize = 200),
        pagingSourceFactory = { MoviePagingSource(apiService) }).flow.cachedIn(viewModelScope)

    }
}