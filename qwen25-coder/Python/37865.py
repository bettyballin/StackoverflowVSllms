class MinimalVCS:\n    def __init__(self):\n        self.versions = {}\n    \n    def add_version(self, item_id, content, author):\n        if item_id not in self.versions:\n            self.versions[item_id] = []\n        current_time = get_current_time()\n        self.versions[item_id].append((content, author, current_time))\n    \n    def get_version_history(self, item_id):\n        return self.versions.get(item_id, [])