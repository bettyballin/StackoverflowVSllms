void update_fields(struct fields *f, const struct field_update *updates, size_t num_updates);\n\nstruct field_update {\n    enum field_name name;\n    int value;\n};