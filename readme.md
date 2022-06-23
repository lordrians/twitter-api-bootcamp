# Twitter Simple API

## Base url

```
https://twitter-api-bootcamp.herokuapp.com/v1
```

## Table endpoints
### Student

| Name                       | Endpoint      | Method   | Body and response               |
|----------------------------|---------------|----------|---------------------------------|
| Get all                    | `/tweet`      | `GET`    | [example](#twitter---get-all)   |
| Get by id                  | `/tweet/{id}` | `GET`    | [example](#twitter---get-by-id) |
| Add new                    | `/tweet`      | `POST`   | [example](#twitter---add-new)   |
| Update                     | `/tweet`      | `PUT`    | [example](#twitter---update)    |
| Remove                     | `/tweet`      | `DELETE` | [example](#twitter---remove)    |

---

## Twitter Examples
### Twitter - Get All

```
GET /student
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": [
    {
      "id": "2",
      "message": "zxcvzxcvzv",
      "time": 1611585537909
    },
    {
      "id": "3",
      "message": "zxcvzxcvzv",
      "time": 1611585537909
    },
    {
      "id": "1",
      "message": "asdfafd",
      "time": 1655585537909
    }
  ]
}
```

### Twitter - Get By Id

```
GET /tweet/{id}
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": {
    "id": "1",
    "message": "asdfafd",
    "time": 1655585537909
  }
}
```

### Twitter - Add New

```
POST /tweet
```

Body

```json
{
  "id" : "5",
  "message" : "BBBBB",
  "time" : 1655585537909
}
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": [
    {
      "id": "2",
      "message": "zxcvzxcvzv",
      "time": 1611585537909
    },
    {
      "id": "3",
      "message": "zxcvzxcvzv",
      "time": 1611585537909
    },
    {
      "id": "1",
      "message": "asdfafd",
      "time": 1655585537909
    },
    {
      "id": "5",
      "message": "BBBBB",
      "time": 1655585537909
    }
  ]
}
```

### Twitter - Update

```
PUT /tweet
```
Body

```json
{
  "id" : "5",
  "message" : "CCCCCC",
  "time" : 1611585537903
}
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": [
    {
      "id": "2",
      "message": "zxcvzxcvzv",
      "time": 1611585537909
    },
    {
      "id": "3",
      "message": "zxcvzxcvzv",
      "time": 1611585537909
    },
    {
      "id": "1",
      "message": "asdfafd",
      "time": 1655585537909
    },
    {
      "id": "5",
      "message": "CCCCCC",
      "time": 1611585537903
    }
  ]
}
```

### Twitter - Remove

```
DELETE /tweet/{id}
```

Response

```json
{
  "status": true,
  "message": "OK",
  "data": [
    {
      "id": "2",
      "message": "zxcvzxcvzv",
      "time": 1611585537909
    },
    {
      "id": "3",
      "message": "zxcvzxcvzv",
      "time": 1611585537909
    },
    {
      "id": "1",
      "message": "asdfafd",
      "time": 1655585537909
    }
  ]
}
```
