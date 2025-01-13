import psutil\n\ndef list_processes():\n    for proc in psutil.process_iter(['pid', 'name']):\n        print(f"PID: {proc.info['pid']}, Name: {proc.info['name']}")\n\nlist_processes()