import requests\nfrom datetime import date\n\ndef fetch_and_filter_feeds(base_url):\n    response = requests.get(base_url)\n    if response.status_code == 200:\n        all_feeds = response.json()\n        today = date.today().isoformat()\n        today_feeds = [feed for feed in all_feeds if feed['date'] == today]\n        return today_feeds\n    else:\n        raise Exception(f"Failed to fetch feeds: {response.status_code}")\n\n# Example usage\napi_base_url = "https://example.com/api/feeds"\ntry:\n    today_feeds = fetch_and_filter_feeds(api_base_url)\n    print(today_feeds)\nexcept Exception as e:\n    print(e)