# Example of simple syslog usage in Python\n   import logging\n\n   logger = logging.getLogger('app')\n   handler = logging.FileHandler('app.log')\n   formatter = logging.Formatter('%(asctime)s %(name)-12s %(levelname)-8s %(message)s')\n   handler.setFormatter(formatter)\n   logger.addHandler(handler)\n   logger.setLevel(logging.INFO)