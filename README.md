# Cooking Recipe App

This is a cooking recipe app built using the MVVM pattern in Android. The app allows users to browse through various recipes, search for specific recipes, and save their favorite recipes for future reference.

# Features

Browse through a list of various recipes.
Search for specific recipes using keywords.
View recipe details such as ingredients and instructions.
Save your favorite recipes for future reference.

# Architecture

This app is built using the Model-View-ViewModel (MVVM) architecture pattern. This pattern separates the app into three layers:

Model: This layer contains the data and business logic of the app. In this app, the Recipe class represents the data model for each recipe.
View: This layer is responsible for displaying the UI to the user. In this app, the MainActivity and RecipeDetailActivity classes represent the views.
ViewModel: This layer is responsible for handling the communication between the view and the model. In this app, the RecipeViewModel class represents the view model.
The MVVM pattern allows for a clean separation of concerns and makes it easy to test each layer of the app independently.

# Libraries Used

This app uses the following libraries:

LiveData: Used to observe changes in data and update the UI accordingly.
ViewModel: Used to store and manage UI-related data.
Retrofit: Used to make HTTP requests to the backend API.
Glide: Used to load and display images.
Room: Used to cache recipe data locally.

# Contributing

Contributions are always welcome! If you would like to contribute to this project, please fork the repository and create a pull request with your changes.

# License

This project is licensed under the MIT License - see the LICENSE file for details.
