find . -type f -exec perl -pi -e 's/\$\{(\w+)\}/"\${".lcfirst($1)."${"}"/ge' {} +