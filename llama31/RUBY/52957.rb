# config/environments/production.rb\nRails.application.configure do\n  # ...\n  config.assets.paths << Rails.root.join('app', 'assets', 'secure')\nend