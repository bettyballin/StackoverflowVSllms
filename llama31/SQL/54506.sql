UPDATE target_table tt\nINNER JOIN source_table st ON tt.another_id = st.another_id\nSET tt.special_id = st.source_special_id;