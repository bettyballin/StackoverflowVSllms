module YourApp\n  class Application < Rails::Application\n    config.autoload_paths += %W(#{config.root}/lib)\n  end\nend