var="your_string_here"\nsubstring="fixed_substring"\nreplacement="new_text"\n\nvar=$(echo "$var" | sed "s/$substring\$/$replacement/")