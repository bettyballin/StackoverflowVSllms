require 'base64url'\n\nencoded_str = '$$YTo1OntzOjM6Im1pZCI7czo3OiI3MTE5Njg3IjtzOjQ6Im5hbWUiO3M6MjE6IkthbnllIFdlc3QgLSBTdHJvbmd...'\ndecoded_str = Base64url.decode(encoded_str)