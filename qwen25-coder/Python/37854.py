from watchdog.observers import Observer\nfrom watchdog.events import FileSystemEventHandler\n\nclass MyHandler(FileSystemEventHandler):\n    def on_modified(self, event):\n        print(f'File {event.src_path} has been modified')\n\nif __name__ == "__main__":\n    path = "/path/to/directory"\n    event_handler = MyHandler()\n    observer = Observer()\n    observer.schedule(event_handler, path, recursive=True)\n    observer.start()\n\n    try:\n        while True:\n            pass\n    except KeyboardInterrupt:\n        observer.stop()\n    observer.join()