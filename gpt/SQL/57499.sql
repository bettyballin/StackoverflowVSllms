ALTER TABLE child_table\nADD CONSTRAINT fk_child_parent\nFOREIGN KEY (parent_id)\nREFERENCES parent_table (id)\nON DELETE CASCADE;