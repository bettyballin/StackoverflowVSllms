require 'base64'\n\nencoded_string = "$$YTo1OntzOjM6Im1pZCI7czo3OiI3MTE5Njg3IjtzOjQ6Im5hbWUiO3M6MjE6IkthbnllIFdlc3QgLSBTdHJvbmdlciI7czo0OiJsaW5rIjtzOjQ4OiJodHRwOi8vd3d3LmVhc3kxNS5jb20vMDIgU3Ryb25nZXIgKFNuaXBwZXQpMS5tcD\nMiO3M6OToiX3BsYXl0aW1lIjtzOjU6IjgzMjAwIjtzOjg6Il9uZXh0aWlkcyI7czozNDoiMjc1ODE0MDYsMjc0MDE1\nNzAsMjI1MTU0MDMsMTU1ODM2NjYsMTYzMTUzMzksMjgwNDY5MTUsMzAzOTMxODksMzUyMDAyMTMsMjIwNTE1MzAsMj\nc1NTg1MTQsMTM3ODkyNTYsMTk4MTY5OTgsMzA0NzI4MDEsMTUyNTk5NzksMTg5OTkxMzciO30="\n\n# Remove leading dollar signs\ncleaned_string = encoded_string.gsub('$$', '')\n\n# Decode the cleaned string\ndecoded_string = cleaned_string.unpack('m')[0]\n\nputs decoded_string