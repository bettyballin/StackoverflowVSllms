find /path/to/source -ctime -1 -printf "%p\n" > recent_files.txt\nrsync -avz --include-from=recent_files.txt --exclude='*' /path/to/source/ /path/to/destinatio