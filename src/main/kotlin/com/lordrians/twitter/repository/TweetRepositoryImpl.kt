package com.lordrians.twitter.repository

import com.lordrians.twitter.database.DatabaseComponent
import com.lordrians.twitter.tweet.Tweet
import com.lordrians.twitter.utils.Result
import com.lordrians.twitter.utils.data
import com.lordrians.twitter.utils.tryCatch
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*
import org.litote.kmongo.util.idValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TweetRepositoryImpl: TweetRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private val listTweet : MutableList<Tweet> = mutableListOf()

    init {
        listTweet += mutableListOf(
            Tweet("1","Halo ges",System.currentTimeMillis()),
            Tweet("2","Kenapa ges",System.currentTimeMillis()),
            Tweet("3","Gapapa ges",System.currentTimeMillis())
        )
    }

    private fun tweetCollection(): MongoCollection<Tweet> =
        databaseComponent.database.getDatabase("twitter").getCollection()

    override fun getAll(): Result<List<Tweet>> =
        tryCatch {
            val listTweet = tweetCollection().find().toList()
            Result.Success(listTweet)
        }

    override fun getById(id: String): Result<Tweet> =
        tryCatch {
            val tweet = tweetCollection().findOne(Tweet::id eq id)
            if (tweet != null){
                Result.Success(tweet)
            } else {
                throw Exception("Data kosong")
            }
        }

    override fun add(tweet: Tweet): Result<List<Tweet>> =
        tryCatch {
            tweetCollection().findOne(Tweet::id eq tweet.id).run {
                if (this != null)
                    throw Exception("Data Sudah Ada")
                else {
                    tweetCollection().insertOne(tweet)
                    Result.Success(getAll().data)
                }
            }
        }

    override fun update(tweet: Tweet): Result<List<Tweet>> =
        tryCatch {
            tweetCollection().updateOne(
                Tweet::id eq tweet.id,
                tweet
            ).run {
                if (this.matchedCount.toInt() == 0){
                    throw Exception("Data tidak ditemukan")
                } else {
                    Result.Success(getAll().data)

                }
            }
        }

    override fun delete(id: String): Result<List<Tweet>> =
        tryCatch {
            tweetCollection().deleteOne(
                Tweet::id eq id
            ).run {
                if (this.deletedCount.toInt() != 0){
                    Result.Success(getAll().data)
                } else {
                    throw Exception("Data tidak ditemukan")
                }
            }
        }
}