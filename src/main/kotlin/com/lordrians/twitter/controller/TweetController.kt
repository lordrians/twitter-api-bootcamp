package com.lordrians.twitter.controller

import com.lordrians.twitter.service.TweetService
import com.lordrians.twitter.tweet.Tweet
import com.lordrians.twitter.utils.BaseResponse
import com.lordrians.twitter.utils.ErrorToResMapper
import com.lordrians.twitter.utils.Result
import com.lordrians.twitter.utils.SuccessToResMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/tweet")
class TweetController {

    @Autowired
    lateinit var tweetService: TweetService

    @GetMapping
    fun getAll() =
        when(val result = tweetService.getAll()){
            is Result.Success -> {
                SuccessToResMapper().map(result)
            }
            is Result.Error -> {
                ErrorToResMapper().map(result.error.message)
            }
        }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable(value = "id") id: String
    ) =
        when(val result = tweetService.getById(id)){
            is Result.Success -> {
                SuccessToResMapper().map(result)
            }
            is Result.Error -> {
                ErrorToResMapper().map(result.error.message)
            }
        }

    @PostMapping
    fun add(
        @RequestBody tweet: Tweet
    ) =
        when(val result = tweetService.add(tweet)){
            is Result.Success -> {
                SuccessToResMapper().map(result)
            }
            is Result.Error -> {
                ErrorToResMapper().map(result.error.message)
            }
        }

    @PutMapping
    fun update(
        @RequestBody tweet: Tweet
    ) =
        when(val result = tweetService.update(tweet)){
            is Result.Success -> {
                SuccessToResMapper().map(result)
            }
            is Result.Error -> {
                ErrorToResMapper().map(result.error.message)
            }
        }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable(value = "id" ) id: String
    ) =
        when(val result = tweetService.delete(id)){
            is Result.Success -> {
                SuccessToResMapper().map(result)
            }
            is Result.Error -> {
                ErrorToResMapper().map(result.error.message)
            }
        }
}