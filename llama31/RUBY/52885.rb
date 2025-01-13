class User < ActiveResource::Base\n  self.site = "http://auth-app.com"\n\n  delegate :contacts, to: :active_record_user\n\n  def active_record_user\n    User.find(id)\n  end\nend