/**
 *
 *
 *  Transaction
 *
 *
 *  user1     insert 2 rows,      insert 2 rows(exception)
 *  ------------------------------------------>timeline
 *                           |                          |
 *  user2                  select = 2 rows          select = 2 rows
 *
 *
 *  update name to Jerry
 *
 *  id, name, tx_id, rollback pointer(hidden column)
 *  1   Tom    1            |
 *                          |
 *                          ------
 *                              id,  name   ,  tx_id
 *                              1 ,   Jerry ,   2
 *
 *
 *  finished tx id: [1]
 *  select .. from .. where .. id = 1
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *         service
 *      /           \
 *   DB1            DB2
 *  insert1        insert2
 *
 *  situation 1
 *  1. insert DB1
 *     commit
 *  2. insert DB2
 *     exception
 *
 *  situation 2
 *  1. insert DB1
 *     insert DB2
 *  2. commit DB1
 *     commit DB2
 *
 *
 *
 *  Two Phase commit
 *              service
 *               |
 *          coordinator
 *          /      \
 *       DB1       DB2
 *
 *   phase1:  coordinator sends queries to different db
 *   phase2:  commit
 *
 *
 *  SAGA pattern
 *
 *    service1   --  message queue  --  service2 -> tells user/ notification
 *    |                                   |
 *   DB1                                  DB2
 *   -10
 *
 *
 *   if service2 cannot commit tx in DB2
 *
 *   service1  --  rollback queue -- service2
 */