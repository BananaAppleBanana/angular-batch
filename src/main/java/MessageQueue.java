/**
 *
 *
 *  Message Queue model
 *  1. Queue
 *              [m2][m1]
 *  producer -> queue -> consumer1[m2]
 *                       consumer2[m1]
 *  2. Pub-Sub
 *              [m2][m1]
 *  producer -> queue -> consumer1[m1]
 *                       consumer2[m1]
 *
 *    *    *    *    *    *    *    *    *    *    *    *
 * Active MQ
 * Rabbit MQ
 *    *    *    *    *    *    *    *    *    *    *    *
 * SNS -> pub sub model
 * SQS -> queue model
 *      visibility timeout
 *    *    *    *    *   *    *    *    *    *    *    *
 * Kafka
 *
 * producer -> broker -> consumer group
 *             Topic1    consumer1 => pull p1
 *             p1        consumer2 => pull p2, p3
 *             p2
 *             p3
 *    *    *    *    *   *    *    *    *    *    *    *
 *
 */