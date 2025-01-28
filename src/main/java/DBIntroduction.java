//EXPLAIN PLAN FOR
//        select /*+ full(e) */ *
//        from hr.employees e
//        where employee_id = 100 and employee_id = 200;
//        select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//
//        EXPLAIN PLAN FOR
//        select *
//        from hr.employees e
//        where employee_id >= 100 and employee_id <= 101;
//        select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//
//        EXPLAIN PLAN FOR
//        select *
//        from hr.employees e
//        where employee_id = 100 or employee_id = 101;
//        select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//
//        1. execution plan

//     material view
//

/**
 *  Tomorrow
 *      DB Cluster
 *      Mongodb Cluster
 *      Cassandra Cluster
 *      Redis Cluster
 *
 *  Thursday
 *      Microservice introduction
 *      AWS
 *
 *
 */