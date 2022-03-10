package com.example.filmlistviewer.data

data class MovieList(
    var num_result: Int,
    var has_more: Boolean,
    var results: List<Result>
)

data class Result(
    var display_title: String,
    var summary_short: String,
    var multimedia: Multimedia
)

data class Multimedia(
    var src: String
)