import threading\nimport socket\nimport time\n\ndef send_heartbeats(conn):\n    while True:\n        try:\n            conn.sendall(b'HEARTBEAT')\n            data = conn.recv(1024)\n            if not data or data != b'ACK':\n                print("Connection lost!")\n                break\n        except Exception as e:\n            print(f"Error sending heartbeat: {e}")\n            break\n        time.sleep(5)  # Send a heartbeat every 5 seconds\n\ndef main():\n    server_address = ('hostname', 1234)\n    conn = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n    try:\n        conn.connect(server_address)\n        heartbeat_thread = threading.Thread(target=send_heartbeats, args=(conn,))\n        heartbeat_thread.start()\n        \n        # Your application logic here\n        while True:\n            time.sleep(1)  # Simulate other work\n        \n    except Exception as e:\n        print(f"Connection error: {e}")\n    finally:\n        conn.close()\n\nif __name__ == "__main__":\n    main()