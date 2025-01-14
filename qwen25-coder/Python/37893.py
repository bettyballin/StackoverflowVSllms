# appstate.py\n\nclass AppState:\n    _connected_users = []\n    _total_answers = 0\n\n    @classmethod\n    def get_user_list(cls):\n        return cls._connected_users\n\n    @classmethod\n    def add_user(cls, user):\n        cls._connected_users.append(user)\n\n    @classmethod\n    def remove_user(cls, user):\n        cls._connected_users.remove(user)\n\n    @classmethod\n    def increment_total_answers(cls):\n        cls._total_answers += 1\n\n    @classmethod\n    def get_total_answers(cls):\n        return cls._total_answers\n\n    @staticmethod\n    def create_app_config(filename='config.ini'):\n        # Logic to create or load app config file\n        with open(filename, 'w') as file:\n            file.write('[DEFAULT]\nsetting=default_value\n')