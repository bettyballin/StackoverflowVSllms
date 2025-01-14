# config/application.rb (or appropriate initializer)\nconfig.action_mailer.delivery_method = :smtp\n\nconfig.action_mailer.smtp_settings = {\n  address: "your-smtp-server.com",\n  port: 587,\n  user_name: "user@domain.com",\n  password: "password",\n  authentication: "plain"\n}\n\n# Use Mail gem for custom delivery method\nrequire 'mail'\nclass ActionMailer::Base.delivery_method_class\n  def deliver!(mail)\n    attempt = 0\n    max_attempts = 5\n    retry_delay = proc { |n| 2 ** n + rand(n) }\n\n    begin\n      Mail.deliver(mail)\n    rescue Net::SMTPServerBusy => e\n      if (attempt += 1) < max_attempts\n        sleep(retry_delay.call(attempt))\n        retry\n      else\n        raise "Max attempts reached for sending email: #{e.message}"\n      end\n    end\n  end\nend