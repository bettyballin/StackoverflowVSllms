def func(files):\n    if isinstance(files, str):\n        files = [files]\n    for f in files:\n        doSomethingWithFile(f)