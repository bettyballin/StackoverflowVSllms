# Example command to generate SHA-256 hash for all files in a directory\n   find /path/to/data -type f -exec sha256sum {} + > checksums.sha256