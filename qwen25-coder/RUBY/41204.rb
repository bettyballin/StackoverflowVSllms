# Example of using Sequel Core to run a custom SQL query\nDB[:users].where(name: 'John').select(:id, :email)