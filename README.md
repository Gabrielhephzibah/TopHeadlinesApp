# TopHeadlinesApp

* The application displays a list of Top Headlines for a specific source (BBC news).
* Built with Kotlin 

# Architecture
The application was built on MVVM (Model, View, View-Model) architecture and followed the single activity and multiple fragment pattern


# Major Dependencies
* **Hilt**: The app uses Hilt for dependency injection to create dependencies and improve code re-usability
* **View Binding**: The app uses view binding to bind views and layouts to reduce boilerplate code
* **Navigation Component**: The app uses a navigation component to connect between fragments
* **Retrofit**: The app uses retrofit to create network HTTP request and response
* **Kotlin flows and coroutine**: The app uses flow to perform asynchronous tasks
* **Glide**: The app uses glide for image loading and caching
* **Unit test**: The app uses Mockito and Turbine for unit testing and Truth for assertion

# Project Structure

The app has the following structure
* data: This package contains the model, remote and the repository
* di: This package contains classes responsible for dependencies injection
* ui: This package is responsible for the UI/View logic and implementation
* utils: This package is responsible for classes that are used across the application
* Gradle Scripts
    * These scripts are responsible for dependencies and plugins necessary for the project


# How to start the application

1. Download Android Studio

2. Clone or fork the repository by running the command below on your terminal

```
git clone https://github.com/Gabrielhephzibah/TopHeadlinesApp.git

```

3. Import or open the project on Android Studio

4. Open build.gradle in Android Studio and sync

5. Run the app on an emulator or directly on an Android device.


# Test
* The app contains basic unit-test cases.

# Completed Stories
* Story 1: When the user launches the application, he should land in
  a screen where is possible to see top headlines for the specific
  news source
* Story 2: When the user taps on a headline, he should be taken to a
  new screen
* Bonus Story 3: When user opens the application, it should ask for a
  fingerprint identification, if available


# Todos
* Bonus Story 4: A new flavor should be created to present news for
  another source