import requests\nfrom datetime import datetime, timedelta\n\n# Fetch the server status page\nresponse = requests.get('http://your-server-ip/server-status?auto')\nstatus_info = response.text\n\n# Extract the uptime in seconds\nfor line in status_info.splitlines():\n    if "ServerUptimeSeconds" in line:\n        uptime_seconds = int(line.split(":")[1].strip())\n        break\n\n# Calculate the start time\ncurrent_time = datetime.now()\nstart_time = current_time - timedelta(seconds=uptime_seconds)\n\nprint(f"Apache WebServer Start Time: {start_time}")