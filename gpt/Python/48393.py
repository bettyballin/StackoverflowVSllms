import asyncio\nimport websockets\nimport zlib\nimport json\n\nclients = set()\n\nasync def notify_clients(data):\n    if clients:\n        compressed_data = zlib.compress(json.dumps(data).encode('utf-8'))\n        await asyncio.wait([client.send(compressed_data) for client in clients])\n\nasync def register_client(websocket):\n    clients.add(websocket)\n    try:\n        await websocket.wait_closed()\n    finally:\n        clients.remove(websocket)\n\nasync def main():\n    async with websockets.serve(register_client, "localhost", 6789):\n        await asyncio.Future()  # run forever\n\nif __name__ == "__main__":\n    asyncio.run(main())