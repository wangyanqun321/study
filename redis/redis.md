# redis
## redis 运维
### redis 安装启动
1. 环境准备
```
yum install gcc-c++
# 查看版本
gcc -v
```

2. 安装
```
make
make install
```
3. 默认安装路径
/usr/local/bin

4. 修改配置
```
# 后台启动
daemonize yes
```
5. 启动
```
redis-server redis.conf
```
### redis-benchmark 性能测试
```
redis-benchmark -h localhost -p 6379 -c 100 -n 100000
```
### 基本操作
```
# 清空db
flushdb
# 清空所有db
flushall
# 查看所有的key
keys *
# 查看
dbsize
# 移除 1号库 key 为name的
move name 1
# 设置过期时间
expire name 10
查看当前key的剩余时间

查看某个key的类型
type name
# 加1
Incr age
# 减1
decr age 
# 加n
Incrby age 10
# 减n
decrby age 10
# set setnx setex
set: 设置或覆盖值(可单独设置超时时间，非原子性操作)
setex: 设置或覆盖值并给超时时间(原子操作)
setnx: 设置值，值存在则设置失败 (分布式锁常用)
getset: 先获取在设置新的值
watch 可以实现乐观锁
```