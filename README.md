# Custom Exceptions

This project demonstrates how to implement custom error handling and apply the DRY (Don't Repeat Yourself) principle in UseCases and Repositories using the MVI (Model-View-Intent) architecture pattern in an Android app.

The focus of this project is to provide an efficient and reusable framework for handling errors, reducing code repetition, and managing API calls and their responses in a clean and structured way.

## 📂 Project Structure

```bash
android/
  ├── exceptions/
  │   └── CustomException.kt
  ├── extensions/
  │   └── LifecycleExtensions.kt
core/
  ├── interactor/
  │   └── NetworkCallWrapper.kt
di/
  ├── CustomErrorsApp.kt
  ├── RemoteModule.kt
  └── RepositoryModule.kt
feature/
  ├── posts/
  │   ├── data/
  │   │   ├── model/
  │   │   │   └── PostDto.kt
  │   │   ├── remote/
  │   │   │   └── ApiAS.kt
  │   │   └── repository/
  │   │       └── PostsRepo.kt
  ├── domain/
  │   ├── model/
  │   │   └── Post.kt
  │   ├── repository/
  │   │   └── IPostsRepo.kt
  │   ├── useCase/
  │   │   └── GetAllPostsUC.kt
  │   └── presentation/
  │       ├── state/
  │       └── viewModel/
  │           └── MainVM.kt
utils/
  └── IBaseMapper.kt
```

## 🛠️ Technologies

- Kotlin
- Hilt for Dependency Injection
- Retrofit for API calls
- StateFlow for reactive state management
- Clean Architecture principles

## ✨ Getting Started

Clone the repository:

git clone https://github.com/Mohamed-Ayad902/Custom-Exceptions.git
cd Custom-Exceptions

Open the project in Android Studio.

Sync Gradle and build the project.

Start coding!

## 📄 Contribution

Contributions are welcome! Feel free to open issues or submit pull requests to improve this template.

## 📜 License

This project is licensed under the MIT License. See the LICENSE file for details.

## ⭐ Star the Project if You Found It Useful! ⭐
If you found this project helpful, please give it a ⭐! Your support helps improve the project and makes it more visible for others.
