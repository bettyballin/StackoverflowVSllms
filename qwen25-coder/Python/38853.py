import paramiko\n\ndef list_sftp_directory(hostname, port, username, password, remote_path):\n    # Initialize the SSH client\n    ssh_client = paramiko.SSHClient()\n    ssh_client.set_missing_host_key_policy(paramiko.AutoAddPolicy())\n\n    try:\n        # Connect to the SFTP server\n        ssh_client.connect(hostname, port=port, username=username, password=password)\n        \n        # Create an SFTP session from the SSH connection\n        sftp = ssh_client.open_sftp()\n        \n        # List directory contents\n        contents = sftp.listdir(remote_path)\n        print(f"Contents of {remote_path}:")\n        for item in contents:\n            print(item)\n\n    except Exception as e:\n        print(f"An error occurred: {e}")\n    finally:\n        if ssh_client.get_transport() is not None:\n            ssh_client.close()\n\n# Example usage\nlist_sftp_directory('xx.xx.xx.xx', 22, 'your_username', 'your_password', '/remote/directory')