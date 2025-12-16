

---

# 🌤️ Jetpack Compose Weather App

<p align="left">
  <img src="https://img.shields.io/badge/Kotlin-1.9+-7F52FF?style=flat&logo=kotlin&logoColor=white"/>
  <img src="https://img.shields.io/badge/Android-Platform-3DDC84?style=flat&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/Jetpack%20Compose-UI-4285F4?style=flat&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/MVVM-Architecture-blue?style=flat"/>
  <img src="https://img.shields.io/badge/Clean%20Architecture-Yes-success?style=flat"/>
</p>

A **production-style Android weather application** built with **Jetpack Compose** that delivers real-time weather data and forecasts using a clean, scalable architecture. The project demonstrates modern Android development practices including state-driven UI, offline caching, dependency injection, and background processing.

---

## 👀 What Recruiters Should Notice

* Built entirely with **Jetpack Compose** (no XML)
* Follows **Clean Architecture + MVVM**
* Uses **industry-standard Android libraries**
* Handles **offline caching & background updates**
* Clear separation of **UI, domain, and data layers**
* Real API integration with error handling

---

## 📌 Project Summary

The application fetches weather data from the **OpenWeather API** and presents current conditions and forecasts based on the user’s location or searched cities. Weather data is cached locally to ensure usability even without an internet connection.

The app is structured for **maintainability, testability, and scalability**, making it suitable as a reference for real-world Android projects.

---

## ✨ Core Features

* Location-based weather detection
* City search with persistent storage
* Current weather and multi-day forecast
* Offline support using local database caching
* Automatic refresh when connectivity is restored
* Smooth, responsive UI with Compose
* Robust error and state handling

---

## 🛠️ Tech Stack

* **Language:** Kotlin
* **UI Framework:** Jetpack Compose
* **Architecture:** MVVM + Clean Architecture
* **Dependency Injection:** Hilt
* **Networking:** Retrofit
* **Local Storage:** Room
* **Concurrency:** Kotlin Coroutines & Flow
* **Background Work:** WorkManager
* **API:** OpenWeatherMap

---

## 🔄 Application Flow

1. Detects user location (with permission)
2. Fetches weather data from the remote API
3. Stores responses locally for offline access
4. Updates UI reactively using state management
5. Allows users to search and save cities

---

## ▶️ Getting Started

1. Clone the repository
2. Open the project in **Android Studio**
3. Add your OpenWeather API key in the constants file
4. Sync Gradle and run on an emulator or device

---

## 🔐 Permissions Used

* Internet access
* Fine location access

---

## 🎯 Why This Project Is Valuable

This project showcases:

* Modern Android UI development with Compose
* Clean, scalable app architecture
* Practical API consumption and persistence
* Real-world handling of background tasks and offline data

It reflects the skills required for **Android Developer / Mobile Engineer** roles.

---

## 📄 Documentation

Additional documentation explaining architecture and design decisions is included in the repository.

---
