import logging\n\n   logging.basicConfig(filename='server.log', level=logging.INFO)\n   logging.info("Server started and listening on {address}:{port}".format(address=your_address, port=your_port))