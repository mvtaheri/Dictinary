package com.plcoding.dictionary.feature.domain.use_case

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature.domain.model.WordInfo
import com.plcoding.dictionary.feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank())
            return flow {}
        return repository.getWordInfo(word)
    }
}