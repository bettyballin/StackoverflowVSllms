import multiprocessing\nimport time\n\ndef worker(q1, q2):\n    # Put items in the queues\n    q1.put("item1")\n    q2.put("item2")\n\ndef main():\n    q1 = multiprocessing.Queue()\n    q2 = multiprocessing.Queue()\n\n    p = multiprocessing.Process(target=worker, args=(q1, q2))\n    p.start()\n\n    while True:\n        try:\n            item1 = q1.get(block=False)\n            print("Got item from q1:", item1)\n            break\n        except queue.Empty:\n            pass\n\n        try:\n            item2 = q2.get(block=False)\n            print("Got item from q2:", item2)\n            break\n        except queue.Empty:\n            pass\n\n        time.sleep(0.1)  # Polling interval\n\nif __name__ == "__main__":\n    main()