# Install ownCloud on Ubuntu\nsudo apt-get install owncloud\n\n# Configure ownCloud to use a MySQL database\nsudo owncloud-occ db:convert-type mysql owncloud\n\n# Configure ownCloud to use a file system storage\nsudo owncloud-occ files:setup-filesystem