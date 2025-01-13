class CreateInitialUser < ActiveRecord::Migration[7.0]\n  def up\n    User.new(name: 'Admin', email: 'admin@example.com').save(validate: false)\n  end\n\n  def down\n    User.find_by(name: 'Admin', email: 'admin@example.com').destroy\n  end\nend