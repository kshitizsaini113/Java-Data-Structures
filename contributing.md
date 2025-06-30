# Contributing to Java-Data-Structures

First off, thank you for considering contributing to Java-Data-Structures! It's people like you that make open source such a great community. We welcome any and all contributions, from simple bug reports to new feature implementations.

## How Can I Contribute?

*   **Reporting Bugs**: If you find a bug in the source code, please submit an issue to our GitHub repository.
*   **Suggesting Enhancements**: If you have an idea for a new feature or an improvement, please submit an issue.
*   **Writing Documentation**: We are always looking for help to improve our documentation.
*   **Submitting a Pull Request**: If you want to contribute code, you can submit a pull request with your changes.

## Pull Request Process

1.  **Fork the Repository**: Start by forking the repository to your own GitHub account.
2.  **Clone the Fork**: `git clone git@github.com:kshitizsaini113/Java-Data-Structures.git`
3.  **Create a Branch**: `git checkout -b master`
4.  **Make Changes**: Make your changes in your local repository. Ensure you add corresponding test cases for any new code.
5.  **Run Tests**: Run the test suite locally to ensure everything is working correctly.
    ```bash
    # If using Gradle
    gradle test
    ```
6.  **Commit Changes**: Commit your changes with a clear and descriptive commit message. We follow the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification.
    ```bash
    git commit -m "feat: Add new data structure with test cases"
    ```
7.  **Push Changes**: `git push origin master`
8.  **Submit a Pull Request**: Open a pull request from your forked repository to our `main` branch.

## Adding Test Cases

**All code contributions must include comprehensive test cases.** This is a strict requirement to ensure the quality and stability of the project.

*   **Requirement**: Any new data structure or algorithm implementation must be accompanied by a corresponding set of unit tests (e.g., using JUnit 5).
*   **Coverage**: Tests should cover the main functionality, edge cases (e.g., empty or null inputs), and potential failure scenarios.
*   **Validation**: Pull requests with new code but without adequate tests will not be merged.

## Styleguides

### Git Commit Messages

*   Use the present tense ("Add feature" not "Added feature").
*   Use the imperative mood ("Move cursor to..." not "Moves cursor to...").
*   Limit the first line to 72 characters or less.

### Java Styleguide

*   Follow the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).
*   Add Javadoc comments to all public methods and classes.

## Code of Conduct

This project and everyone participating in it is governed by the [Code of Conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code.

---

We look forward to your contributions!
