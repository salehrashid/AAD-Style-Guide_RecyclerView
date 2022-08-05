package com.app.recyclerview.custom_json_recyclerview

data class ModelCake(
    var id: String = "",
    var type: String? = null,
    val batters: Batter
)

data class Batter(
    val batter: ArrayList<BatterItem>
)

data class BatterItem(
    var id: String = "",
    var type: String? = null
)
