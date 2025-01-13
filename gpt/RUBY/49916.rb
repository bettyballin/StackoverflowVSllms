require 'rouge'\n\n    source_code = <<-CODE\n    def hello_world\n      puts 'Hello, world!'\n    end\n    CODE\n\n    formatter = Rouge::Formatters::HTML.new\n    lexer = Rouge::Lexer.guess_by_filename('hello.rb')\n    highlighted_code = formatter.format(lexer.lex(source_code))\n\n    puts highlighted_code