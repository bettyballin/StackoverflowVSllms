class ChangeDataTypeForBody < ActiveRecord::Migration[6.0]\n       def up\n         change_column :posts, :body, :text\n       end\n\n       def down\n         change_column :posts, :body, :string\n       end\n     end