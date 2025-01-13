def tail(f, n, offset=0):\n    """Reads n lines from f with an offset of offset lines."""\n    total_lines = n + offset\n    block_size = 1024\n    f.seek(0, 2)  # seek to end of file\n    file_size = f.tell()\n    lines = []\n\n    while file_size > 0 and len(lines) < total_lines:\n        block_size = min(block_size, file_size)\n        f.seek(file_size - block_size, 0)\n        block = f.read(block_size)\n        file_size -= block_size\n        lines.extend(block.splitlines()[::-1])\n\n    return lines[:total_lines][offset:]