# In your Rails app, e.g., config/initializers/tcp_server.rb\nrequire './tcp_server'\n\n# Start the TCP server in a new thread\nThread.new do\n  start_tcp_server\nend