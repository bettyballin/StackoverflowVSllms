class ApplicationController < ActionController::Base\n     before_action :authenticate_with_certificate\n\n     private\n\n     def authenticate_with_certificate\n       return if request.env['SSL_CLIENT_VERIFY'] == "SUCCESS"\n       render text: 'SSL Client Certificate is required', status: 403\n     end\n   end