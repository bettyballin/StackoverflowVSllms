create table [action]\n(\n    action_id       bigint identity not null,   -- PK\n    action_action   char(1) not null,       -- 'C' Call, 'R' Raise, 'F' Fold, 'P' Post\n    action_size     decimal(9,2) not null,  -- zero if fold, > zero otherwise\n\n    constraint pk_action primary key clustered (action_id),\n    constraint chk_action_action check (action_action in('C','R','F','P')),\n    constraint chk_action_size check (\n        (action_action = 'F' and action_size = 0.00) or\n        (action_action <> 'F' and action_size > 0.00)\n    )\n);