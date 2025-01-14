import subprocess\nimport time\nimport psutil\n\ndef is_process_running(process_name):\n    # Check if there is any running process that contains the given name processName.\n    for proc in psutil.process_iter():\n        try:\n            # Check if process name contains the given name string.\n            if process_name.lower() in proc.name().lower():\n                return True\n        except (psutil.NoSuchProcess, psutil.AccessDenied, psutil.ZombieProcess):\n            pass\n    return False\n\ndef restart_process(command):\n    # Restart a process using the provided command\n    subprocess.Popen(command, shell=True)\n\nif __name__ == "__main__":\n    process_name = "your_process_name"  # Replace with your process name or part of it\n    command_to_start = "python your_script.py"  # Command to start the process\n\n    while True:\n        if not is_process_running(process_name):\n            print(f"{process_name} is not running. Restarting...")\n            restart_process(command_to_start)\n        time.sleep(5)  # Check every 5 seconds