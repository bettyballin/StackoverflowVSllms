import docker\n\n# Create a Docker client\nclient = docker.from_env()\n\n# Create a container from a base image (e.g. Ubuntu)\ncontainer = client.containers.run('ubuntu', detach=True, tty=True)\n\n# Set up the container's file system\ncontainer.exec_run('mkdir -p /app')\ncontainer.exec_run('chown -R user:user /app')\n\n# Copy the uploaded code into the container\nwith open('uploaded_code.c', 'rb') as f:\n    container.exec_run('tee /app/uploaded_code.c', stdin=f)\n\n# Compile and run the code\ncontainer.exec_run('gcc -o /app/uploaded_code /app/uploaded_code.c')\ncontainer.exec_run('/app/uploaded_code')\n\n# Set a timeout and kill the container if it exceeds the allowed execution time\ntimeout = 5  # seconds\ntry:\n    container.wait(timeout=timeout)\nexcept docker.errors.APIError:\n    container.kill(signal='SIGKILL')\n\n# Remove the container\ncontainer.remove()