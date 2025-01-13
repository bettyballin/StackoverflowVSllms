from watchdog.observers import Observer\nfrom watchdog.events import FileSystemEventHandler\n\nclass ChangeHandler(FileSystemEventHandler):\n    def on_modified(self, event):\n        if not event.is_directory:\n            print(f"File modified: {event.src_path}")\n\n    def on_created(self, event):\n        if not event.is_directory:\n            print(f"File created: {event.src_path}")\n\n    def on_deleted(self, event):\n        if not event.is_directory:\n            print(f"File deleted: {event.src_path}")\n\nif __name__ == "__main__":\n    path_to_watch = "/path/to/folder"\n    event_handler = ChangeHandler()\n    observer = Observer()\n    observer.schedule(event_handler, path=path_to_watch, recursive=True)\n    observer.start()\n\n    try:\n        while True:\n            time.sleep(1)\n    except KeyboardInterrupt:\n        observer.stop()\n    observer.join()