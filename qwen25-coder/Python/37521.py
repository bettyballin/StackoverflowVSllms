import gps  # Python interface to GPSD\nfrom time import sleep\n\n# Connect to the local GPS daemon.\nsession = gps.gps(mode=gps.WATCH_ENABLE)\n\ndef main():\n    try:\n        while True:\n            report = session.next()\n            if report['class'] == 'TPV':\n                latitude = getattr(report, 'lat', "Unknown")\n                longitude = getattr(report, 'lon', "Unknown")\n                print(f"Location: {latitude}, {longitude}")\n                # Here you can write the location data to a file or send over the network\n            sleep(60)  # Log every minute\n\n    except KeyboardInterrupt:\n        session.close()\n        print("Session ended.")\n\nif __name__ == "__main__":\n    main()