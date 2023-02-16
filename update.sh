#!/usr/bin/env bash

# update the code
git pull

# build the frontend
cd jeecgboot-vue3
yarn build
cd ..
rm -rf html
\cp -r jeecgboot-vue3/dist html

# build the backend
cd jeecg-boot
mvn clean package -Dmaven.test.skip=true
cd ..
rm -rf device_reservation_mgmt.jar
\cp jeecg-boot/jeecg-module-system/jeecg-system-start/target/jeecg-system-start-3.4.4.jar device_reservation_mgmt.jar
\cp application-dev.yml jeecg-boot/jeecg-module-system/jeecg-system-start/target/
sudo service device_reservation_mgmt restart
# view the log
# sudo tail -f /var/log/device_reservation_mgmt.log

# reload nginx
sudo service nginx reload