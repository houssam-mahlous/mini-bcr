# mini-bcr

## Requirements

- Maven version 4.0.0+
- Java 11
- PostgresSQL

## Build Instructions

Make sure maven is installed on your machine. Then build by running

- `mvn clean`
- `mvn -B package --file pom.xml`

from inside the project directory.

## Twitter Client Configuration

There are multiple ways to use your own developer credentials

### Using a json file

File example :

`{"apiKey": "xxx","apiSecretKey": "xxx","accessToken": "xxx","accessSecretToken": "xxx","bearerToken": "xxx"}`

#### With program argument

Pass through java argument your file path like `-Dtwitter.credentials.file.path=/your/path/to/json`
This can be done in intelliJ by editing the configuration and adding the same line to VM arguments

### Using application.properties file

Just set up the following twitter credentials in your environment(the `application.properties` file in this project
already has defined parameters) :

`ACCESS_TOKEN=<your_access_token>`

`ACCESS_TOKEN_SECRET=<your_access_token_secret>`

`API_KEY=<your_api_key>`

`API_SECRET_KEY=<your_api_secret_key>`

`BEARER_TOKEN=<your_bearer_token>`

NB : Your twitter credentials can be found in [your twitter app page](https://developer.twitter.com/en/apps)

## Kafka Configuration

- Follow the instructions [here](https://kafka.apache.org/quickstart) to download and start the Kafka environment.
- Create a kafka topic called resources :
  `bin/kafka-topics.sh --create --topic resources --bootstrap-server localhost:9092`
- Add KAFKA_BOOTSTRAP_SERVERS to your environment variables (in this case, value is `localhost:9092`)

## How to use

The API has a couple of endpoints to mainly fetch and update mentions and queries.

### Get `/mentions`

Returns all mentions stored in the DB.

### Post `/mentions`

Inserts a mention to the DB. Mention parameters (text) should be specified in the request. For
example: `POST "/mentions?text=This is a tweet"`

### Get `/mentions/{id}`

Returns the mention with the given ID if present, otherwise returns an error message.

### Delete `/mentions/{id}`

Deletes mention with given id from the DB if present, otherwise returns an error message.

### Get `/queries`

Returns all queries stored in the DB.

### Post `/queries`

Inserts a query to the DB. Query parameters (text) should be specified in the request. For
example: `POST "/queries?definition=myKeyword"`

### Get `/queries/{id}`

Returns the query with the given ID if present, otherwise returns an error message.

### Delete `/queries/{id}`

Deletes query with given id from the DB if present, otherwise returns an error message
