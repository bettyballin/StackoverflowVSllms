class RenameAbcdToABCDInXxxxx < ActiveRecord::Migration[6.0]\n  def up\n    add_column :xxxxx, :ABCD, :text, null: false\n\n    # Copy data from abcd to ABCD using SQL for performance\n    execute "UPDATE xxxxx SET ABCD = abcd"\n\n    remove_column :xxxxx, :abcd\n  end\n\n  def down\n    add_column :xxxxx, :abcd, :text, null: false\n\n    # Copy data back\n    execute "UPDATE xxxxx SET abcd = ABCD"\n\n    remove_column :xxxxx, :ABCD\n  end\nend