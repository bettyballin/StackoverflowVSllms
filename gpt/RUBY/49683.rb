# spec/support/authentication_helpers.rb\n   module AuthenticationHelpers\n     def log_in_user(user = create(:user))\n       allow(controller).to receive(:current_user).and_return(user)\n       allow(controller).to receive(:logged_in?).and_return(true)\n     end\n\n     def log_out_user\n       allow(controller).to receive(:current_user).and_return(nil)\n       allow(controller).to receive(:logged_in?).and_return(false)\n     end\n   end\n\n   RSpec.configure do |config|\n     config.include AuthenticationHelpers, type: :controller\n   end