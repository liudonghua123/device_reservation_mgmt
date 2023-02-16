#!/usr/bin/env bash

log_file=app.log
# update the code
echo [`date "+%Y-%m-%d %H:%M:%S"`] update the code | tee -a $log_file
git pull | tee -a $log_file

# build the frontend
echo [`date "+%Y-%m-%d %H:%M:%S"`] build the frontend
cd jeecgboot-vue3
yarn build | tee -a $log_file
cd ..
rm -rf html
# type cp: cp is aliased to `cp -i', use \cp to use the real cp
\cp -r jeecgboot-vue3/dist html

# build the backend
echo [`date "+%Y-%m-%d %H:%M:%S"`] build the backend
cd jeecg-boot
mvn clean package -Dmaven.test.skip=true | tee -a $log_file
cd ..
# Here we use/install the build jar file as the linux service, see https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html#deployment.installing for more details.
# ln -s /root/device_reservation_mgmt/device_reservation_mgmt.jar /etc/init.d/device_reservation_mgmt
rm -rf device_reservation_mgmt.jar
\cp jeecg-boot/jeecg-module-system/jeecg-system-start/target/jeecg-system-start-3.4.4.jar device_reservation_mgmt.jar
\cp application-dev.yml jeecg-boot/jeecg-module-system/jeecg-system-start/target/

# restart the backend
echo [`date "+%Y-%m-%d %H:%M:%S"`] restart the backend
sudo service device_reservation_mgmt restart | tee -a $log_file
# view the log
echo view the log using \"sudo tail -f /var/log/device_reservation_mgmt.log\"

# reload nginx
echo [`date "+%Y-%m-%d %H:%M:%S"`] reload nginx
sudo service nginx reload | tee -a $log_file