# mini-bcr

## Requirements

- Maven version 4.0.0+
- Java 11
- PostgresSQL

## Local Build Instructions

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

## Solr Configuration

- Follow the instructions [here](https://solr.apache.org/guide/6_6/installing-solr.html#installing-solr) to install
  Solr. Choose the binary files.
- After extracting the Solr distribution archive to a directory of your choosing, start a solr cloud session by running
  `bin/solr -e cloud` from the Solr directory.
- Follow the steps and create a collection called resources.
- Add SOLR_HOST to your environment variables and set its value.

## Docker Build Instructions

Make sure docker and docker-compose are installed on your machine before running -the following commands from the
project directory:

- `mvn clean install`
- `docker-compose up --build`

You also need to create your own `.env` file in the main directory with the following keys:
```bash
SPRING_DATASOURCE_URL=xxx
SPRING_DATASOURCE_USERNAME=xxx
SPRING_DATASOURCE_PASSWORD=xxx
POSTGRES_USER=xxx
POSTGRES_PASSWORD=xxx
POSTGRES_DB=xxx
API_KEY=xxx
API_SECRET_KEY=xxx
ACCESS_TOKEN=xxx
ACCESS_TOKEN_SECRET=xxx
BEARER_TOKEN=xxx
SPRING_KAFKA_BOOTSTRAP_SERVERS=xxx
SOLR_HOST=xxx
KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181
KAFKA_LISTENERS=LISTENER_INTERNAL://kafka:29092,LISTENER_EXTERNAL://kafka:9092
KAFKA_ADVERTISED_LISTENERS=LISTENER_INTERNAL://kafka:29092,LISTENER_EXTERNAL://kafka:9092
KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=LISTENER_INTERNAL:PLAINTEXT,LISTENER_EXTERNAL:PLAINTEXT
KAFKA_INTER_BROKER_LISTENER_NAME=LISTENER_INTERNAL
```

## How to use

The API has a couple of endpoints to mainly fetch and update mentions and queries.

### Get `/mentions`

Returns all mentions stored in the DB.

### Get `/mentions/{id}`

Returns the mention with the given ID if present, otherwise returns an error message.

### Get `/queries`

Returns all queries stored in the DB.

### Post `/queries`

Inserts a query to the DB. Query parameters (text) should be specified in the request. For
example: `POST "/queries?definition=myKeyword"`

### Get `/queries/{id}`

Returns the query with the given ID if present, otherwise returns an error message.

### Delete `/queries/{id}`

Deletes query with given id from the DB if present, otherwise returns an error message
