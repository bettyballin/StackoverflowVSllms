ActiveRecord::Base.establish_connection # Ensure main connection is established first\n\n   my_session_store = Session.connection # Change 'Session' to your actual model name if different\n   ActionDispatch::Session::ActiveRecordStore.session_class = "MyAppSession"\n\n   Rails.application.config.session_store :active_record_store, {\n     key: "_my_app_session",\n     database_file: my_session_store.pool.spec.config[:database],\n     adapter: my_session_store.pool.spec.config[:adapter],\n     host: my_session_store.pool.spec.config[:host] || 'localhost',\n     username: my_session_store.pool.spec.config[:username],\n     password: my_session_store.pool.spec.config[:password]\n   }