import subprocess\nimport time\n\ndef check_process(process_name):\n    try:\n        subprocess.check_output(["pgrep", "-f", process_name])\n        return True\n    except subprocess.CalledProcessError:\n        return False\n\ndef restart_process(process_name, restart_command):\n    if not check_process(process_name):\n        subprocess.call(restart_command, shell=True)\n\nwhile True:\n    restart_process("your_process_name", "your_restart_command")\n    time.sleep(60)  # check every 60 seconds