# Publisher\nimport zmq\n\ncontext = zmq.Context()\nsocket = context.socket(zmq.PUB)\nsocket.bind("tcp://*:5555")\n\nsocket.send_string("Hello, world!")\n\n# Subscriber\nimport zmq\n\ncontext = zmq.Context()\nsocket = context.socket(zmq.SUB)\nsocket.connect("tcp://localhost:5555")\n\nsocket.setsockopt(zmq.SUBSCRIBE, b"")\nmessage = socket.recv_string()\nprint(message)