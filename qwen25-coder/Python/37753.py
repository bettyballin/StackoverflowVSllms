import subprocess\n   \n   def check_load():\n       # Example using a local nagios command, adjust for remote execution if necessary\n       try:\n           output = subprocess.check_output(['check_load', '-w', '2,1.5,1', '-c', '3,2.5,2'])\n           return output.decode('utf-8')\n       except subprocess.CalledProcessError as e:\n           print("Check failed:", str(e))\n   \n   print(check_load())