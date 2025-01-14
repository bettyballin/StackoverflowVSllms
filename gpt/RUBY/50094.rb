# app/controllers/application_controller.rb\n    class ApplicationController < ActionController::Base\n      before_action :authorize_user\n\n      private\n\n      def authorize_user\n        unless current_user && current_user.has_permission?(controller_name, action_name)\n          redirect_to root_path, alert: "You are not authorized to access this page."\n        end\n      end\n    end\n\n    # app/models/user.rb\n    class User < ApplicationRecord\n      def has_permission?(controller, action)\n        # Custom logic to check if the user has permission to perform the action\n        permissions.where(controller: controller, action: action).exists?\n      end\n    end