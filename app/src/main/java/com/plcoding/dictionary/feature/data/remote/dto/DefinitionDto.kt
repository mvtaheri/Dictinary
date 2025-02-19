package com.plcoding.dictionary.feature.data.remote.dto

import com.plcoding.dictionary.feature.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String?>?,
    val definition: String?,
    val example: String?,
    val synonyms: List<String?>?
) {
    fun toDefinition() = Definition(
        antonyms = antonyms,
        definition = definition,
        example = example,
        synonyms = synonyms
    )
}