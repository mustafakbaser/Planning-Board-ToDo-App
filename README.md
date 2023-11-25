# Planning Board To-Do App

## Overview

This is a To-Do Android application developed using Java with MVVM architecture and several key libraries to enhance functionality and maintainability.

## Screenshots

Explore the visual charm of the app through these captivating screenshots:

<img src="https://github.com/mustafakbaser/Planning-Board-ToDo-App/blob/master/in-app-screenshot.png" alt="In-app screenshot" width="350" height="600" />

## Architecture - MVVM

The application follows the MVVM (Model-View-ViewModel) architecture, which separates the user interface logic from the business logic. This design pattern promotes a clean and maintainable codebase by organizing components into three main categories:

- **Model:** Represents the data and business logic of the application.
- **View:** Displays the user interface and captures user input.
- **ViewModel:** Acts as a mediator between the View and the Model, handling user input, updating the UI, and interacting with the data layer.

## Dependency Injection - Hilt

Dependency injection is crucial for decoupling components and improving testability. Hilt, a dependency injection library for Android, is used to simplify the process of providing dependencies and managing their lifecycle. By using Hilt, the application achieves a modular and scalable architecture.

## SQLite Database and Room Library

The app utilizes SQLite as the local database for storing To-Do items. Room, an abstraction layer over SQLite, simplifies database operations and provides a robust framework for data persistence. This combination allows for efficient data storage and retrieval while maintaining a structured and organized database.

## Reactive Programming - RXJava

RXJava is employed for handling asynchronous tasks and events in a reactive, stream-based manner. This library enhances the responsiveness of the application by allowing seamless execution of tasks on background threads and simplifying the management of asynchronous operations.

## Getting Started

To build and run the application locally, follow these steps:

1. Clone the repository: `https://github.com/mustafakbaser/Planning-Board-ToDo-App.git`
2. Open the project in Android Studio.
3. Build and run the application on an emulator or a physical device.

## Dependencies

- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): Dependency injection library for Android.
- [Room](https://developer.android.com/topic/libraries/architecture/room): Persistence library providing an abstraction layer over SQLite.
- [RXJava](https://github.com/ReactiveX/RxJava): Library for composing asynchronous and event-based programs using observable sequences.

## Contributing

Feel free to contribute to the project by opening issues or creating pull requests. We welcome any suggestions or improvements to enhance the functionality and user experience of the To-Do app.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
