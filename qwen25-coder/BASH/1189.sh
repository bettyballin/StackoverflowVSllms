RewriteEngine On\n# Capture anything after the slash and pass it as the 'p' parameter\nRewriteRule ^([^/]+)$ index.php?p=$1 [L,QSA]