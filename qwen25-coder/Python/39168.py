import time\n\ndef main():\n    try:\n        while True:\n            print("Running...")\n            time.sleep(1)\n    except KeyboardInterrupt:\n        print("Received interrupt, cleaning up...")\n        # Perform cleanup operations here\n        cleanup()\n\ndef cleanup():\n    # Implement your clean-up code here\n    print("Cleanup complete.")\n\nif __name__ == "__main__":\n    main()