def self.up\n  create_table(:notes, :options => 'ENGINE=MyISAM') do |t|\n    t.string :title\n    t.text :body\n\n    t.timestamps\n  end\n\n  execute "SET GLOBAL ft_min_word_len = 3"\n  execute "alter table notes ADD FULLTEXT(title, body)"\n  execute "REPAIR TABLE notes QUICK"\nend