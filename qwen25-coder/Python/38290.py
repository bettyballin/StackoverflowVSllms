import paramiko\n\ndef transfer_file_via_ssh(hostname, port, username, local_path, remote_path):\n    # Create an SSH client instance\n    ssh = paramiko.SSHClient()\n    \n    # Automatically add untrusted hosts (make sure okay for security policy in your environment)\n    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())\n    \n    try:\n        # Connect to the host\n        ssh.connect(hostname, port=port, username=username)\n        \n        # SFTP client setup\n        sftp = ssh.open_sftp()\n        \n        # Transfer file\n        sftp.put(local_path, remote_path)\n        print(f"File {local_path} successfully transferred to {remote_path}")\n        \n    except paramiko.AuthenticationException:\n        print("Authentication failed, please verify your credentials")\n    except paramiko.SSHException as ssh_ex:\n        print(f"Unable to establish SSH connection: {ssh_ex}")\n    finally:\n        # Close SFTP and SSH connections\n        sftp.close()\n        ssh.close()\n\n# Example usage\nhostname = 'your_remote_host'\nport = 22\nusername = 'your_username'\nlocal_path = '/path/to/local/file.txt'\nremote_path = '/path/on/remote/host/file.txt'\n\ntransfer_file_via_ssh(hostname, port, username, local_path, remote_path)