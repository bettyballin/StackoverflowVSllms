import os\nimport select\n\n# Create a pipe\nread_fd, write_fd = os.pipe()\n\npid = os.fork()\n\nif pid == 0:  # Child process\n    os.close(read_fd)\n    with os.fdopen(write_fd, 'wb', buffering=0) as f:\n        f.write(b"Hello from child")\nelse:  # Parent process\n    os.close(write_fd)\n    while True:\n        readers, _, _ = select.select([read_fd], [], [])\n        if read_fd in readers:\n            with os.fdopen(read_fd, 'rb', buffering=0) as f:\n                data = f.read(1024)\n                if not data:\n                    break\n                print("Received:", data.decode())\n    os.close(read_fd)