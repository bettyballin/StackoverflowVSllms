for file in *.png; do\n  prefix=${file%-*}\n  convert -append ${prefix}-1-B.png ${prefix}-2-B.png -output ${prefix}-B.png\ndone