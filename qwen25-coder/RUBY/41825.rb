class String\n  def smart_truncate(options = {})\n    sentences_mode = options[:sentences]\n    words_mode = options[:words]\n\n    if sentences_mode\n      # Split the text into sentences and take the specified number of sentences.\n      truncated_text = split(/\.(?=\s|$)/).first(sentences_mode).join('. ').strip + '.'\n    elsif words_mode\n      # Split the text into words and take the specified number of words.\n      words = split\n      truncated_text = words.first(words_mode).join(' ')\n      if words.length > words_mode\n        truncated_text += '...'\n      end\n    else\n      raise ArgumentError, "Please specify a valid mode: :sentences or :words"\n    end\n\n    truncated_text\n  end\nend\n\n# Usage examples:\ntext = "Once upon a time in a world far far away. And they found that many people were sleeping better."\nputs text.smart_truncate(sentences: 1)\n# => Once upon a time in a world far far away.\nputs text.smart_truncate(words: 12)\n# => Once upon a time in a world far far away. And they ...