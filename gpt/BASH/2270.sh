# Move the contents of ABC and DEF to a temporary location\nmv PPP/ABC /tmp/ABC\nmv PPP/DEF /tmp/DEF\n\n# Initialize a new repository in PPP\ncd PPP\ngit init\n\n# Add ABC and DEF as submodules\ngit submodule add <path-to-your-original-ABC-repo> ABC\ngit submodule add <path-to-your-original-DEF-repo> DEF\n\n# Commit the changes\ngit add .\ngit commit -m "Add ABC and DEF as submodules"\n\n# Push the new repository to the desired remote location\ngit remote add origin <url-of-new-repo>\ngit push -u origin master\n\n# Go into each submodule and push their histories to new remotes if necessary\ncd ABC\ngit remote add origin <url-of-new-ABC-repo>\ngit push -u origin master\n\ncd ../DEF\ngit remote add origin <url-of-new-DEF-repo>\ngit push -u origin master