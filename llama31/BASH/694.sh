find /path/to/source -ctime -1 -print0 | rsync -0avz --files-from=- /path/to/destinatio