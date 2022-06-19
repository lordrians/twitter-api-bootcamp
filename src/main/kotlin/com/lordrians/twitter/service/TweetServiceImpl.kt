package com.lordrians.twitter.service

import com.lordrians.twitter.repository.TweetRepository
import com.lordrians.twitter.tweet.Tweet
import com.lordrians.twitter.utils.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TweetServiceImpl: TweetService {

    @Autowired
    lateinit var repository: TweetRepository

    override fun getAll(): Result<List<Tweet>> =
        repository.getAll()

    override fun getById(id: String): Result<Tweet> =
        repository.getById(id)

    override fun add(tweet: Tweet): Result<List<Tweet>> =
        repository.add(tweet)

    override fun update(tweet: Tweet): Result<List<Tweet>> =
        repository.update(tweet)

    override fun delete(id: String): Result<List<Tweet>> =
        repository.delete(id)
}