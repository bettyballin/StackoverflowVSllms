class ApplicationController < ActionController::Base\n  before_filter do |controller|\n    controller.authenticate if controller.respond_to?(:authenticate)\n  end\nend