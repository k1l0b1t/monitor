# monitor
A TCP monitor in java

![Logo](monitorLogo.png)

This is a simple Monitor in Java. It pings the monitor and updates the status to a mysql database. you can retrieve the statuses from that database in your website the way you like. Further documentation follows.

## Requirements
Java 11 or later required. (JDK + mysql or mariadb connector when compiling from source)
A MySQL/mariadb server

## Setup

### Running from source

1. create a database and use `db.sql` to create the table.
2. modify monitor.cnf to match your connection details
3. add a mysql/mariadb connector to the modulepath
4. run main/startup.java

### Using a pre-compiled jar

1. [Download](https://files.vincentlammens.be/software/monitor/) & extract the pre-compiled jarfile (in a .tar.gz archive with monitor.cnf and db.sql)
2. create a database and populate with db.sql
3. edit the monitor.cnf file with the connection details
4. run the jarfile with `java -jar monitor-mariadb-1.0.jar` (mariadb) or `java -jar monitor-mysql-1.0.jar`(mysql)

## Docs of the domain package

domain package api: <https://k1l0b1t.github.io/monitor/>

## Licence
Licence: GPLv3
