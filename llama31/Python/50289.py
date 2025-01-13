import os\nimport subprocess\n\n# Define the UID and commands to execute\nuid_user1 = 1001\nuid_user2 = 1002\ncommands = {\n    uid_user1: ["ls", "~", "mv", "file1"],\n    uid_user2: ["ls", "~", "mv", "file1"]\n}\n\n# Define the sudo configuration file\nsudo_config = "/etc/sudoers.d/my_config"\n\n# Create the sudo configuration file if it doesn't exist\nif not os.path.exists(sudo_config):\n    with open(sudo_config, "w") as f:\n        f.write(f"{os.getlogin()} ALL=(ALL) NOPASSWD:ALL")\n\n# Execute the commands as the specified UID\nfor uid, cmds in commands.items():\n    for cmd in cmds:\n        subprocess.run(["sudo", "-u", f"#{uid}", cmd])