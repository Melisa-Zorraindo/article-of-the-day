# Article of the day - API

A Spring Boot application that fetches and serves articles from the New York Times Top Stories API by topic.
Specifically, it exposes a REST endpoint to retrieve a single article for a topic.

## Getting started

### Prerequisites

- Java 17+
- Maven
- NYT API key ([Get one here](https://developer.nytimes.com/))

### Clone the repository

```sh
git clone https://github.com/Melisa-Zorraindo/article_of_the_day.git
cd article_of_the_day
```

### Configuration

Set your NYT API key as an environment variable.

If you're using IntelliJ, you can follow [these instructions](https://www.jetbrains.com/help/idea/program-arguments-and-environment-variables.html)
to set environment variables in your run configuration.

Alternatively, you can set it in your terminal:

```sh
export NYT_API_KEY=your-nyt-api-key
```

### Build and run

Click the Run button in your IDE from the main application class.

Alternatively, if you've set the api key in your terminal:

```sh
mvn clean install -DskipTests
mvn spring-boot:run
```


### Usage

Once your local server is up and running, send a GET request to:

```
GET http://localhost:8080/{topic}
```

Replace `{topic}` with a valid NYT section. The possible values are: arts, automobiles, books, business, fashion, food,
health, home, insider, magazine, movies, nyregion, obituaries, opinion, politics, realestate, science, sports,
sundayreview, technology, theater, t-magazine, travel, upshot, us, and world.