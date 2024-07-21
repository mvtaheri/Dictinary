package com.plcoding.dictionary.feature.domain.repository

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature.data.local.WordInfoDao
import com.plcoding.dictionary.feature.data.local.WordInfoDatabase
import com.plcoding.dictionary.feature.data.remote.DictionaryApi
import com.plcoding.dictionary.feature.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class WordInfoRepositroyImpl(
    private val api: DictionaryApi,
    private val db: WordInfoDao
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfo = db.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfo))
        try {
            val remoteWordInfo = api.getWordInfo(word)
            db.deleteWordInfos(remoteWordInfo.map { it.word })
            db.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error("something went wrong", wordInfo))

        } catch (e: IOException) {
            emit(Resource.Error("could not reach server, check your internet connection", wordInfo))
        }
        val newWordInfo = db.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}