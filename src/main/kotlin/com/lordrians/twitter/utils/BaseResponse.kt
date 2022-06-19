package com.lordrians.twitter.utils

data class BaseResponse<T>(
    val status: Boolean,
    val message: String,
    val data: T
)

data class ResponseSuccess<T>(
    val status: Boolean = true,
    val data: T
)

data class ResponseError<T>(
    val status: Boolean = false,
    val message: String
)

fun <T> tryCatch(
    codeBlock: () -> Result<T>
): Result<T> =
    try {
        codeBlock.invoke()
    } catch (e: Exception){
        Result.Error(e)
    }

sealed class Result<out T>{
    data class Success<S>(val data: S): Result<S>()
    data class Error(val error: Exception): Result<Nothing>()
}

val <T> Result<T>.data : T
    get() = when(this){
        is Result.Success -> this.data
        is Result.Error -> throw error
    }

val <T> Result<T>.error : Exception
    get() = (this as Result.Error).error

abstract class Mapper<SourceType,ResultType>{
    abstract fun map(dataModel: SourceType): ResultType
}

class SuccessToResMapper : Mapper<Result<Any>,BaseResponse<Any>>(){
    override fun map(dataModel: Result<Any>): BaseResponse<Any> {
        return BaseResponse(
            status = true,
            message = "OK",
            data = dataModel.data
        )
    }
}

class ErrorToResMapper : Mapper<String?,BaseResponse<String>>(){
    override fun map(dataModel: String?): BaseResponse<String> {
        return BaseResponse(
            status = false,
            message = "NOT OK",
            data = dataModel ?: "Server Not OK"
        )
    }
}