# Frontend service

For the frontend we use the basic framework [Knockout.js](http://knockoutjs.com).

To start the service we use the `SimpleHTTPServer` from Python. We need to choose another port as 8080 is already taken by the API backend.

## Running the application

Serve `index.html` with

     python -m SimpleHTTPServer 8090