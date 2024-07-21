package com.plcoding.dictionary.feature.presentation

import com.plcoding.dictionary.feature.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)