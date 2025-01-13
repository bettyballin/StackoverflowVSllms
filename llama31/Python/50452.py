class MyContextManager:\n    def __enter__(self):\n        print("Entering context")\n        return "Cursor object"\n\n    def __exit__(self, exc_type, exc_val, exc_tb):\n        print("Exiting context")\n\n# Without "as" clause\nctx = MyContextManager()\nwith ctx:\n    print(ctx)  # prints the MyContextManager instance\n\n# With "as" clause\nwith MyContextManager() as cursor:\n    print(cursor)  # prints "Cursor object"