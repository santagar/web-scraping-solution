# Web Scraping solution

A basic sample web scraping demonstrating how to build a microservices architecture.

The solution consists of three parts: frontend, that is communicating with a Spring Boot Java API, which in turn is offloading (using async communication with RabbitMQ) scraping tasks to a python service.

## Architecture

The following picture depicts how the main parts work together:

![Architecture](http://www.hispamedia.es/santagar/images/web-scraping-solution.png)

This sample is only an prototype that offer a general vision that can be used as a starter for creating a microservices architecture. If you need to deep more due to your requirements maybe you should use another technologies but the baseline is ready.
## How to Run

API Backend service:

    gradle run
     
Frontend service:

    python -m SimpleHTTPServer 8090
     
Scraper service:

    python worker.py
    
######More info: You can find more details inside each service README