def a(**kwargs):\n    size = kwargs.get('size')\n    print(size)\n\ndef b():\n    size = 20\n    a(**locals())\n\nb()