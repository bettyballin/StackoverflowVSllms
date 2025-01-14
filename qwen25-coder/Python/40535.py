import OpenOPC\n\n# Connect to the OPC server\nopc = OpenOPC.client()\nservers = opc.servers()\n\nif servers:\n    # Replace 'YourServerName' with the actual server name\n    opc.connect('YourServerName')\n    \n    # Example of reading a value from an OPC tag\n    tag_value = opc.read('TagName')\n    print("The value of TagName is:", tag_value)\n    \n    # Close the connection\n    opc.close()\nelse:\n    print("No available OPC servers found.")