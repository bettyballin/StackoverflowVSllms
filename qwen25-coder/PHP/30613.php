<?php\n   namespace Deployer;\n\n   require 'recipe/laravel.php';\n\n   // Project name\n   set('application', 'project-name');\n\n   // Repositories\n   set('repository', 'svn://path/to/your/svn/repository');\n   set('branch', 'trunk'); \n\n   // Deploy path on the server\n   set('deploy_path', '/var/www/project-name');\n\n   // Server configuration\n   host('server1.example.com')\n       ->setRemoteUser('user')\n       ->setPort(22);\n\n   // Tasks\n   task('build', function () {\n       run('cd {{release_path}} && build-project');\n   });\n\n   after('deploy:symlink', 'cleanup');\n\n   // [Optional] If you do not need the shared dirs/symlinks, uncomment the next line\n   // set('use_relative_symlinks', true);