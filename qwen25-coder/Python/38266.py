import requests\nfrom datetime import date\n\ndef fetch_today_feeds(base_url):\n    today = date.today().isoformat()  # Format date as YYYY-MM-DD\n    response = requests.get(f"{base_url}?date={today}")\n    if response.status_code == 200:\n        return response.json()\n    else:\n        raise Exception(f"Failed to fetch feeds: {response.status_code}")\n\n# Example usage\napi_base_url = "https://example.com/api/feeds"\ntry:\n    today_feeds = fetch_today_feeds(api_base_url)\n    print(today_feeds)\nexcept Exception as e:\n    print(e)