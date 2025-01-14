# config/environments/production.rb\n\nRails.application.configure do\n  # Enable serving of images, stylesheets, and JavaScripts from an asset server.\n  config.serve_static_assets = true\n\n  # Enable compression for JSON requests\n  config.middleware.use Rack::Deflater\n\n  # Set cache control for static assets\n  config.static_cache_control = "public, max-age=31536000"\n\n  # Configure Rails to use fast cached stores for storing sessions\n  config.cache_classes = true\n  config.enable_dependency_loading = false\n  config.allow_concurrency = true\n\n  # Compress CSS and JavaScript\n  config.assets.js_compressor = :uglifier\n  config.assets.css_compressor = :sass\n\n  # Do not fallback to assets pipeline if a precompiled asset is missed.\n  config.assets.compile = false\n\nend