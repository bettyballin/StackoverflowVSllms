# config/environment.rb\nRails::Initializer.run do |config|\n  # other configuration settings...\n  config.action_controller.session_store = :file_store\n  config.action_controller.session = {\n    :key => '_your_app_session',\n    :secret => 'some_long_secret_key'\n  }\nend\n\n# config/environments/development.rb\nActionController::Base.session_options[:cache_path] = "#{Rails.root}/tmp/sessions"