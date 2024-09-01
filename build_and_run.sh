#!/bin/bash

# Define variables
APP_NAME="pccwdemo"   
DOCKER_IMAGE_NAME="pccwdemo-app-image" 
DOCKER_CONTAINER_NAME="pccwdemo-app-container" 
DOCKER_PORT=8080 

# Step 1: Clean and build the project using Maven
echo "Building the project with Maven..."
mvn clean package -DskipTests

if [ $? -ne 0 ]; then
  echo "Maven build failed. Exiting..."
  exit 1
fi

# Step 2: Build the Docker image
echo "Building the Docker image..."
docker build -t $DOCKER_IMAGE_NAME .

if [ $? -ne 0 ]; then
  echo "Docker image build failed. Exiting..."
  exit 1
fi

# Step 3: Stop and remove any existing container with the same name
echo "Stopping and removing any existing Docker container..."
docker stop $DOCKER_CONTAINER_NAME 2>/dev/null
docker rm $DOCKER_CONTAINER_NAME 2>/dev/null

# Step 4: Run the Docker container
echo "Running the Docker container..."
docker run -d -p $DOCKER_PORT:8080 --name $DOCKER_CONTAINER_NAME $DOCKER_IMAGE_NAME

if [ $? -ne 0 ]; then
  echo "Failed to start the Docker container. Exiting..."
  exit 1
fi

# Step 5: Display the running containers
echo "Docker container is running. Listing all running containers..."
docker ps

# Optionally, you can add log output from the container
echo "To view logs from the application, use the following command:"
echo "docker logs -f $DOCKER_CONTAINER_NAME"

echo "Done!"
