# Split the file into 10MB chunks\nsplit -b 10M largefile.txt part_\n\n# Compress each chunk\nfor part in part_*; do\n    bzip2 -1 "$part"\ndone\n\n# (Optional) Combine compressed chunks into a single archive\ntar -cf largefile.tar.bz2 part_*.bz2