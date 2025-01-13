# Change the owner of the directory (and files within) to www-data\nsudo chown -R www-data:www-data /path/to/your/web/directory\n\n# Alternatively, add your user to the www-data group and adjust the group permissions:\n# Add yourself to the www-data group (replace 'your_user' with your username)\nsudo usermod -a -G www-data your_user\n# Change group ownership of directory\nsudo chown -R :www-data /path/to/your/web/directory\n# Set group write permission for directories and files\nsudo find /path/to/your/web/directory -type d -exec chmod 755 {} \;\nsudo find /path/to/your/web/directory -type f -exec chmod 644 {} \;\n\n# Reload Apache to apply changes (if necessary)\nsudo systemctl reload apache2