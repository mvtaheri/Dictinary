package com.plcoding.dictionary.feature.data.remote

import com.plcoding.dictionary.feature.data.remote.dto.WordInfoDto
import retrofit2.http.Path
import retrofit2.http.GET

interface DictionaryApi {
    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto>

    companion object{
        const val BASE_URL = "https://api.dictionaryapi.dev"
    }

}