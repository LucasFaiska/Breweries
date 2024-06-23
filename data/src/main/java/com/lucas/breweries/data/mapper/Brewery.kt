package com.lucas.breweries.data.mapper

import com.lucas.breweries.data.core.remote.dto.BreweryResponse
import com.lucas.breweries.domain.model.Brewery

fun BreweryResponse.toBrewery() = Brewery(
    id = id,
    name = name,
    type = breweryType,
    address = address1,
    city = city,
    postalCode = postalCode,
    country = country,
    longitude = longitude,
    latitude = latitude,
    phone = phone,
    site = websiteUrl.orEmpty(),
    state = state
)