# In cookie_store\nputs session.inspect  # This will output all session data\n\n# In active_record_store\nputs session.inspect  # This may output only the session data loaded from the database\nputs request.session_options[:id]  # Outputs the session_id used to access this sessio