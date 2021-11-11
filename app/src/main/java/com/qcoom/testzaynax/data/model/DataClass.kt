package com.qcoom.testzaynax.data.model

data class DataClass (
    val items: MutableList<ItemClass>,
    val total: Int,
    val totalPages: Int,
    val pageNumber: Int,
    val nextPage: Int,
)

data class ItemClass(
    val id: String,
    val name: String,
    val phoneNumber: String,
)