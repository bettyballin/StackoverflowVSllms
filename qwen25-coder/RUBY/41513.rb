# config/application.rb\n   module YourApp\n     class Application < Rails::Application\n       session_store :active_record_store, key: '__your_app_session', table_name: 'sessions'\n     end\n   end\n\n   # Run the following command to create sessions table\n   # rails generate active_record:session_store