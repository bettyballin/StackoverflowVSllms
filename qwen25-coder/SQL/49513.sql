WITH transaction_sums AS (\n    SELECT  \n        td.transaction_id,\n        SUM(IF(coalesce(ti.na, -1) = 0 AND coalesce(ti.special_info_type, -1) = 0 AND coalesce(ti.item_type, '') = 'P' AND coalesce(ti.comp_id, 0) <= 0, coalesce(disc_amt, 0), 0)) AS disc_sum,\n        SUM(IF(coalesce(ti.na, -1) = 0 AND coalesce(ti.special_info_type, -1) = 0 AND coalesce(ti.item_type, '') = 'P' AND coalesce(ti.comp_id, 0) > 0, coalesce(comp_amt, 0), 0)) AS cSM,\n        SUM(IF(coalesce(ti.na, -1) = 0 AND coalesce(ti.special_info_type, -1) = 0 AND coalesce(ti.item_type, '') = 'P' AND coalesce(ti.comp_id, 0) > 0, coalesce(comp_tax, 0), 0)) AS cTX\n    FROM transaction_details td\n    LEFT OUTER JOIN transaction_items ti ON ti.transaction_id = td.transaction_id\n    WHERE td.na = 0 AND td.entry_TS >= ? AND td.entry_TS < ?\n    GROUP BY td.transaction_id\n),\nrefunds AS (\n    SELECT  \n        tiP.transaction_id,\n        COUNT(x.id) AS refCnt,\n        COALESCE(SUM(x.item_price + x.sub_price), 0) AS refAmt,\n        COALESCE(SUM(x.efftax), 0) AS refTax\n    FROM (\n        SELECT  \n            (tiP.item_price - tiP.comp_amt) AS item_price,\n            COALESCE(SUM(tiA.item_price), 0) AS sub_price,\n            (tiP.efftax - tiP.comp_tax) AS efftax,\n            tiP.id\n        FROM transaction_items tiP\n        LEFT OUTER JOIN transaction_items tiA ON tiP.id = tiA.ref_id AND tiA.item_type = 'A' AND tiA.na = 0\n        WHERE tiP.item_type = 'P' AND tiP.na = 0 AND tiP.refund = 1\n        GROUP BY tiP.id\n    ) AS x\n    GROUP BY tiP.transaction_id\n)\nSELECT \n    ts.transaction_id,\n    disc_sum,\n    cSM,\n    cTX,\n    refCnt,\n    refAmt,\n    refTax\nFROM transaction_sums ts\nLEFT JOIN refunds r ON ts.transaction_id = r.transaction_id;