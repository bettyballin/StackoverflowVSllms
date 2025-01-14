// deploy.php\n   namespace Deployer;\n\n   require 'recipe/codeigniter.php';\n\n   // Project name\n   set('application', 'my_codeigniter_project');\n\n   // Project repository\n   set('repository', 'git@github.com:yourusername/your-repo.git');\n\n   // Hosts\n   host('production')\n       ->set('deploy_path', '/var/www/my_codeigniter_project')\n       ->user('deploy');\n\n   // Tasks\n   task('build', function () {\n       run('cd {{release_path}} && composer install');\n   });\n\n   after('deploy:symlink', 'build');\n\n   // [Optional] if deploy fails automatically unlock.\n   after('deploy:failed', 'deploy:unlock');\n\n   // Migrate database before symlink new release.\n   before('deploy:symlink', 'artisan:migrate');