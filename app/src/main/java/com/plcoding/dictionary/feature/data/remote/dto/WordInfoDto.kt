package com.plcoding.dictionary.feature.data.remote.dto

import com.plcoding.dictionary.feature.data.local.entity.WordInfoEntity
import com.plcoding.dictionary.feature.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>?,
    val phonetic: String?,
//    val phonetics: List<PhoneticDto>?,
//    val sourceUrls: List<String>?,
    val word: String
) {
    fun toWordInfo() = WordInfo(
        meanings = meanings?.map { it.toMeaning() },
        phonetic = phonetic,
        word = word
    )

    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings?.map { it.toMeaning() },
            phonetic = phonetic,
            word = word
        )
    }

}