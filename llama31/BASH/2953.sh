md5deep find * | awk '{ print $1 }' | sed '/Is a directory/d'