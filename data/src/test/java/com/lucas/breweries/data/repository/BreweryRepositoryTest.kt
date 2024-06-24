package com.lucas.breweries.data.repository

import androidx.paging.PagingData
import app.cash.turbine.test
import com.lucas.breweries.data.core.remote.network.NetworkResponse
import com.lucas.breweries.data.datasource.BreweryDataSource
import com.lucas.breweries.data.mapper.toBrewery
import com.lucas.breweries.data.util.CoroutineTestRule
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
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BreweryRepositoryTest {

    @get:Rule(order = 0)
    val coroutineTestRule = CoroutineTestRule(StandardTestDispatcher())

    private lateinit var repository: BreweryRepository

    @MockK
    private lateinit var breweryDataSource: BreweryDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = BreweryRepositoryImpl(
            breweryDataSource,
            coroutineTestRule.dispatcher
        )
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    // Is the first time I'm using paging 3 library and I need more time to learn
    // how to test it properly
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
        }

    @Test
    fun `Given getBrewery is called, when repository is invoked, then return a flow of Brewery`() =
        runTest {
            val id = "1"
            val expectedResult = breweriesResponseListMock.first().toBrewery()

            // Given
            coEvery { breweryDataSource.getBrewery(id) } returns NetworkResponse.Success(
                breweriesResponseListMock.first()
            )

            // When
            val result = repository.getBrewery(id)

            // Then
            result.test {
                val brewery = awaitItem()
                assertEquals(expectedResult, brewery)
            }
        }

}