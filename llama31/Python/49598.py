def func(files):\n    try:\n        iter(files)\n    except TypeError:\n        files = [files]\n    for f in files:\n        doSomethingWithFile(f)