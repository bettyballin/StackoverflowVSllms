egrep -lRZ "\.jpg|\.png|\.gif" . \\n    | xargs -0 -l sed -i -e 's/\.jpg\|\.gif\|\.png/.bmp/g'