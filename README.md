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

In order to use your own developer credentials, create a JSON file and store the credentials within

#### Using a json file

File example :

```
{
  "apiKey": "xxx",
  "apiSecretKey": "xxx",
  "bearerToken": "xxx"
}
```

##### With program argument

Pass through java argument your file path like `-Dtwitter.credentials.file.path=/your/path/to/json`
This can be done in intelliJ by editing the configuration and adding the same line to VM arguments

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
