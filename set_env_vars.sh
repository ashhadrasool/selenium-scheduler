#!/bin/bash

# Database configuration
export DB_URL="jdbc:mysql://localhost:3306/devdb"
export DB_USERNAME="devuser"
export DB_PASSWORD="devpassword"

# Executor service configuration
export EXECUTOR_SERVICE_POOL_SIZE=2
export EXECUTOR_SERVICE_MAX_POOL_SIZE=2
export EXECUTOR_SERVICE_QUEUE_CAPACITY=10

# Task scheduler configuration
export TASK_SCHEDULER_POOL_SIZE=1

export BROWSER_PATH=/root/bin/chrome/linux-127.0.6532.0/chrome-linux64/chrome-headless-shell-linux64/chrome-headless-shell
export HEADLESS=true

echo "Environment variables set successfully."
