sed -e '/=sec1=/,/=[a-z]*=/ {\n    /=sec1=/!{\n        /=[a-z]*=/! s/^/#/\n    }\n}' input