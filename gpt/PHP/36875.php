<?php\n\nnamespace Deployer;\n\nrequire 'recipe/common.php';\n\n// Project name\nset('application', 'my_app');\n\n// Project repository\nset('repository', 'git@github.com:yourusername/yourrepo.git');\n\n// [Optional] Allocate tty for git clone. Default value is false.\nset('git_tty', true);\n\n// Shared files/dirs between deploys\nadd('shared_files', ['.env']);\nadd('shared_dirs', ['storage']);\n\n// Writable dirs by web server\nadd('writable_dirs', ['storage', 'vendor']);\n\n// Hosts\nhost('example.com')\n    ->stage('production')\n    ->set('deploy_path', '/var/www/my_app');\n\n// Tasks\ntask('build', function () {\n    run('cd {{release_path}} && build');\n});\n\n// [Optional] if deploy fails automatically unlock.\nafter('deploy:failed', 'deploy:unlock');\n\n// Migrate database before symlink new release.\nbefore('deploy:symlink', 'artisan:migrate');