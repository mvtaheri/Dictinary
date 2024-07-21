package com.plcoding.dictionary.feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.dictionary.feature.data.remote.dto.MeaningDto
import com.plcoding.dictionary.feature.data.remote.dto.PhoneticDto
import com.plcoding.dictionary.feature.domain.model.Meaning
import com.plcoding.dictionary.feature.domain.model.WordInfo

@Entity(tableName = "wordinfoentity")
data class WordInfoEntity(
    val meanings: List<Meaning>?,
    val phonetic: String?,
    val word: String?,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo() = WordInfo(
        meanings = meanings,
        phonetic = phonetic,
        word = word
    )
}
