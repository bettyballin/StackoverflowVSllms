import subprocess\n\nresult = subprocess.run('some command', shell=True, capture_output=True, text=True)\nprint(result.returncode)\nprint(result.stdout)\nprint(result.stderr)