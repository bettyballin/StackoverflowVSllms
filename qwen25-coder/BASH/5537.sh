FILES=($(ls))\nprintf "%s\n" "${FILES[@]:0:10}" | tr '\n' ' '\necho # To add a final newline character if needed