# JsonResponseDemo
Test using
POST
url:http://127.0.0.1:8082/login
x-www-form-urlencoded:
username:"asbh"
password:"kjsbs"

POST
http://127.0.0.1:8082/accept-json
json:
{
    "id": 1,
    "name": "Alice Smith",
    "email": "alice.smith@example.com"
}

POST
http://127.0.0.1:8082/getEmployees
{
    "id": 1,
    "name": "Alice Smith",
    "email": "alice.smith@example.com"
}
