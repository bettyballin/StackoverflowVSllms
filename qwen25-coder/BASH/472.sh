export study=$1\nexport tag=$2\nexport mode=$3\nexport select=$4\n\nsed -i.backup "s/thisisthestudycodereplacethiswiththestudycode/$study/" freq.spx