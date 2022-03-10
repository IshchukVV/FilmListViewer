package com.example.filmlistviewer.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmlistviewer.BuildConfig.*
import com.example.filmlistviewer.network.APIService
import java.lang.Exception

class MoviePagingSource(private val apiService: APIService) :
    PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val nextPage: Int = params.key ?: FIRST_PAGE_INDEX
            val response = apiService.getMovieList(GET_TYPE, nextPage, ORDER, API_KEY)
            var nextPageNumber: Int? = null
            if (response.has_more) {
                nextPageNumber = nextPage + 20
                println(nextPageNumber)
            }
            LoadResult.Page(data = response.results, prevKey = null, nextKey = nextPageNumber)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 0
    }

}