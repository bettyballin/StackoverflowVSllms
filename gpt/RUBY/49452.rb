# config valid for current version and patch releases of Capistrano\n     lock "~> 3.11.0"\n\n     set :application, "my_app_name"\n     set :repo_url, "git@example.com:me/my_repo.git"\n\n     # Default branch is :master\n     set :branch, ENV['BRANCH'] || 'master'\n\n     # Default deploy_to directory is /var/www/my_app_name\n     set :deploy_to, "/var/www/my_app_name"\n\n     # Default value for :format is :airbrussh.\n     set :format, :airbrussh\n\n     # Default value for :pty is false\n     set :pty, true\n\n     # Default value for :linked_files is []\n     append :linked_files, 'config.php'\n\n     # Default value for linked_dirs is []\n     append :linked_dirs, 'log', 'tmp/pids', 'tmp/cache', 'tmp/sockets', 'public/system'\n\n     namespace :deploy do\n       after :updated, :set_environment_config do\n         on roles(:app) do\n           within release_path do\n             execute :cp, "#{release_path}/config.#{fetch(:stage)}.php #{release_path}/config.php"\n           end\n         end\n       end\n     end