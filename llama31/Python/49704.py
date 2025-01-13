import time\nfrom watchdog.observers import Observer\nfrom watchdog.events import FileSystemEventHandler\nfrom difflib import Differ\n\nclass FileDiffHandler(FileSystemEventHandler):\n    def __init__(self, file1_path, file2_path):\n        self.file1_path = file1_path\n        self.file2_path = file2_path\n\n    def on_modified(self, event):\n        if event.src_path in (self.file1_path, self.file2_path):\n            print(f"Change detected in {event.src_path}. Computing diff...")\n            # Compute and print diff here\n            with open(self.file1_path) as file1, open(self.file2_path) as file2:\n                differ = Differ()\n                diff = differ.compare(file1.readlines(), file2.readlines())\n                print('\n'.join(diff))\n\n# Example usage\nif __name__ == "__main__":\n    event_handler = FileDiffHandler('file1.txt', 'file2.txt')\n    observer = Observer()\n    observer.schedule(event_handler, path='.', recursive=False)\n    observer.start()\n\n    try:\n        while True:\n            time.sleep(1)\n    except KeyboardInterrupt:\n        observer.stop()\n    observer.join()