SELECT count(*), list_id, address_id\nFROM lnk_lists_addresses\nGROUP BY list_id, address_id\nHAVING count(*) > 1\nORDER BY count(*) DESC;