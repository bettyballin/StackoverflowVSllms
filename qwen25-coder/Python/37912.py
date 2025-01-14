import psutil\n\ndef list_running_processes():\n    # Iterate over all running processes\n    for proc in psutil.process_iter(['pid', 'name', 'username']):\n        try:\n            # Get process info as a named tuple\n            process_info = proc.info\n            print(f"Process ID: {process_info['pid']}, Name: {process_info['name']}, User: {process_info['username']}")\n        except (psutil.NoSuchProcess, psutil.AccessDenied, psutil.ZombieProcess):\n            pass\n\nif __name__ == "__main__":\n    list_running_processes()