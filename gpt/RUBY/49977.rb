require 'bcrypt'\n\n# Retrieve the hashed password from your database\nstored_hashed_password = "the_hashed_password_from_db"\n\n# User input\ninput_password = "user_input_password"\n\n# Verify the password\nif BCrypt::Password.new(stored_hashed_password) == input_password\n  puts "Password is correct"\nelse\n  puts "Password is incorrect"\nend