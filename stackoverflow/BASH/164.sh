#!/bin/bash\necho -n "Enter a word: "\nread input\ngrep "^$input" /usr/share/dict/words