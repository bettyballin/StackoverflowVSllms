SELECT *\nFROM sometable\nWHERE foo='hello' AND bar='world'\nUSE INDEX (bar_idx, foo_idx);