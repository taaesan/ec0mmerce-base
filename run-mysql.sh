echo '# Stop mysql container #'
docker stop $(docker ps -aq) | docker rm $(docker ps -aq)

echo '# Run mysql5.7 and phpMyAdmin #'
docker run -p 3306:3306 --name mysql5.7 -v /Users/taaesan/Documents/Github/e-commerce-base/sqlscript:/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD=mosfet -d mysql:5.7
docker run --name myadmin -d --link mysql5.7:db -p 8181:80  --rm phpmyadmin/phpmyadmin
docker run -p 6379:6379 -v /Users/taaesan/Documents/Github/database/redis/data:/data --name redis4.0 -d redis:4.0-alpine redis-server --appendonly yes --requirepass mosfet


docker container ls
