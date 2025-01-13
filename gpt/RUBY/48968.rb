def valid_us_zip?(zip)\n  !!(zip =~ /^\d{5}(-\d{4})?$/)\nend\n\n# Example usage:\nputs valid_us_zip?("12345")      # true\nputs valid_us_zip?("12345-6789") # true\nputs valid_us_zip?("123456")     # false