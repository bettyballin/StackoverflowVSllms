class ResourceClient:\n    def __init__(self, base_uri):\n        self.base_uri = base_uri\n\n    def get(self, uri):\n        # Simulate HTTP GET request to the URI\n        response = fake_http_get(uri)\n        return response\n\ndef process_user(user_data):\n    # Process user data\n    print("Processing:", user_data)\n\ndef main():\n    client = ResourceClient("http://example.com")\n    \n    # Start with a known root URI\n    user_response = client.get("/users/joe")\n    \n    process_user(user_response["data"])\n    \n    # Navigate to bookmarks using link provided in the response\n    if "bookmarks_uri" in user_response:\n        bookmarks_response = client.get(user_response["bookmarks_uri"])\n        \n        for bookmark in bookmarks_response["items"]:\n            print("Bookmark:", bookmark)\n\nif __name__ == "__main__":\n    main()