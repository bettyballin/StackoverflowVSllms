def configure(conf):\n    # Check for a specific header file\n    if conf.check(header='your_header_file.h'):\n        print('Header found')\n    else:\n        print('Header not found')