# Install Apache, PHP, and APC\nsudo apt-get install apache2 php5 libapc\n\n# Configure APC\nsudo nano /etc/php5/apache2/conf.d/apc.ini\n\n# Add the following lines:\n[APC]\napc.enabled = 1\napc.enable_cli = 1\napc.cache_by_default = 1\napc.shm_segments = 1\napc.shm_size = 128M\napc.ttl = 7200\napc.user_ttl = 7200\napc.gc_ttl = 3600\napc.stat = 1\n\n# Restart Apache\nsudo service apache2 restart