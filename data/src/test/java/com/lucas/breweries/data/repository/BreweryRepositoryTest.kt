package com.lucas.breweries.data.repository

import androidx.paging.PagingData
import com.lucas.breweries.data.core.remote.network.NetworkResponse
import com.lucas.breweries.data.datasource.BreweryDataSource
import com.lucas.breweries.data.mapper.toBrewery
import com.lucas.breweries.data.util.breweriesResponseListMock
import com.lucas.breweries.domain.repository.BreweryRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BreweryRepositoryTest {

    private lateinit var repository: BreweryRepository

    @MockK
    private lateinit var breweryDataSource: BreweryDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository =
            BreweryRepositoryImpl(breweryDataSource, StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `Given getBreweries is called, when repository is invoked, then return a flow of PagingData of Brewery`() =
        runTest {
            val expectedResult =
                PagingData.from(breweriesResponseListMock.map { it.toBrewery() })

            // Given
            coEvery { breweryDataSource.getBreweries(any()) } returns NetworkResponse.Success(
                breweriesResponseListMock
            )

            // When
            val result = repository.getBreweries()

            // Then
            assertEquals(expectedResult, result)
        }

}