config.action_controller.session_store = Rack::Session::File.new({\n  :path => 'tmp/sessions',\n  :domain => 'yourdomain.com'\n})