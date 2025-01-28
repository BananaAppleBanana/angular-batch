import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 *  multithreading:
 *      1. synchronized
 *      2. lock
 *      3. ..thread safe collection
 *
 *  connection
 *      source ip, source port, dest ip, dest port
 *
 *  network layers
 *
 *  Application Layer : HTTP, WebSocket
 *  Persistent Layer : SSL / TLS
 *  Session Layer : socket
 *  Transport Layer : tcp / udp (port)
 *  Network Layer: ip address
 *  DataLink Layer: mac address
 *  Physical Layer: cable / ...
 *
 *      [ip header][tcp header][http header][data]
 *
 *  Tomcat
 *      request -> tomcat
 *                      |
 *                    threadpool
 *                     |
 *                     worker thread get connection
 *                     |
 *        SpringMVC DispatcherServlet - handler mapping -> controller
 *                     |
 *                  http message converter (jackson)
 *                    |
 *                   json
 *
 *  Spring
 *      1. IOC, Dependency Injection
 *         class MyIOC {
 *             Map<BeanName, ClassObject> container;
 *         }
 *         @Autowired
 *         @Service, @Controller, @Component, @Repository, @Bean
 *      2. AOP
 *         @Before, @After...
 *         public void beforeLogic() {
 *             ...
 *         }
 *
 *         @PointCut(xx class)
 *         exe logic => before all functions in xx class
 *
 *
 *
 * Spring Boot
 *      1. embedded tomcat
 *      2. application.properties
 *      3. auto configure
 *      4. main function to start application
 *      5. easy for microservice
 *      6. spring boot actuator
 *
 */


class FactoryPatternExample {

    public Map<Integer, Integer> getMap() {
        return new LinkedHashMap<>();
    }
}
