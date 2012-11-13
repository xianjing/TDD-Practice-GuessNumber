猜数字游戏需求
===========
* 当玩家输入四个不重复的数字，游戏服务器给出结果，告诉猜对与否。

###结果：
* 全部正确打印 ”You win”，错误尝试超过六次，游戏结束。
* 否则给出线索：[n]A[n]B

###规则：

* 如果数字相同并且位置正确，返回A
* 如果数字正确但位置不同，返回B

###参考
* http://zh.wikipedia.org/zh/%E7%8C%9C%E6%95%B0%E5%AD%97
* http://en.wikipedia.org/wiki/Bulls_and_cows

项目构建[可选]:
1. Clone the project repository using git.
2. Install HomeBrew
3. Run "brew install gradle"
4. Run "gradle test" to run all tests.

IntelliJ IDEA Setup
-------------------
1. Run "gradle idea" to create the project files
2. Open the .ipr file
