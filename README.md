# Campground Explorer — Lab 6

## Overview

Campground Explorer is an Android application built with Kotlin that allows users to explore U.S. national parks and campgrounds using data from the National Park Service (NPS) API.

This project focuses on Android fragments, bottom navigation, API requests, RecyclerView, and displaying detailed campground information.

## Features

- **Parks:** Browse national parks retrieved from the National Park Service API.
- **Campgrounds:** Explore campground information in a dedicated tab.
- **Bottom Navigation:** Switch between Parks and Campgrounds.
- **Campground Details:** Select a campground to view additional information.
- **API Integration:** Retrieve park and campground data from the NPS API.
- **RecyclerView:** Display lists of parks and campgrounds.
- **Scrollable Details:** Read campground descriptions on the detail screen.

## Demo Video

Watch the Lab 6 application demonstration:

[**View Lab 6 Demo Video**](./Lab6.mp4)

## Technologies Used

- Kotlin
- Android Studio
- Android Fragments
- View Binding
- RecyclerView
- AsyncHttpClient
- Kotlin Serialization
- National Park Service API
- Git and GitHub

## Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/txdav/Lab-6.git
   ```

2. Open the project in Android Studio.
3. Configure your National Park Service API key using the project's existing `apikey.properties` and Gradle configuration.
4. Allow Gradle to sync and download the required dependencies.
5. Start an Android emulator or connect an Android device.
6. Click **Run** in Android Studio to launch the application.

**Note:** Keep your API key private. Do not commit API keys or other secrets to GitHub.

## API Reference

This application uses the National Park Service API to retrieve park and campground information.

- [National Park Service API Documentation](https://www.nps.gov/subjects/developer/api-documentation.htm)

An API key is required to make requests.

## Project Purpose

This project was developed as part of CodePath's Intermediate Android Development curriculum. It builds on Android application fundamentals by incorporating fragments, bottom navigation, API integration, and structured data display.

## Repository

[**View the Lab 6 GitHub Repository**](https://github.com/txdav/Lab-6)

## Author

Developed as part of CodePath AND102 — Intermediate Android Development.

## License

This project was created for educational purposes.
