require 'open3'\n\n# Run the SVN update command\nOpen3.popen3("svn update") do |stdin, stdout, stderr, wait_thr|\n  # Check the exit status of the command\n  exit_status = wait_thr.value\n  if exit_status.success?\n    # Command executed successfully\n  else\n    # Command failed\n  end\nend