package app;

/**
 *  Monolithic
 *  1. vertical scaling
 *      more hardware
 *      more CPU
 *      larger memory Ram
 *      larger disk ..
 *  2. horizontal scaling
 *      user
 *       |
 *       LB(server)
 *      /   \       \
 *   node1  node2   node3
 *
 *
 *  Microservice
 *  1. Gateway Service
 *         1. rate limiter
 *         2. generate global unique id
 *  2. Discovery Service
 *          serviceA (ip1)   ->   serviceB(ip6, ip5, ip4)
 *                 \                   /
 *                 discovery service(service registration)
 *                         key: value
 *                service name: list of ip
 *                service A   :  IP1
 *                service B   :  IP5, IP4, IP6
 *
 *        1. start service -> register themself in discovery service
 *        2. service A -> rest request -> serviceB
 *              a. service A fetches serviceB ip from discovery service
 *              b. service A send request to serviceB http://IP6...
 *  3. Config Service
 *        1. centralize configurations
 *        2. start serviceA -> fetch configuration from config service
 *        3. call /refresh in serviceA -> re-fetch configuration from config service
 *  4. Security Service
 *  5. Circuit Breaker (fail tolerance strategy / retry strategy)
 *        serviceA -> serviceB
 *        failed 3 requests in last 5 requests
 *        1. circuit breaker -> change status from open to close
 *           service A -> service B
 *           return a fall back function result
 *           in background thread: keep checking service B health -> change status from close to open if service B backs online
 *  6. Message queue
 *          user
 *          |
 *       serviceA  ->  message queue(cluster) -> serviceB
 *       producer flow
 *       1. user send request to serviceA
 *       2. serviceA send message to message queue
 *       3. serviceA gives user success response
 *
 *
 *       consumer flow
 *       1. serviceB keep pulling message from message queue
 *  7. DB Cluster
 *  ..
 *
 *
 *
 *  Tomorrow
 *  1. message queue
 *  2. db transaction
 *     global transaction
 *
 *  tomorrow 1:30pm cdt
 *
 */