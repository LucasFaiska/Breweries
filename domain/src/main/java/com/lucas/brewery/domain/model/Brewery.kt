package com.lucas.brewery.domain.model

data class Brewery (
    val id: String,
    val name: String,
    val type: String,
    val address: String,
    val city: String,
    val postalCode: String,
    val country: String,
    val longitude: String,
    val latitude: String,
    val phone: String,
    val site: String,
    val state: String
)