# Capfile example - basic setup for a PHP project\nrequire 'capistrano/setup'\nrequire 'capistrano/deploy'\n\n# Load custom tasks from `lib/capistrano/tasks` if you have any defined\nDir.glob('lib/capistrano/tasks/*.rake').each { |r| import r }\n\nnamespace :deploy do\n  desc 'Restart application'\n  task :restart do\n    on roles(:app), in: :sequence, wait: 5 do\n      # Your restart mechanism here (e.g., PHP-FPM reload)\n    end\n  end\n\n  after :publishing, :restart\nend