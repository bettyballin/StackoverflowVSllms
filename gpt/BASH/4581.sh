awk 'NR>=105 && NR<=115 { if ($1 ~ /host=/) print $1; if ($1 ~ /port=/) print $1 }' .tnsnames.ora