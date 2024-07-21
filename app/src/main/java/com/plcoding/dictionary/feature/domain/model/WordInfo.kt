package com.plcoding.dictionary.feature.domain.model

data class WordInfo(
    val meanings: List<Meaning>?,
    val phonetic: String?,
    val word: String?
) {

}
