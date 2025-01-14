import requests\n\ndef search_remote_jobs(url):\n    response = requests.get(url)\n    if response.status_code == 200:\n        print(f"Successfully fetched jobs from {url}")\n        # Here you would parse the HTML for relevant job listings\n    else:\n        print(f"Failed to fetch jobs, status code: {response.status_code}")\n\n# Example URLs\nsearch_remote_jobs("https://www.toptal.com/jobs?work_location=remote")\nsearch_remote_jobs("https://stackoverflow.com/jobs?q=remote")