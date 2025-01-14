// deploy.php\n\nnamespace Deployer;\n\nrequire 'recipe/common.php';\n\nset('repository', 'git@github.com:username/repository.git');\nadd('shared_files', []);\nadd('shared_dirs', ['web/uploads']);\nadd('writable_dirs', ['web/cache', 'web/logs']);\n\nhost('example.com')\n    ->user('deployer')\n    ->forwardAgent()\n    ->multiplexing(true)\n    ->set('deploy_path', '/var/www/example');\n\ntask('deploy:assets', function () {\n    run('cd {{release_path}} && php bin/console assets:install web --env=prod');\n});\n\nafter('deploy:symlink', 'deploy:assets');