import os\nimport paramiko\n\n# Enable debug-level logging for Paramiko\nparamiko.util.log_to_file("paramiko.log")\n\nsOutputFilename = "redacted.htm"  #-- The payload file\nhostname = "redacted.com"\nsUsername = "redacted"\nsPassword = "redacted"\nsTargetDir = "redacted"\n\n# Get host key, if we know one.\nhostkeytype = None\nhostkey = None\nhost_keys = {}\ntry:\n    host_keys = paramiko.util.load_host_keys(os.path.expanduser('~/.ssh/known_hosts'))\nexcept IOError:\n    try:\n        # try ~/ssh/ too, because windows can't have a folder named ~/.ssh/\n        host_keys = paramiko.util.load_host_keys(os.path.expanduser('~/ssh/known_hosts'))\n    except IOError:\n        print('*** Unable to open host keys file')\n        host_keys = {}\n\nif hostname in host_keys:\n    hostkeytype = list(host_keys[hostname].keys())[0]\n    hostkey = host_keys[hostname][hostkeytype]\n    print(f'Using host key of type {hostkeytype}')\n\nssh = paramiko.Transport((hostname, 22))\ntry:\n    ssh.connect(username=sUsername, password=sPassword, hostkey=hostkey, timeout=10) # Add a timeout\nexcept Exception as e:\n    print(f"Failed to connect: {e}")\nelse:\n    sftp = paramiko.SFTPClient.from_transport(ssh)\n    try:\n        sftp.chdir(sTargetDir)\n        sftp.put(sOutputFilename, sOutputFilename)\n    except Exception as e:\n        print(f"SFTP operation failed: {e}")\n    finally:\n        sftp.close()\n    ssh.close()