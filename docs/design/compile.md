# 编译输入流程

使用Antlr 4.使用visitor构建内部存储结构。

1. 对于给定的类别，产生一个类别对象，加入类别池
2. 对于一个TX，首先进行有效性检查，然后产生一个TX对象，加入相应的列表

## 有效性检查

1. 类别存在
2. 属性值与属性列表匹配（后续考虑属性类型支持）
3. **TODO**：单位（后续考虑多单位支持）