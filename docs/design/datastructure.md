# 数据存储格式

物品按照category分为若干链表，链表根据时间升序排列。

保持数据结构的可扩展性，后续链表过长时，需要进行一些块集成或者是`milestone/balance`之类的处理。

```mermaid
erDiagram
    OBJ ||--o{ TX : one-to-many
    OBJ {
        string name
        string code
        list attr_names
    }
    TX {
        Date date
        enum in_or_out
        OBJ category
        int number
        string unit
        map attr_values
    }
```