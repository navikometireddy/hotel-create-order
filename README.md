# hotel-create-order
* please clone the code in to your local
* change the database uname/pwd according to your local mysql credentials
* use the command to run mvn spring-boot:run 
###### IF DOcker Available
docker build -t foo . && docker run -it foo
###### Database structure

![db](images/db.png)

use postman to send a request for token http://localhost:8080/createOrder please see images below

![db](images/postman.png)

###### Payload

{
    "hotelId": "002",
    "hotelName": "TUNE",
    "checkInDate": "2020-10-10T15:20:36+08:00",
    "checkOutDate": "2020-10-11T15:20:36+08:00",
    "customer": {
        "customerName": "09bad10a-0947-11eb-8b82-00163e000087",
        "email": "abc@gmail.com",
        "mobileNumber": "01123445044",
        "state": "KL",
        "country": "Malaysia",
        "postalCode": "57100"
    },
    "room": {
        "roomNumber": "00",
        "numberOfGuests": "2",
        "floor": "2"
    }
}

######TestCoverage

![db](images/test.png)


######SQL

######Asumptions
* customer will choose room and dates and fill the details to to create order.
* my asumption is securtity is already implemented


