DECLARE\n    TYPE va_orgs IS TABLE OF nbr.lien_item.lien_item_name%TYPE;\n    org va_orgs := va_orgs('RTA','RTB','RTE','RTI','RTM','RTT');\nBEGIN\n    FOR i IN org.FIRST .. org.LAST LOOP\n        -- Correctly reference the element using org(i)\n        INSERT INTO nbr.lien_item (\n            lien_item_sid, \n            excel_row, \n            include_in_calcs, \n            indent, \n            header_level, \n            sort_order, \n            unit, \n            lien_item_status, \n            lien_item_name\n        ) VALUES (\n            nbr.lien_item_seq.nextval, \n            0, \n            'Y', \n            1, \n            0, \n            1, \n            'FTE', \n            'A', \n            org(i) -- Use (i) instead of 'org(i)'\n        );\n    END LOOP;\n\n    COMMIT; -- Commit once after all inserts\nEND;\n/