# app/mailers/user_mailer.rb\nclass UserMailer < ActionMailer::Base\n  default from: "notifications@example.com"\n\n  def notify(user, subject, body)\n    @user = user\n    mail(to: @user.email, subject: subject) do |format|\n      format.html { render html: body.html_safe }\n    end\n  end\nend