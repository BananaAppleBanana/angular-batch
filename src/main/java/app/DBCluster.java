package app;

/**
 *  CAP / BASE
 *  Consistency
 *  Availability
 *  Partition Tolerance
 *
 *  CP / AP
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Single Leader Cluster
 *    write
 *     |
 *   DB(write)      DB(read)  DB(read) DB(read)
 *   Leader
 *   Primary
 *   Master
 *
 *   Write: write db / leader db
 *          1. write to master / leader only -> return success to user
 *          2. write to master / leader + 1 ~ N read db -> return success to user
 *   Read : write db / read db
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *   Multi Leader Cluster
 *
 *   Master1        Master2         Master3
 *   /  \
 *  Followers       ...
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *   All Leader Cluster == Leaderless Cluster
 *
 *              Node1(0)
 *
 *  Node4(100k)        Node2(10k) -> handle value between(0, 10k]
 *
 *           Node3(50k) -> (10k, 50k]
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *  Redis Cluster
 *  1. hash slot ~ 24k
 *  2. send key-value to redis cluster
 *  3. redis cluster calculate hash(key)
 *  4. use hash(key) + number of hash slot => hash slot number
 *
 *   Leader(1 ~ 10k)    Leader(10k ~ 24k)
 *    /     \
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *
 * AP
 *    Cassandra cluster
 *
 *             request
 *              |
 *              Node1(0)
 *
 *  Node4(100k)        Node2(10k) -> handle value between(0, 10k]
 *
 *           Node3(50k) -> (10k, 50k]
 *
 *
 *   Replica Factor = 3
 *   Read Consistency Level = 1 ~ Replica Factor
 *   Write Consistency Level = 1 ~ Replica Factor
 *
 *
 *   eg. wc = 1
 *       rc = 3 => will trigger read repair if data is diff
 *
 *       wc + rc > replica factor
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *    Cassandra Node (LSM tree)
 *
 *    write -> memTable (memory) -> generate immutable SSTable(Sorted String Table)
 *              |
 *           commit log(disk)
 *
 *           SSTable1               SSTable2            SSTable3
 *          (id:1, name:Tom)    (id:1, name:Jerry)    (remove id:1, name:Jerry)
 *
 *   Read -> memTable ->
 *
 *           Blooming Filter
 *
 *           SSTable
 *           hashing1    [][][][][][][true]
 *           hashing2    [true][][][][][][]
 *           hashing3    [][][][true][][][]
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *   MongoDB Cluster
 *
 *                      mongos   -      config service
 *               /      \           \
 *          Sharding1   Sharding2   Sharding3
 *       id: 1 ~ 10k    10k ~ 15k   15k ~ 20k
 *       primary node
 *       secondary node
 *       secondary node
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *
 *
 *
 *
 *
 *
 */
