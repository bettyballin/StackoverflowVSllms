hashed, salt = seal(7)\nprint(hashed, salt)  # e.g. "482.2382" "123456"\n\nx = unseal(hashed, salt)\nprint(x)  # 7\n\nhashed, salt = seal(7)\nprint(hashed, salt)  # e.g. "71.9217" "654321"\n\nx = unseal(hashed, salt)\nprint(x)  # 7