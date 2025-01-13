SELECT \n  t1.shipment_id,\n  (SELECT TIME FROM test WHERE shipment_id = t1.shipment_id AND stop_seq = MIN(t1.stop_seq)) AS start,\n  (SELECT TIME FROM test WHERE shipment_id = t1.shipment_id AND stop_seq = MAX(t1.stop_seq)) AS end\nFROM \n  test t1\nGROUP BY \n  t1.shipment_id