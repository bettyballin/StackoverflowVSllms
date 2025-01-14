import socket\n\ndef get_ipv4_address():\n    hostname = socket.gethostname()\n    host_ip = socket.gethostbyname(hostname)\n    return host_ip\n\nHOST = get_ipv4_address()\nprint('IPv4 Address:', HOST)