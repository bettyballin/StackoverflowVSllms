#!/bin/bash\n\n# Variables\nREPO_URL="git@github.com:username/repo.git"\nSTAGING_DIR="/var/www/staging"\nPRODUCTION_DIR="/var/www/production"\n\n# Pull the latest code from the repository\ncd $STAGING_DIR\ngit pull $REPO_URL\n\n# Run migrations\nphp artisan migrate --force\n\n# Sync staging environment with production\nrsync -avz $STAGING_DIR/ user@production_server:$PRODUCTION_DIR\n\n# Restart services if necessary\nssh user@production_server 'sudo systemctl restart apache2'