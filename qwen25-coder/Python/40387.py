import subprocess\n\ndef run_job(job_id):\n    if job_id == 1:\n        # Start the script in the background\n        subprocess.Popen(['python', '/path/to/script.py'])\n        \n        return 'Job is running'\n    else:\n        return 'Invalid job ID'\n\n# Example usage\njob_status_message = run_job(1)\nprint(job_status_message)  # This will print: Job is running