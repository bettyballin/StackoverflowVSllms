sed '/[A-Z]\d[A-Z] \d[A-Z]\d/{x;1!{p;p};x;i\\n\n}' inputfile.txt