import asyncio\nimport time\nfrom datetime import datetime\n\nasync def daemon():\n    with open('loop.log', 'a') as fp:\n        fp.write(f"{datetime.now().strftime('%Y-%m-%d %H:%M:%S')} Started\n")\n        while True:\n            if file_exists('loop.stop'):\n                break\n            fp.write(f"{datetime.now().strftime('%Y-%m-%d %H:%M:%S')} Looped\n")\n            await asyncio.sleep(100)\n        fp.write(f"{datetime.now().strftime('%Y-%m-%d %H:%M:%S')} Stopped\n")\n\ndef file_exists(filename):\n    try:\n        with open(filename, 'r'):\n            return True\n    except FileNotFoundError:\n        return False\n\nasyncio.run(daemon())