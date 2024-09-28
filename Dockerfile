# Use the official Gradle image from the Docker Hub
FROM gradle:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle project files to the container
COPY . .

# Run the Gradle build
RUN gradle build

# Set the PORT environment variable
ENV PORT=8080

# Expose the port the application runs on
EXPOSE $PORT

# Set the entry point to run the application
ENTRYPOINT ["gradle", "run"]