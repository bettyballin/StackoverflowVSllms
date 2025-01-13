import time\n\nclass CircuitBreaker:\n    def __init__(self, threshold=3, timeout=60):\n        self.threshold = threshold\n        self.timeout = timeout\n        self.consecutive_failures = 0\n        self.last_failure_time = None\n\n    def is_open(self):\n        if self.consecutive_failures >= self.threshold:\n            if self.last_failure_time is None or time.time() - self.last_failure_time > self.timeout:\n                return False\n            return True\n        return False\n\n    def record_failure(self):\n        self.consecutive_failures += 1\n        self.last_failure_time = time.time()\n\n    def record_success(self):\n        self.consecutive_failures = 0\n\n# Usage example\ncircuit_breaker = CircuitBreaker()\n\ndef send_request():\n    try:\n        # Simulate a failed request\n        raise Exception("Request failed")\n    except Exception:\n        circuit_breaker.record_failure()\n        return False\n    else:\n        circuit_breaker.record_success()\n        return True\n\nwhile True:\n    if circuit_breaker.is_open():\n        print("Circuit breaker is open; skipping request")\n    else:\n        if send_request():\n            print("Request succeeded")\n        else:\n            print("Request failed")\n    time.sleep(1)