# Java Data Structures & Algorithms

A personal repository dedicated to implementing and mastering common Data Structures and Algorithms (DSA) using Java.
This project serves as a learning tool and a collection of well-documented, tested, and efficient solutions to classic
computer science problems.

## ✨ Features

- **Clear & Documented Code**: Every solution is written with clarity in mind and includes comprehensive Javadoc
  comments explaining the approach, time complexity, and space complexity.
- **High Test Coverage**: Solutions are backed by a robust suite of JUnit 5 tests to ensure correctness and handle edge
  cases.
- **Code Quality Enforcement**: The project is configured with JaCoCo to enforce 100% line and branch coverage, ensuring
  a high standard of quality.
- **Multiple Approaches**: For many problems, multiple solutions are provided to compare different algorithmic
  trade-offs (e.g., Sliding Window vs. Frequency Map).
- **Modern Gradle Build**: A clean, modern Gradle setup for easy dependency management and build automation.

## 📂 Project Structure

The project is organized by data structure, making it easy to navigate and find specific problems. Each problem resides
in its own subpackage.

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- Gradle is included via the Gradle Wrapper (`gradlew`).

### Building the Project

You can build the project and run all checks (including tests and code coverage verification) using the following
command:

`gradle clean build`

## 📈 Code Quality & Coverage

This project uses **JaCoCo** to measure and enforce test coverage. After running the _check_ task, you can find a
detailed HTML report in the `build/jacocoHtml` directory.

The build is configured to fail if the test coverage drops below the following thresholds:

* Line Coverage: 100%
* Branch Coverage: 100%

## 🤝 Contributing

While this is primarily a personal learning project, suggestions, bug reports, and contributions are welcome! Please
feel free to open an issue or submit a pull request.

## 📄 License

This project is licensed under the MIT License. See the LICENSE file for details.
