import pickle\n\ndef is_pickleable(obj):\n    try:\n        pickle.dumps(obj)\n        return True\n    except (pickle.PicklingError, TypeError):\n        return False