import asyncio\n\n   class ChatClientProtocol(asyncio.Protocol):\n       def connection_made(self, transport):\n           self.transport = transport\n\n       def data_received(self, data):\n           message = data.decode()\n           print('Data received:', message)\n\n       def connection_lost(self, exc):\n           print("The server closed the connection")\n           self.transport.close()\n\n   async def main():\n       loop = asyncio.get_running_loop()\n\n       for i in range(10000):  # Adjust as needed\n           transport, protocol = await loop.create_connection(\n               lambda: ChatClientProtocol(),\n               'localhost', 9998)  # Replace with your server details\n\n   asyncio.run(main())