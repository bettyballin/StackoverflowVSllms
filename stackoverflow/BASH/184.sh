i=1; temp=$(mktemp -p .); for file in image*\ndo\nmv "$file" $temp;\nmv $temp $(printf "image_%0.3d.jpg" $i)\ni=$((i + 1))\ndone                                      