package com.plcoding.dictionary.feature.data.remote.dto

import com.plcoding.dictionary.feature.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String?,
) {
    fun toMeaning() = Meaning(
        definitions = definitions.map { it.toDefinition() },
        partOfSpeech = partOfSpeech
    )
}