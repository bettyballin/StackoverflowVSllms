class RenameAbcdToAbcdInXxxxx < ActiveRecord::Migration[6.1]\n  def up\n    execute "ALTER TABLE xxxxx RENAME COLUMN abcd TO ABCD"\n  end\n\n  def down\n    execute "ALTER TABLE xxxxx RENAME COLUMN ABCD TO abcd"\n  end\nend