# Use rsync to filter files according to include-exclude patterns\nrsync -avm --include-from=patterns.txt /source-directory/ /destination-directory/