egrep -lR "\.jpg|\.png|\.gif" . | xargs sed -i "s/\(.*\)\(\.jpg\|\.png\|\.gif\)/\1\.bmp/g"