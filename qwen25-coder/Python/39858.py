class SimpleLogger:\n    def __init__(self, level="INFO"):\n        self.level = level\n\n    def log(self, message):\n        if self.should_log():\n            print(f"{self.level}: {message}")\n\n    def should_log(self):\n        levels = {"DEBUG": 10, "INFO": 20, "WARNING": 30, "ERROR": 40}\n        return levels[self.level] <= levels["INFO"]  # Always log info and above\n\nclass AdvancedLogger(SimpleLogger):\n    def __init__(self, level="INFO", file_output=None):\n        super().__init__(level)\n        self.file_output = file_output\n\n    def should_log(self):\n        levels = {"DEBUG": 10, "INFO": 20, "WARNING": 30, "ERROR": 40}\n        return levels[self.level] <= levels[self.level]\n\n    def log(self, message):\n        if self.should_log():\n            if self.file_output:\n                with open(self.file_output, 'a') as file:\n                    file.write(f"{self.level}: {message} \n")\n            print(f"{self.level}: {message}")\n\n# Example usage\nsimple_logger = SimpleLogger()\nadvanced_logger = AdvancedLogger(level="DEBUG", file_output="log.txt")\n\nsimple_logger.log("This is an info message.")\nadvanced_logger.log("This is a debug message with file output.")