class YourModel < ApplicationRecord\n     before_save :ensure_utf8\n\n     def ensure_utf8\n       self.text_column = text_column.encode('UTF-8', invalid: :replace, undef: :replace)\n     end\n   end