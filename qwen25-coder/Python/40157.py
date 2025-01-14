# Example use of SecretService in Python\n  from secretstorage import dbus_init, get_default_collection\n  bus = dbus_init()\n  collection = get_default_collection(bus)\n  for item in collection.search_items({'': 'application/x-research-password-manager'}):\n      print(item.read_secret())