CREATE TABLE target_table (\n    gid        integer,\n    st_fips    integer DEFAULT NULL,\n    sfips      integer DEFAULT NULL,\n    county_fip integer DEFAULT NULL,\n    cfips      integer DEFAULT NULL,\n    pl_fips    integer DEFAULT NULL,\n    id         integer DEFAULT NULL,\n    elevation  integer DEFAULT NULL,\n    pop_1990   integer,\n    population integer DEFAULT NULL,\n    name       varchar(32),\n    st         varchar(12) DEFAULT NULL,\n    state      varchar(16) DEFAULT NULL,\n    warngenlev varchar(13) DEFAULT NULL,\n    warngentyp varchar(13) DEFAULT NULL,\n    watch_warn varchar(14) DEFAULT NULL,\n    zwatch_war bigint DEFAULT NULL,\n    prog_disc  bigint DEFAULT NULL,\n    zprog_disc bigint DEFAULT NULL,\n    comboflag  bigint DEFAULT NULL,\n    land_water varchar(13) DEFAULT NULL,\n    recnum     integer,\n    lon        numeric,\n    lat        numeric,\n    the_geom   geometry\n);