# Gemfile\ngem 'twilio-ruby'\n\n# Run bundle install to install the gem\n$ bundle install\n\n# config/initializers/twilio.rb\nTwilio.configure do |config|\n  config.account_sid = 'your_account_sid'\n  config.auth_token = 'your_auth_token'\nend\n\n# app/controllers/messages_controller.rb\nclass MessagesController < ApplicationController\n  def send_sms\n    client = Twilio::REST::Client.new\n    message = client.messages.create(\n      body: params[:body],\n      to: params[:to],    # Recipient's phone number\n      from: 'your_twilio_number' # Your Twilio number\n    )\n    render json: { status: 'success', message_sid: message.sid }\n  rescue Twilio::REST::RestError => e\n    render json: { status: 'error', error: e.message }\n  end\nend