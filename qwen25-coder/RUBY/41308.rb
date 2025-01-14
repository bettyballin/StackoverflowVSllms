class ApplicationController < ActionController::Base\n  before_action :check_permissions\n\n  private\n\n  def check_permissions\n    permissions = {\n      'admin' => ['index', 'show'],\n      # add other controllers and actions as needed\n    }\n\n    controller_name = params[:controller]\n    action_name = params[:action]\n\n    unless permissions[controller_name]&.include?(action_name)\n      render plain: "Permission denied", status: :forbidden\n    end\n  end\nend