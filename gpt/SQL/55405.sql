SELECT sequence_name, s.tablespace_name\nFROM dba_sequences ds\nJOIN dba_segments s ON ds.sequence_owner = s.owner AND ds.sequence_name = s.segment_name\nWHERE s.segment_type = 'SEQUENCE';