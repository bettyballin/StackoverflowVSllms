# Install Phinx (if not already installed)\ncomposer global require robmorgan/phinx\n\n# Create a migration\nphinx create MyNewMigration\n\n# Write your migration in the newly created file\n\n# Run migrations\nphinx migrate -e productio