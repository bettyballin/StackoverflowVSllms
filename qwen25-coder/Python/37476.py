# Pseudo-code, adjust according to your tech stack\n\nclass TimeManager:\n    def __init__(self):\n        self._fixed_time = None\n\n    def get_current_time(self):\n        if self._fixed_time is not None:\n            return self._fixed_time\n        return datetime.now()\n\n    def set_fixed_time(self, time_str):\n        # parse time_str to a datetime object and store in _fixed_time\n\n    def use_real_time(self):\n        self._fixed_time = None\n\n# Usage in server code when setting date/time\ntime_manager = TimeManager()\ncurrent_time = time_manager.get_current_time()