# In your Rails model\nclass Setting < ApplicationRecord\n  attr_encrypted :secret_key, key: 'your_encryption_key_here'\nend