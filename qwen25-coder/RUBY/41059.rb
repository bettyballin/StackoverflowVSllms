validates :email, presence: true, format: { with: URI::MailTo::EMAIL_REGEXP }