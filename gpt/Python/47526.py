from concurrent.futures import ThreadPoolExecutor\n\ndef process_file(file):\n    # Your file processing code here\n    pass\n\nwith ThreadPoolExecutor(max_workers=4) as executor:\n    files = ['file1.txt', 'file2.txt', 'file3.txt']\n    results = executor.map(process_file, files)