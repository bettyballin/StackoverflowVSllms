# Navigate to your WWW directory in WAMP\ncd D:\wamp\www\n\n# Remove old CakePHP installation\nrm -rf cakephp\n\n# Clone the latest stable version of CakePHP\ngit clone https://github.com/cakephp/cakephp.git cakephp\n\n# Change directory into CakePHP folder\ncd cakephp\n\n# Install dependencies via Composer (make sure you have Composer installed)\ncomposer install --no-dev