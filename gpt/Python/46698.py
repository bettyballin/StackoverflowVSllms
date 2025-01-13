def foo(x, y, *args):\n    print(f"x: {x}, y: {y}")\n    print("args:", args)\n\ndef bar(x, y, **kwargs):\n    print(f"x: {x}, y: {y}")\n    print("kwargs:", kwargs)\n\n# Example calls\nfoo(1, 2, 3, 4, 5)\n# Output:\n# x: 1, y: 2\n# args: (3, 4, 5)\n\nbar(1, 2, z=3, w=4)\n# Output:\n# x: 1, y: 2\n# kwargs: {'z': 3, 'w': 4}