package com.example.solutionx.UI

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solutionx.APIService.AirQualityClient.airQualityApiService
import com.example.solutionx.model.AirQualityResponse
import com.example.solutionx.model.Location
import com.example.solutionx.model.LocationViewModel
import com.example.solutionx.ui.theme.SolutionXTheme
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavController, locationViewModel: LocationViewModel = viewModel()) {
// Within Home composable
    val userLocation = locationViewModel.userLocation.observeAsState(initialValue = Location(1.2921, 36.8219))

    // Define state for expanded button
    val expanded = remember { mutableStateOf(
        false) }
    // Define state for search query
    val searchQuery = remember { mutableStateOf("") }
    // Define state for air quality response
    val airQualityResponse = remember { mutableStateOf<AirQualityResponse?>(null) }
    // Coroutine scope for handling async operations

    val coroutineScope = rememberCoroutineScope()

    // Function to fetch air quality data
    fun fetchAirQualityData(location: String) {
//Fetching inside a coroutine scope since the endpoint is inside a suspend function
        coroutineScope.launch {
            // API call
            airQualityResponse.value = airQualityApiService.currentConditions(location)
        }
    }

    // Function to handle search button click
    fun onSearchClick() {
        fetchAirQualityData(searchQuery.value)
        // You can also navigate to a specific screen using navController.navigate("YourScreen")
    }

    // Function to handle search text change
    fun onSearchQueryChange(query: String) {
        searchQuery.value = query
    }

    // Function to handle clear search click
    fun onClearSearchClick() {
        searchQuery.value = ""
    }

    // Function to handle air quality data click
    fun onAirQualityDataClick() {
        // Handle click action, e.g., navigate to details screen
        navController.navigate("airQualityData")
    }

    // Function to display air quality data (Replace with actual UI)
    @Composable
    fun AirQualityDataDisplay(airQuality: AirQualityResponse) {
        // Replace this with your UI to display air quality data
     Text("Air Quality: ${airQuality.indexes.firstOrNull()?.aqi}")
    }

    // Main UI layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Row with buttons
        Row {
            // Search Bar
            OutlinedTextField(
                value = searchQuery.value,
                onValueChange = { onSearchQueryChange(it) },
                label = { Text("Search Location") },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { onClearSearchClick() }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(onSearch = {
                    onSearchClick()
                })
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Air Quality Button
            OutlinedButton(onClick = { onAirQualityDataClick() }) {
                Text(text = "Air\uD83D\uDCA8")
            }

            Spacer(modifier = Modifier.weight(0.3f))

            // Solar Intensity Button
            FilledTonalButton(onClick = { expanded.value = !expanded.value }) {
                Text(
                    text = if (expanded.value) {
                        "Solar\uD83C\uDF1E"
                    } else {
                        "Solar intensity data"
                    }
                )
            }

            Spacer(modifier = Modifier.weight(0.3f))

            // Ocean Button
            FloatingActionButton(onClick = {
                expanded.value = !expanded.value
            }) {
                Text(text = if (expanded.value) "Ocean" else "Ocean\uD83C\uDF0A")
            }

            Spacer(modifier = Modifier.weight(0.3f))
        }

        // Column with additional content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            // Elevated Button
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(
                    text = if (expanded.value) {
                        "Click learn more about these buttons\uD83D\uDE0A"
                    } else {
                        "Spoiler alert! It's about Air Quality & Solar Intensity"
                    }
                )
            }

            // Display Air Quality Data
            airQualityResponse.value?.let { AirQualityDataDisplay(it) }
        }
    }
}

@Composable
fun <T> LiveData<T>.observeAsState(initialValue: T): State<T> {
    val state = remember { mutableStateOf(initialValue) }
    val observer = Observer<T> { value ->
        state.value = value
    }
    observeForever(observer)
    DisposableEffect(this) {
        onDispose {
            removeObserver(observer)
        }
    }
    return state
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SolutionXTheme {
        Home(navController = rememberNavController())
    }
}


