RewriteCond %{HTTPS} on\nRewriteCond %{REQUEST_URI} !^(/checkout)\nRewriteRule ^(.*)$ http://%{HTTP_HOST}%{REQUEST_URI} [R=301,L]