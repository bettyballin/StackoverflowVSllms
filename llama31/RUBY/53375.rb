# config/initializers/session_store.rb\nRails.application.config.session_store :mem_cache_store, \n  mem_cache_options: { \n    url: "memcached://your-memcached-server:11211" \n  }