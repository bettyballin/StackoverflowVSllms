# Create a Docker image for your application\ndocker build -t myapp .\n\n# Run multiple containers from the same image\ndocker run -d --name node1 myapp\ndocker run -d --name node2 myapp\ndocker run -d --name node3 myapp\n\n# Use Docker Compose to scale the number of containers\ndocker-compose up --scale myapp=5