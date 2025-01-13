import paramiko\n\n# Establish a connection to the remote server\nssh = paramiko.SSHClient()\nssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())\nssh.connect('remote_server_ip', username='your_username', password='your_password')\n\n# Execute the command remotely\nstdin, stdout, stderr = ssh.exec_command('your_command')\n\n# Get the return code\nreturn_code = stdout.channel.recv_exit_status()\n\n# Get the stderr output\nstderr_output = stderr.read().decode('utf-8')\n\n# Close the connection\nssh.close()\n\nprint(f"Return code: {return_code}")\nprint(f"STDERR: {stderr_output}")