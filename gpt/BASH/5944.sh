# Initialize a new Git repository for your project\ngit init\ngit add .\ngit commit -m "Initial commit"\n\n# Create a new repository on GitHub\ngh repo create my-project --public\n\n# Push the local repository to GitHub\ngit remote add origin https://github.com/username/my-project.git\ngit push -u origin master\n\n# Setup a GitHub Codespace (from the GitHub repository page)\n# Click on the "Code" button, then "Open with Codespaces" and create a new Codespace