find . -type f -print0 | xargs -0 sed -i 's/\.jpg\|\.png\|\.gif/.bmp/g'