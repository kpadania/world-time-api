# world-time-api

**Get All Time Zone**

Returns List of All the TimeZones

URL: /api/timezone/

Method: GET

URL Params:None

Required:None

Data Params:None

Success Response:
Code: 200
Content: ["Africa/Abidjan",
          "Africa/Accra",
          "America/Cancun",
          "America/Caracas"] 
          List of all TimeZones
          
Error Response:
Code: 404 NOT FOUND
Content: {
    "timestamp": "2022-07-21T22:22:33.617+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "No message available",
    "path": "/api/timezone"
}

Sample Call: curl http://localhost:8082/api/timezone/ (success)
curl http://localhost:8082/api/timezone (failure)


**Get All Time Zone for Specific Area**

Returns List of All the TimeZones in specified area

URL: /api/timezone/:area

Method: GET

URL Params:area=[string]

Required:None

Data Params:None

Success Response:
Code: 200
Content: ["Africa/Abidjan",
          "Africa/Accra",
          "America/Cancun",
          "America/Caracas"] 
          List of all TimeZones
          
Error Response:
Code: 404 NOT FOUND
Content: {
    "timestamp": "2022-07-21T22:22:33.617+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "No message available",
    "path": "/api/timezone/toronto"
}

Sample Call: curl http://localhost:8082/api/timezone/America (success)
curl http://localhost:8082/api/timezone/Toronto (failure)

**Get All Time And Date for Specific Area and Location**

Returns time and date in specified area and location

URL: /api/timezone/:area/:location

Method: GET

URL Params:area=[string], location=[string]

Required:None

Data Params:None

Success Response:
Code: 200
Content:{
    "date": "2022-07-21",
    "time": "17:39:24"
}
          
Error Response:
Code: 404 NOT FOUND
Content: {
    "timestamp": "2022-07-21T22:22:33.617+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "No message available",
    "path": "/api/timezone/america/montreal"
}

Sample Calls: curl http://localhost:8082/api/timezone/America/Toronto(success)
curl http://localhost:8082/api/timezone/America/Montreal(failure)
 
