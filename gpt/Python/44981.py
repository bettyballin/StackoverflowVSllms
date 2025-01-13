import os\n     import subprocess\n\n     def deploy():\n         # Pull latest code\n         subprocess.run(["ssh", "deployer@example.com", "cd /var/www/html && git pull origin main"], check=True)\n\n         # Run composer install\n         subprocess.run(["ssh", "deployer@example.com", "composer install --no-dev --prefer-dist"], check=True)\n\n         # Run database migrations\n         subprocess.run(["ssh", "deployer@example.com", "php vendor/bin/phinx migrate"], check=True)\n\n     if __name__ == "__main__":\n         deploy()