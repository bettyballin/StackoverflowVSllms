import os\nimport psutil\nimport time\nimport subprocess\n\ndef run_and_monitor(command):\n    # Start the process\n    process = subprocess.Popen(command, shell=True)\n    pid = process.pid\n    \n    # Monitor the process until it completes\n    stats = []\n    while True:\n        try:\n            p = psutil.Process(pid)  # Create a Process object for this PID\n            mem_info = p.memory_info().rss / (1024 * 1024)  # Convert bytes to MB\n            cpu_percent = p.cpu_percent(interval=0.1)\n            runtime = time.time() - p.create_time()\n            stats.append({\n                'memory_mb': mem_info,\n                'cpu_percent': cpu_percent,\n                'runtime_seconds': runtime\n            })\n            time.sleep(1)  # Adjust sleep duration as needed\n        except psutil.NoSuchProcess:\n            break\n\n    print(stats)\n\nif __name__ == "__main__":\n    command = "./myscript.pl some/process/I/want/to/get/stats/for"\n    run_and_monitor(command)