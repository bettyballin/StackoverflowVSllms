import psutil\nimport time\n\ninterface = 'eth0'  # Change to your interface (e.g. eth0, wlan0)\n\nprevious_io = psutil.net_io_counters(pernic=True)[interface]\n\ntime.sleep(1)  # Wait 1 second\n\ncurrent_io = psutil.net_io_counters(pernic=True)[interface]\n\ndownload_speed = (current_io.bytes_recv - previous_io.bytes_recv) / 1024  # KB/s\nupload_speed = (current_io.bytes_sent - previous_io.bytes_sent) / 1024  # KB/s\n\nprint(f"Download Speed: {download_speed} KB/s")\nprint(f"Upload Speed: {upload_speed} KB/s")