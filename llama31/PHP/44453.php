// Example using Deployer for automatic deployments\n  namespace Deployer;\n  \n  require 'recipe/common.php';\n  \n  // Project name\n  set('application', 'my_project');\n  \n  // Project repository\n  set('repository', 'git@github.com:yourusername/yourrepository.git');\n  \n  // [Optional] Allocate tty for git clone. Default value is false.\n  set('git_tty', true); \n  \n  // Shared files/dirs between deploys \n  set('shared_files', []);\n  set('shared_dirs', []);\n  \n  // Writable dirs by web server \n  set('writable_dirs', []);\n  set('allow_anonymous_stats', false);\n  \n  // Hosts\n  host('domain.com')\n    ->set('remote_user', 'your_username')\n    ->set('deploy_path', '/var/www/domain.com');\n  \n  // Tasks\n  desc('Deploy your project');\n  task('deploy', [\n    'deploy:info',\n    'deploy:prepare',\n    'deploy:lock',\n    'deploy:release',\n    'deploy:update_code',\n    'deploy:shared',\n    'deploy:writable',\n    'deploy:vendors',\n    'deploy:clear_paths',\n    'deploy:symlink',\n    'deploy:unlock',\n    'cleanup',\n    'success'\n  ]);\n  \n  // [Optional] If deploy fails automatically unlock.\n  after('deploy:failed', 'deploy:unlock');