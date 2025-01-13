# Turn on URL rewriting\nRewriteEngine On\n\n# Installation directory\nRewriteBase /\n\n# Protect application and system files from being viewed\nRewriteRule ^(application|system) - [F,L]\n\n# Allow any files or directories that exist to be displayed directly\nRewriteCond %{REQUEST_FILENAME} !-f\nRewriteCond %{REQUEST_FILENAME} !-d\n\n# Rewrite all other URLs to index.php/URL\nRewriteRule .* index.php/$0 [PT,L]