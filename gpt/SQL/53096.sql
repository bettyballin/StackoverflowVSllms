ALTER SESSION ENABLE PARALLEL DML;\n\nSELECT /*+ PARALLEL(ORDER_HEADER, 4) */ DISTINCT ORDER_ID, ORDER_TYPE_ID, ORDER_NAME, EXTERNAL_ID,\n    SALES_CHANNEL_ENUM_ID, ORDER_DATE, ENTRY_DATE, VISIT_ID, STATUS_ID, CREATED_BY,\n    FIRST_ATTEMPT_ORDER_ID, CURRENCY_UOM, SYNC_STATUS_ID, BILLING_ACCOUNT_ID,\n    ORIGIN_FACILITY_ID, WEB_SITE_ID, PRODUCT_STORE_ID, TERMINAL_ID, TRANSACTION_ID,\n    AUTO_ORDER_SHOPPING_LIST_ID, NEEDS_INVENTORY_ISSUANCE, IS_RUSH_ORDER, INTERNAL_CODE,\n    REMAINING_SUB_TOTAL, GRAND_TOTAL, LAST_UPDATED_STAMP, LAST_UPDATED_TX_STAMP, CREATED_STAMP,\n    CREATED_TX_STAMP, RECIBIR_BODEGAL, RECEPCIONADA_BODEGAL, FECHA_RECEPCION_BODEGAL\nFROM ERP.ORDER_HEADER\nWHERE (STATUS_ID = :v0 OR STATUS_ID = :v1 OR STATUS_ID = :v2)\n  AND ORDER_TYPE_ID = :v3\nORDER BY ORDER_DATE DESC;