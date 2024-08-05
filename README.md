# mi-sport-change
运动修改-java版,不需要使用云函数, 可自建实现修改

### 更新日志：
#### 2021-10-29:
##### 船新版本, 支持同步步数到支付宝及微信
#### 2020-11-06:
##### 初版完成、只进行一些简单的异常处理，待完善
#### 2020-11-10:
##### 增加启动方式以单机运行或者以Web服务方式运行



steam:
username:huang​hai_7​y​
password:Huanghai4826


阿里云服务：
公网ip:
116.62.240.185
私网ip:
172.27.196.248

username:root
password:Huanghai@0197.

执行jar
nohup java -jar mi-sport-change-java-0.0.2.jar --run=web > nohup.out 2>&1 &

15147114921722863212772HHHH

http://116.62.240.185/sport/fromWxOpenData??signature=3c439298378427b07b7a297a0a7b80c64dcb4e4e&echostr=4375120948345356249&timestamp=1722863212772&nonce=1514711492
linux连接工具密码
MobaXterm: Huanghai

McAfee
usename: 869144014@qq.com
pwd: Huanghai@4826

docker：
docker ps 查询运行中的容器
docker images 查询所有镜像
docker pull mysql:5.7 拉取镜像
docker rmi c20987f18b13 删除镜像
docker start 2168a8464fcd 启动容器
docker stop 2168a8464fcd 停止容器
docker rm 2168a8464fcd 删除容器


创建容器并运行
mysql：
docker run --name misport -d -p 3306:3306 -v /home/mysql/:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=Huanghai mysql:5.7



host: 116.62.240.185:3306
username: root
pwd: Huanghai


