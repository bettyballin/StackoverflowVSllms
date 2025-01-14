d = dict(param='test')\n\ndef f(param):\n    print(param)\n\nf(**d)  # This will print: test\n\n# For multiple parameters\nd = dict(p1=1, p2=2)\ndef f2(p1, p2):\n    print(p1, p2)\n\nf2(**d)  # This will print: 1 2