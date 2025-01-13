UPDATE wb\nSET wb.warehouse_box_status_id = wbsv.warehouse_box_status_id\nFROM warehouse_box wb\nINNER JOIN pallet_warehouse_box pwb ON wb.warehouse_box_id = pwb.warehouse_box_id\nINNER JOIN routing_shipment_pallet rsp ON pwb.pallet_id = rsp.pallet_id\nINNER JOIN warehouse_box_status_vw wbsv ON wbsv.warehouse_box_id = pwb.warehouse_box_id\nWHERE rsp.date_removed IS NULL\nAND pwb.date_unpalletized IS NULL\nAND rsp.routing_shipment_id = 100002