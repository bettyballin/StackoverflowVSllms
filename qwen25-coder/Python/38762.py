class ShardManager:\n    def __init__(self, num_shards):\n        self.shards = [{} for _ in range(num_shards)]\n    \n    def get_shard_index(self, key):\n        # Simple hash function to determine shard index\n        return hash(key) % len(self.shards)\n    \n    def add_data(self, key, value):\n        shard_index = self.get_shard_index(key)\n        self.shards[shard_index][key] = value\n    \n    def get_data(self, key):\n        shard_index = self.get_shard_index(key)\n        return self.shards[shard_index].get(key)\n\n# Usage\nshard_manager = ShardManager(3)\nshard_manager.add_data('user123', {'name': 'John Doe'})\nprint(shard_manager.get_data('user123'))