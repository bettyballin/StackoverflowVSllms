# lib/tasks/my_service.rake\nnamespace :my_script do\n  desc 'Run my Ruby script as a service'\n  task run: :environment do\n    # Your Ruby code here that interacts with ActiveRecord models\n    puts "Running the script..."\n    # Replace above line with your actual business logic\n  end\nend