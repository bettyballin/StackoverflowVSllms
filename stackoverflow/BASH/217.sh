RewriteCond %{HTTP_HOST} ^(www\.)?([^.]*)\.(com|info)$\nRewriteRule ^ - [L,E=HOST:%2]