# config/application.rb\nmodule YourApp\n  class Application < Rails::Application\n    config.relative_url_root = ENV['RAILS_RELATIVE_URL_ROOT'] || '/'\n  end\nend\n\n# app/helpers/application_helper.rb\nmodule ApplicationHelper\n  def gen_link(path)\n    "#{Rails.configuration.relative_url_root}#{path}"\n  end\nend\n\n# In your views\n<%= link_to 'Home', gen_link('/') %>\n<%= link_to 'Some Page', gen_link('/some/thing') %>