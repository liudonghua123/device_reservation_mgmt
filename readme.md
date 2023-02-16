# device_reservation_mgmt

## How to develop

1. git clone git@github.com:liudonghua123/device_reservation_mgmt.git
2. cd device_reservation_mgmt
3. follow the following server setup and client setup instructions.

## Server setup

1. install and start mysql, `sudo apt update && sudo apt install mysql-server && sudo mysql_secure_installation`
2. install and start redis, `sudo apt update && sudo apt install redis-server`

### create database in mysql

```shell
mysql -u root -p
create user 'device_reservation'@'%' IDENTIFIED WITH mysql_native_password by 'device_reservation@ynu!@#';
grant all privileges on device_reservation.* to 'device_reservation'@'%';
flush privileges;
create database device_reservation default charset utf8mb4;
use device_reservation;
source jeecg-boot/db/jeecgboot-mysql-5.7.sql;
```

### redis initialize

```shell
# 
redis-cli
auth default xxx
# https://redis.io/commands/acl-setuser/
# allkeys allchannels same as ~* &*
ACL SETUSER device_reservation on >device_reservation@ynu!@# allkeys allchannels +@all -flushdb -flushall
```

### update configurations

1. update the database connetion info in `datasource.master` of `jeecg-boot/jeecg-module-system/jeecg-system-start/src/main/resources/application-dev.yml`


### build

```shell
mvn clean package -DskipTests
```

## Client setup

### install dependences

```shell
pnpm install
```

### dev or build

```shell
yarn dev/build
```
