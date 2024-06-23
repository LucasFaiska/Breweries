package com.lucas.breweries.data.mapper

import com.lucas.breweries.data.core.remote.dto.BreweryResponse
import com.lucas.breweries.domain.model.Brewery

fun BreweryResponse.toBrewery() = Brewery(
    id = id.orEmpty(),
    name = name.orEmpty(),
    type = breweryType.orEmpty(),
    address = address1.orEmpty(),
    city = city.orEmpty(),
    postalCode = postalCode.orEmpty(),
    country = country.orEmpty(),
    longitude = longitude.orEmpty(),
    latitude = latitude.orEmpty(),
    phone = phone.orEmpty(),
    site = websiteUrl.orEmpty(),
    state = state.orEmpty()
)