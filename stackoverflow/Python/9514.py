def chunks(lst, n):\n    """Yield successive n-sized chunks from lst."""\n    for i in range(0, len(lst), n):\n        yield lst[i:i + n]