import setproctitle\nimport time\n\n# Set the process title\nsetproctitle.setproctitle("othername")\n\n# Keep the process running to check the process name\ntime.sleep(60)