# config/initializers/devise.rb\nDevise.setup do |config|\n  # ...\n  config.omniauth :cas,\n    cas_server: 'https://app-a.com/cas',\n    login_url: 'https://app-a.com/login',\n    logout_url: 'https://app-a.com/logout',\n    jwt_secret: 'your-secret-key'\nend