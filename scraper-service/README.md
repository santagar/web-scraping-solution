# Scraper service

Python service using [Beautiful Soup](https://pypi.python.org/pypi/beautifulsoup4) in order to retrieve `meta-title` content from Url requested.

## Requirements

    pip install -r requirements.txt
    
To make it work on your installation, be sure to add your RabbitMQ credentials in `worker.py`:

    # RabbitMQ
    host        = "localhost"
    user        = "guest"
    password    = "guest"

## Running the application

Use below to run worker which consumes tasks from RabbitMQ, begin scraper microservice and produces results:

    python worker.py