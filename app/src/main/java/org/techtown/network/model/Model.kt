package org.techtown.network.model

data class Model(
        var type: String,
        var value: List<ValueModel>
)

data class ValueModel(
        var id: String,
        var joke: String,
        var viewType: Int
)
