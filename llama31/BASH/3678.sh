pg_basebackup -D /var/lib/postgresql/9.5/main -Fp -X fetch -c fast -h primary_server -U replication_user\npg_ctl start