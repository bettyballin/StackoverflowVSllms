# Using dos2unix\n   dos2unix -r -k --remove-bom include.inc testinclude.php\n\n   # Or using sed (Be cautious with sed as it modifies files in-place)\n   sed -i '1s/^\xef\xbb\xbf//' include.inc testinclude.php