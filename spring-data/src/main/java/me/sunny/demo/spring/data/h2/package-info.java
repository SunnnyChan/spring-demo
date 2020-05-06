/**
 * H2 Database demo.
 * 启动后，访问http://127.0.0.1:8899/h2
 *
 * 问题：
 * 配置过程中碰到数据库启动后，无法初始化数据的情况，
 * 最后还是 jar 包冲突的问题，
 *         <exclusion>
 *           <artifactId>jboss-logging</artifactId>
 *           <groupId>org.jboss.logging</groupId>
 *         </exclusion>
 *
 * jboss-logging 是一款类似于slf4j的日志框架，主要用于日志代理
 *
 */
package me.sunny.demo.spring.data.h2;