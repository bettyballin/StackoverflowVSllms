class CreateContents < ActiveRecord::Migration[6.0]\n  def up\n    create_table :contents do |t|\n      t.string  :type, null: false\n      t.string  :name, null: false\n    end\n\n    # Set the initial auto increment value\n    execute("ALTER TABLE contents AUTO_INCREMENT = 500;")\n  end\n\n  def down\n    drop_table :contents\n  end\nend