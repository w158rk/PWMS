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
    输入编译解析                :done,    dev-compile, 2021-08-21, 1d
    剩余物品文本输出             :done,    dev-textout, 2021-08-21, 1d

    section 文档
    models             :done,   doc-compile, after dev-compile, 1d
    utils            :done,         doc-textout, after dev-textout, 1d
    warehouse          :done,         doc-textout, after dev-textout, 1d
    compiler          :done,         doc-textout, after dev-textout, 1d
    formatter          :done,         doc-textout, after dev-textout, 1d

    section 测试
    输入编译解析             :done,    test-compile, after dev-compile, 1d
    剩余物品文本             :done,    test-textout, after dev-textout, 1d

    section 发布
    修改README          :done,   readme, after test-compile, 1d
    v0.0.1 发布         :   v0.0.1, after readme, 1d

```