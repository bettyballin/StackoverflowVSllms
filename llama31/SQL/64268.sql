SELECT \n    tbl1.gid,\n    perd_end_dt,\n    t1_end_dt\nFROM (\n    SELECT \n        tbl1.gid,\n        COALESCE(t1_end_dt, t6_actl_end_dt, t6_calc_end_dt) AS perd_end_dt,\n        t1_end_dt\n    FROM \n        tbl1\n    ...\n) AS subquery\nJOIN \n    tbl2 ON (t2_pk = wpck_wrkr_id AND t2_ind_1 = 'Y' AND perd_end_dt BETWEEN t2_strt_dt AND t2_end_dt)\nJOIN \n    tbl3 ON (t3_pk = t2_fk_t3_pk AND perd_end_dt BETWEEN t3_strt_dt AND t3_end_dt)\n...\nGROUP BY \n    tbl1.gid,\n    perd_end_dt,\n    t1_end_dt\nORDER BY \n    perd_end_dt