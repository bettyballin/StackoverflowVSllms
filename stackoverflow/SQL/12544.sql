create or replace procedure get_info(p_cursor out sys_refcursor)\nis\nbegin\n  open p_cursor for\n    select *\n    from   v$database; \nend;\n/