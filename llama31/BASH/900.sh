sed -r ':a; $!{N;}; /^([0-9]+),,/ {s//\1,/; x; s/.*//; x;}; /^,/ {s//\n/; x; G; s/\n//;}' input.csv | sed '1d'