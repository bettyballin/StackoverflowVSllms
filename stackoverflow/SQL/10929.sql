-- Reset all branches\nUPDATE t_org_branches\n    SET nvc_breadcrumb = NULL,\n    i_depth = NULL\n\n-- Update the root branches first\nUPDATE t_org_branches \n    SET nvc_breadcrumb = '/', \n        i_depth = 0 \n    WHERE guid_branch_parent_id IS NULL\n\n-- Update the child branches on a loop\nWHILE EXISTS (SELECT * FROM t_branches WHERE i_depth IS NULL) \n    UPDATE tobA \n        SET tobA.i_depth = tobB.i_depth + 1, \n            tobA.nvc_breadcrumb = tobB.nvc_breadcrumb + Ltrim(tobA.guid_branch_parent_id) + '/' \n        FROM t_org_branches AS tobA\n            INNER JOIN t_org_branches AS tobB ON (tobA.guid_branch_parent_id = tobB.guid_branch_id) \n        WHERE tobB.i_depth >= 0 \n            AND tobB.nvc_breadcrumb IS NOT NULL \n            AND tobA.i_depth IS NULL