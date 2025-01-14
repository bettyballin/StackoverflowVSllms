# Using system to run commands and check the success by exit status\ndef run_command(command)\n  puts "Executing: #{command}"\n  success = system(command)\n  if success\n    puts "Command executed successfully."\n  else\n    puts "Command failed with error code #{$?.exitstatus}."\n  end\nend\n\n# SVN update command\nsvnu_command = 'svn update /path/to/working/copy'\nrun_command(svnu_command)\n\n# File copy command using cp (Unix-like systems)\ncp_command = 'cp -r /source/directory/* /destination/directory/'\nrun_command(cp_command)