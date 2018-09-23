## 登录

- 接口
> http://127.0.0.1:8080/login

- 请求参数 

| 字段 | 是否必填 |
|:--:|:--:|
| account | 是 |
| password | 是 |

- 请求参数
```JSON
{
  "account": "admin",
  "password": "123456"
}
```

- 登录成功返回结果
```JSON
{
    "code": 180100000,
    "msg": "操作成功",
    "success": true,
    "data":{
            "id": 1,
            "account": "admin",
            "password": "",
            "createTime": "2018-09-22 14:30:30",
            "name": "admin",
            "roleType": 1,
            "updateTime": null
        }
}
```

- 登录失败返回结果
```JSON
{
    "code": 180100001,
    "msg": "账号或密码有误",
    "success": false,
    "data": null
}
```

## 用户列表

### 新增用户
- 接口
> http://127.0.0.1:8080/user/add

- 请求参数

| 字段 | 是否必填 |
|:--:|:--:|
| account | 是 |
| name | 是 |
| password | 是 |
| roleType | 是 |

- 请求参数 JSON 示例
```JSON
{
  "account": "admin-1",
  "password": "123756",
  "name": "admin-1",
  "roleType": 2
}
```

- 新增成功返回结果
```JSON
{
    "code": 180100000,
    "msg": "操作成功",
    "success": true,
    "data":{
        "id": null,
        "account": "admin-1",
        "password": "",
        "createTime": "2018-09-22 17:06:07",
        "name": "admin-1",
        "roleType": 2,
        "updateTime": null
    }
}
```

- 新增失败返回结果
```JSON
{
    "code": 180100001,
    "msg": "此账号已存在，不能重复添加",
    "success": false,
    "data": null
}
````

### 查询用户
- 接口
> http://127.0.0.1:8080/user/get

- 请求参数

| 字段 | 是否必填 |
|:--:|:--:|
| account | 否 |
| name | 否 |

- 请求参数 JSON 示例
```JSON
{
  "account": "admin-1",
  "name": "admin"
}
```

- 返回结果
```JSON
{
    "code": 180100000,
    "msg": "操作成功",
    "success": true,
    "data":[
        {
            "id": 2,
            "account": "admin-1",
            "password": "123756",
            "createTime": "2018-09-22 17:06:07",
            "name": "admin-1",
            "roleType": 2,
            "updateTime": null
        }
    ]
}
```

### 删除用户

- 接口
> http://127.0.0.1:8080/user/delete/{id}

- 删除成功返回结果
```JSON
{
    "code": 180100000,
    "msg": "操作成功",
    "success": true,
    "data": null
}
```

- 删除失败返回结果
```JSON
{
    "code": 180100001,
    "msg": "操作失败",
    "success": false,
    "data": null
}
```

### 修改用户

- 接口
> http://127.0.0.1:8080/user/update

- 请求参数

| 字段 | 是否必填 |
|:--:|:--:|
| id | 是 |
| name | 否 |
| password | 否 |

- 请求参数 JSON 示例
```JSON
{
  "id": 2,
  "password": 123456
}
```

- 修改成功返回结果
```JSON
{
    "code": 180100000,
    "msg": "操作成功",
    "success": true,
    "data": null
}
```

- 修改失败返回结果
```JSON
{
    "code": 180100001,
    "msg": "操作失败",
    "success": false,
    "data": null
}
```

