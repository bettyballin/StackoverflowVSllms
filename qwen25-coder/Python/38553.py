import threading\nimport time\n\ndef worker():\n    print("Worker thread")\n    time.sleep(1)\n\nthreads = [threading.Thread(target=worker) for _ in range(5)]\n\nfor thread in threads:\n    thread.start()\n\nfor thread in threads:\n    thread.join()