## Task5

之前还有个v1版本，用session存储一些诸如密钥和登录状态的信息，虽然有些不足之处，但是作为session使用的入门也是非常值得的。
但是放到服务器三个容器用Nginx代理访问时，出现了session共享问题，因为密钥给每个访问者是随机的，存在一个session中，但访问别的容器时其session中是没有
该密钥的。

其实v1版session主要有两个作用，一个是放随机的密钥
一个是放访问状态，就是用户登录后，去数据库核查账密，存在即代表登录成功，在session中放一个("isLogin",true),
否则放("isLogin",false),
后面到拦截器postHandle拦截到，获取这个状态值，只有是true是才给response里放一个有效cookie

v2版本进行了改进，
首先将密钥固定为一个值，这样在这一方面用不到session了。
然后关于状态的问题，我把它放到request域对象中，因为这个状态值仅用于controller向拦截器postHandle传递一个true或false，
属于一个非常临时的数据，放到同样生命周期短暂的request域对象中更合适，放到session中有点浪费空间。

这样做到了无session化。

by LittleSong
