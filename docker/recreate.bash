#!/usr/bin/env bash

docker rm -f $(docker ps -a -q --filter "name=client-api-*")

docker compose down

docker compose up -d