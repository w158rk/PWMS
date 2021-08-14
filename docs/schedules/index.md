# 开发时间计划

```mermaid
gantt
    dateFormat  YYYY-MM-DD
    title       项目开发计划

    section 设计
    记录文本语法                    :done,    syntax, 2021-08-14, 2d
    数据存储格式                    :done,    ds, 2021-08-14, 2d
    剩余物品文本输出格式              :done,    textout, 2021-08-14, 2d
    输入编译解析流程                :done,     proc-compile, after syntax, 2d
    剩余物品文本输出流程             :done,     proc-textout, after textout, 2d

    section 开发
    输入编译解析                :         dev-compile, after proc-compile, 1d
    剩余物品文本输出             :         dev-textout, after proc-textout, 1d

    section 文档
    输入编译解析             :         doc-compile, after dev-compile, 1d
    剩余物品文本输出          :         doc-textout, after dev-textout, 1d

    section 测试
    输入编译解析             :         test-compile, after dev-compile, 1d
    剩余物品文本             :         test-textout, after dev-textout, 1d

    section 发布
    修改README          :   readme, after test-compile, 1d
    v0.0.1 发布         :   v0.0.1, after readme, 1d

```