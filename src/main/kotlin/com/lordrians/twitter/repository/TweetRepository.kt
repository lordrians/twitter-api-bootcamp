package com.lordrians.twitter.repository

import com.lordrians.twitter.tweet.Tweet
import com.lordrians.twitter.utils.Result

interface TweetRepository {
    fun getAll(): Result<List<Tweet>>
    fun getById(id: String): Result<Tweet>
    fun add(tweet: Tweet): Result<List<Tweet>>
    fun update(tweet: Tweet): Result<List<Tweet>>
    fun delete(id: String): Result<List<Tweet>>
}