class CreateVertices < ActiveRecord::Migration[6.0]\n  def change\n    create_table :vertices do |t|\n      # add necessary fields for a vertex here\n      t.timestamps\n    end\n  end\nend