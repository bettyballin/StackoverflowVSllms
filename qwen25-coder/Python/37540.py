import paramiko\nfrom scp import SCPClient\n\ndef create_ssh_client(server_ip, port, user, password):\n    client = paramiko.SSHClient()\n    # Automatically add untrusted hosts (make sure okay for security policy in your environment)\n    client.set_missing_host_key_policy(paramiko.AutoAddPolicy())\n    client.connect(server_ip, port=port, username=user, password=password)\n    return client\n\ndef main():\n    local_file_path = '/path/to/your/local/file.txt'\n    remote_file_path = '/path/to/remote/directory/file.txt'\n\n    server_ip = 'your_server_ip'\n    port = 22\n    user = 'your_username'\n    password = 'your_password'  # Consider using SSH keys for better security\n\n    ssh_client = create_ssh_client(server_ip, port, user, password)\n\n    try:\n        with SCPClient(ssh_client.get_transport()) as scp:\n            scp.put(local_file_path, remote_path=remote_file_path)\n            print("File transfer successful.")\n    finally:\n        ssh_client.close()\n\nif __name__ == '__main__':\n    main()