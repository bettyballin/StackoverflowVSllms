head -c $(stat -c%s A) B | md5sum -c <(md5sum A)