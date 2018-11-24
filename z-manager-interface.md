## 已测试接口

接口名称 | 方式 | URL 
---|---|---
登录 | POST | http://127.0.0.1:8080/login
新增商户 | POST | http://127.0.0.1:8080/merchant/add
商户列表 | GET | http://127.0.0.1:8080/merchant/list
新增商铺 | POST | http://127.0.0.1:8080/house/add
商铺列表 | GET | http://127.0.0.1:8080/house/list
可出租商铺列表 | GET | http://127.0.0.1:8080/house/list/available
新增合同 | POST | http://127.0.0.1:8080/contract/add
合同列表 | GET | http://127.0.0.1:8080/contract/list
新增水表 | POST | http://127.0.0.1:8080/waterMeter/add
根据合同 ID 查询水表 | GET | http://127.0.0.1:8080/waterMeter/list?contractId=43
新增电表 | POST | http://127.0.0.1:8080/electricMeter/add
根据合同 ID 查询电表 | GET | http://127.0.0.1:8080/electricMeter/list?contractId=11
新增电表用电记录 | POST | http://127.0.0.1:8080/electricMeter/record/add

## 登录

- 接口
    > http://127.0.0.1:8080/login

- 方式
    > POST

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

    | 字段 | 是否必填 | 类型 | 描述
    |:--:|:--:|:--:|:--:|
    | account | 否 | String | 账号
    | name | 否 | String | 用户名
    | pageNum | 否 | Integer | 页码 
    | pageSize | 否 | Integer | 每页显示数量

- 请求参数 JSON 示例
    ```JSON
    {
    "account": "admin-1",
    "name": "admin",
    "paageNum": 1,
    "pageSize": 10
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
        ],
        "totalPages": 2
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

##  商户

### 新增商户

- 接口
  > http://127.0.0.1:8080/merchant/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | merchantCode | 是 | String | 商户编号 
    | company | 是 | String |公司名称 
    | corporateBody | 是 | String |法人 
    | idCard | 是 | String |身份证或营业执照号码 
    | linkMan | 是 | String |联系人 
    | linkPhone | 是 | String | 联系电话
    | brand | 否 | String | 经营品牌
    | address | 否 | String | 公司地址
    | enteringTime | 是 | String | 入场时间 
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "merchantCode": "23234",
        "company": "汽车之家",
        "corporateBody": "李三",
        "idCard": "4216826866886868",
        "linkMan": "张孝勇",
        "linkPhone": "352324233",
        "brand": "宝马奔驰",
        "address": "范德萨发生大发生的",
        "remarks": "dfsasdfasd",
        "enteringTime": "2018-09-09 12:00:00"
    }
    ```

- 新增成功返回结果 
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":{
            "id": 1,
            "merchantCode": "23234",
            "company": "汽车之家",
            "corporateBody": "李三",
            "idCard": "4216826866886868",
            "linkMan": "张孝勇",
            "linkPhone": "352324233",
            "brand": "宝马奔驰",
            "address": "范德萨发生大发生的",
            "remarks": "dfsasdfasd",
            "enteringTime": "2018-09-09 12:00:00",
            "status": 1,
            "createTime": "2018-10-17T16:08:27.941+0000",
            "createEmpId": 10,
            "createEmp": "超级管理员",
            "modifyTime": null,
            "modifyEmpId": null,
            "modifyEmp": null
        },
        "totalPages": 0
    }
    ```

- 新增重复 merchantCode 返回结果
    ```JSON
    {
        "code": 180100001,
        "msg": "商户编号已存在，新增失败!",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```

### 查询商户列表

- 接口
  > http://127.0.0.1:8080/merchant/list

- 方式
  > GET

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | pageNum | 是 | Integer | 页码
    | keyWord | 否 | String | 关键字

    - keyWord 可包含的值
    > 公司名称/身份证号或营业执照号/联系人姓名/商户编号/


- 请求示例
    ```JS
    http://127.0.0.1:8080/merchant/list?pageNum=1&keyWord=妩媚
    ```
- 返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 12,
                "merchantCode": "12",
                "company": "亚马逊",
                "corporateBody": "妩媚",
                "idCard": "4216826866886868",
                "linkMan": "妩媚",
                "linkPhone": "352324233",
                "brand": "kindle",
                "address": "范德萨发生大发生的",
                "remarks": "dfsasdfasd",
                "enteringTime": "2018-09-09 12:00:00",
                "status": 1,
                "createTime": "2018-10-18T15:01:44.000+0000",
                "createEmpId": 10,
                "createEmp": "超级管理员",
                "modifyTime": null,
                "modifyEmpId": null,
                "modifyEmp": null
            }
        ],
        "totalPages": 1
    }
    ```

##  门面

### 新增门面

- 接口
  > http://127.0.0.1:8080/house/add

- 方式
  > POST

- 注意，后台只会做以下校验
  - 校验门面编号是否已存在

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | houseCode | 是 | String | 门面编号 
    | address | 是 | String | 门面地址
    | area | 是 | Double | 面积
    | rentFee | 是 | Integer | 租金单价，分/平/月
    | propertyFee | 是 | Integer | 物业费单价，分/平/月
    | remarks | 否 | String | 备注
    | status | 是 | Integer | 状态，0：不可出租；1：可出租； 2：已出租

- 请求参数 JSON 示例
    ```JSON
    {
        "houseCode": "#9-01",
        "address": "湖北省监利县太平洋汽车城",
        "area": 1000,
        "rentFee": 1000,
        "propertyFee": 500,
        "remarks": "都会发生点话费哈收到反馈合适的",
        "status": 1
    }
    ```

- 新增成功返回结果 
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":{
            "id": 41,
            "houseCode": "#9-01",
            "address": "湖北省监利县太平洋汽车城",
            "area": 1000,
            "rentFee": 1000,
            "propertyFee": 500,
            "status": 1,
            "remarks": "都会发生点话费哈收到反馈合适的",
            "createTime": "2018-11-04 09:31:35",
            "createEmpId": 10,
            "createEmp": "超级管理员",
            "modifyTime": null,
            "modifyEmpId": null,
            "modifyEmp": null
        },
        "totalPages": 0
    }
    ```
- 新增重复 houseCode 返回结果
    ```JSON
    {
        "code": 180100001,
        "msg": "房屋编号已存在，新增失败！",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```
### 查询门面列表

- 接口
  > http://127.0.0.1:8080/house/list

- 方式
  > GET

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | pageNum | 是 | Integer | 页码
    | keyWord | 否 | String | 关键字

    - keyWord 可包含的值
    > 门面编号

- 请求示例
    ```JS
    http://127.0.0.1:8080/house/list?pageNum=1&keyWord=10
    ```
- 返回结果 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 57,
                "houseCode": "#9-17",
                "address": "湖北省监利县太平洋汽车城",
                "area": 350,
                "rentFee": 1250,
                "propertyFee": 350,
                "status": 0,
                "remarks": "都会发生点话费哈收到反馈合适的",
                "createTime": "2018-11-04 09:37:27",
                "createEmpId": 10,
                "createEmp": "超级管理员",
                "modifyTime": null,
                "modifyEmpId": null,
                "modifyEmp": null
            }
        ],
        "totalPages": 1
    }
    ```

### 获取可出租门面

- 接口
  > http://127.0.0.1:8080/house/list/available

- 方式
  > GET

- 注意，没有分页

- 返回结果 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 1,
                "houseCode": "3#2-32",
                "address": "湖北省监利县的发生",
                "area": 1000,
                "rentFee": 100000,
                "propertyFee": 10000,
                "status": 1,
                "remarks": "都会发生点话费哈收到反馈合适的",
                "createTime": "2018-10-17T15:13:10.000+0000",
                "createEmpId": 10,
                "createEmp": "超级管理员",
                "modifyTime": null,
                "modifyEmpId": null,
                "modifyEmp": null
            }
        ],
        "totalPages": 0
    }
    ```

##  合同

### 新增合同

- 接口
  > http://127.0.0.1:8080/contract/add

- 方式
  > POST

- 注意，后台会对以下校验，其余校验后台不做处理
  - 判断合同编号是否已存在

- 请求参数
  - contract 

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | merchantId | 是 | Integer | 商户 ID
    | contractCode | 是 | String | 合同编号 
    | business | 是 | String | 经营业务
    | cashBledge | 是 | Integer | 履约保证金，分
    | startDate | 是 | String | 起始日期，格式： "2018-09-11 12:00:00"
    | endDate | 是 | String | 终止日期，格式： "2018-09-11 12:00:00"
    | electricFee | 是 | Integer | 电费单价，分/度
    | waterFee | 是 | Integer | 水费单价，分/吨
    | contractTime | 是 | String | 合同签订时间，格式："2018-09-11 12:00:00"
    | remarks | 否 | String | 备注
    | rentYear | 是 | Integer | 租用年限

  - houseList （数组）

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | id | 是 | Integer | 门面 ID
    | rentFee | 是 | Integer | 租金单价，分/平方米/月
    | propertyFee | 是 | Integer | 物业费单价，分/平方米/月

   - rentMonthList （数组）
     - 数组内的元素为每一年需要缴纳多少个月的租金，例如：[4, 6, 8] 表示 第一年需要缴纳 4 个月的租金；第二年需要缴纳 6 个月的租金；第三年需要缴纳 8 个月的租金。    
     - 数组内的元素为正整数，数组不能为空；

   - propertyMonthList （数组）
     - 数组内的元素为每一年需要缴纳多少个月的物业费，例如：[4, 6, 8] 表示 第一年需要缴纳 4 个月的物业费；第二年需要缴纳 6 个月的物业费；第三年需要缴纳 8 个月的物业费。    
     - 数组内的元素为正整数，数组不能为空；

- 请求参数 JSON 示例
    ```JSON
    {
        "contract": {
            "merchantId": 1,
            "contractCode": "1",
            "business": "经营汽车业务",
            "cashBledge": 1000000,
            "startDate": "2018-09-11 12:00:00",
            "endDate": "2020-09-11 12:00:00",
            "electricFee": 70,
            "waterFee": 1500,
            "contractTime": "2018-09-11 11:00:00",
            "remarks": "dfsasdfasd",
            "rentYear": 3
        },
        "houseList": [
            {
                "id": 37,
                "rentFee": 5000,
                "propertyFee": 3000
            },
            {
                "id": 38,
                "rentFee": 6000,
                "propertyFee": 2000
            },
            {
                "id": 39,
                "rentFee": 1000,
                "propertyFee": 1000
            }
        ],
        "rentMonthList": [
            4, 6, 12
        ],
        "propertyMonthList": [
            12, 12, 12
        ]
    }
    ```

- 新增成功返回结果
    > data 为新增合同的主键

    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": 11,
        "totalPages": 0
    }
    ```

- 新增重复 contractCode 返回结果
    ```JSON
    {
        "code": 180100001,
        "msg": "合同编号已存在，新增失败！",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```

### 查询合同列表
- 接口
  > http://127.0.0.1:8080/contract/list

- 方式
  > GET

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | pageNum | 是 | Integer | 页码
    | keyWord | 否 | String | 关键字

    - keyWord 可包含的值
        > 合同编号/商户编号/公司名称/法人

- 请求参数 JSON 示例
    ```JS
    http://127.0.0.1:8080/contract/list?pageNum=1&keyWord=车
    ```    
- 返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "contract":{
                    "id": 39,
                    "contractCode": "1",
                    "merchantId": 1,
                    "merchantCode": "23234",
                    "coporateBody": "李三",
                    "company": "汽车之家",
                    "business": "经营汽车业务",
                    "cashBledge": 1000000,
                    "startDate": "2018-09-11 12:00:00",
                    "endDate": "2020-09-11 12:00:00",
                    "rentYear": 3,
                    "houseIds": "37,38,39",
                    "waterFee": 1500,
                    "electricFee": 70,
                    "totalUseElectric": 0,
                    "totalPaidElectric": 0,
                    "totalUseElectricFee": 0,
                    "totalPaidElectricFee": 0,
                    "totalUseWater": 0,
                    "totalUseWaterFee": 0,
                    "totalPaidWaterFee": 0,
                    "remarks": "dfsasdfasd",
                    "status": 1,
                    "contractTime": "2018-09-11 11:00:00",
                    "createTime": "2018-11-04 00:36:40",
                    "createEmpId": 10,
                    "createEmp": "超级管理员",
                    "modifyTime": null,
                    "modifyEmpId": null,
                    "modifyEmp": null
                },
                "houseList":[
                    {
                        "id": 193,
                        "houseId": 37,
                        "houseCode": "1#1",
                        "contractId": 39,
                        "contractCode": "1",
                        "area": 10000,
                        "rentFee": 5000,
                        "propertyFee": 3000,
                        "createTime": "2018-11-04 00:37:08",
                        "createEmpId": 10,
                        "createEmp": "超级管理员",
                        "modifyTime": null,
                        "modifyEmpId": null,
                        "modifyEmp": null
                    }
                ],
                "waterMeterList":[
                    {
                        "id": 5,
                        "waterMeterCode": "1",
                        "contractId": 39,
                        "contractCode": "1",
                        "initMark": 100,
                        "totalWater": 0,
                        "waterFee": null,
                        "totalWaterFee": 0,
                        "paidWaterFee": 0,
                        "status": 1,
                        "remarks": "fdsaasdfasd",
                        "createTime": "2018-11-04 10:14:20",
                        "createEmp": "超级管理员",
                        "createEmpId": 10,
                        "modifyTime": null,
                        "modifyEmpId": null,
                        "modifyEmp": null
                    }
                ],
                "electricMeterList":[
                    {
                        "id": 6,
                        "electricMeterCode": "1",
                        "contractId": 39,
                        "contractCode": "1",
                        "voltage": 220,
                        "electricCurrent": 12,
                        "magnification": 1,
                        "initMark": 100,
                        "electricFee": null,
                        "totalUseElectric": 0,
                        "totalPaidElectric": 0,
                        "totalUseElectricFee": null,
                        "totalPaidElectricFee": 0,
                        "status": 1,
                        "remarks": "fdsaasdfasd",
                        "createTime": "2018-11-04 10:24:16",
                        "createEmpId": 10,
                        "createEmp": "超级管理员",
                        "modifyTime": null,
                        "modifyEmpId": null,
                        "modifyEmp": null
                    }
                ]
            }
        ],
        "totalPages": 1
    }
    ```   

##  水表

### 新增水表

- 接口
  > http://127.0.0.1:8080/waterMeter/add

- 方式
  > POST

- 注意，后台只会做以下校验
  - 校验水表编号是否已存在

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | waterMeterCode | 是 | String | 水表编号，不能为纯数字 
    | initMark | 是 | Integer | 水表初始刻度
    | contractId | 是 | Integer | 合同 ID
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "waterMeterCode": "1",
        "initMark": 100,
        "remarks": "fdsaasdfasd",
        "contractId": 11
    }
    ```

- 新增成功返回 JOSN 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":{
            "id": 9,
            "waterMeterCode": "#9-1",
            "contractId": 39,
            "contractCode": "1",
            "initMark": 100,
            "totalWater": null,
            "waterFee": 1500,
            "totalWaterFee": null,
            "paidWaterFee": null,
            "status": 1,
            "remarks": "fdsaasdfasd",
            "createTime": "2018-11-04 18:50:58",
            "createEmp": "超级管理员",
            "createEmpId": 10,
            "modifyTime": null,
            "modifyEmpId": null,
            "modifyEmp": null
        },
        "totalPages": 0
    }
    ```

- 新增重复编号返回结果 JSON 示例
    ```JSON
    {
        "code": 180100001,
        "msg": "水表编号已被使用，新增失败！",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```

### 根据合同 ID 查询水表

- 接口
    > http://127.0.0.1:8080/waterMeter/list

- 方式 
    > GET

- 参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | contractId | 是 | Integer | 合同 ID

- 查询返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 1,
                "waterMeterCode": "1",
                "contractId": 11,
                "contractCode": "5453243",
                "initMark": 100,
                "totalWater": null,
                "waterFee": null,
                "status": 1,
                "remarks": "fdsaasdfasd",
                "createTime": "2018-10-25T14:57:35.000+0000",
                "createEmp": "超级管理员",
                "createEmpId": 10,
                "modifyTime": null,
                "modifyEmpId": null,
                "modifyEmp": null
            }
        ],
        "totalPages": 0
    }
    ```

##  电表

### 新增电表

- 接口
  > http://127.0.0.1:8080/electricMeter/add

- 方式
  > POST

- 注意，后台只会做以下校验
  > 校验电表编号是否重复

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | electricMeterCode | 是 | String | 电表编号，不能为纯数字
    | initMark | 是 | Integer | 电表初始刻度
    | contractId | 是 | Integer | 合同 ID
    | voltage | 是 | Integer | 电压，V
    | electricCurrent | 是 | Integer | 电流，A
    | magnification | 是 | Integer | 倍率 
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
     {
        "electricMeterCode": "1",
        "initMark": 100,
        "remarks": "fdsaasdfasd",
        "contractId": 39,
        "voltage": 220,
        "electricCurrent": 12,
        "magnification": 1
    }
    ```

- 新增成功返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":{
            "id": 6,
            "electricMeterCode": "1",
            "contractId": 39,
            "contractCode": "1",
            "voltage": 220,
            "electricCurrent": 12,
            "magnification": 1,
            "initMark": 100,
            "electricFee": 70,
            "totalUseElectric": null,
            "totalPaidElectric": null,
            "totalUseElectricFee": null,
            "totalPaidElectricFee": null,
            "status": 1,
            "remarks": "fdsaasdfasd",
            "createTime": "2018-11-04 10:24:15",
            "createEmpId": 10,
            "createEmp": "超级管理员",
            "modifyTime": null,
            "modifyEmpId": null,
            "modifyEmp": null
        },
        "totalPages": 0
    }
    ```

- 新增重复电表编号返回 JSON 
    ```JSON
    {
        "code": 180100001,
        "msg": "电表编号已被使用，新增失败！",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```

### 根据合同 ID 查询电表

- 接口
    > http://127.0.0.1:8080/electricMeter/list?contractId=11

- 方式
    > GET

 - 参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | contractId | 是 | Integer | 合同 ID

- 返回结果 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 6,
                "electricMeterCode": "1",
                "contractId": 39,
                "contractCode": "1",
                "voltage": 220,
                "electricCurrent": 12,
                "magnification": 1,
                "initMark": 100,
                "electricFee": null,
                "totalUseElectric": 0,
                "totalPaidElectric": 0,
                "totalUseElectricFee": null,
                "totalPaidElectricFee": 0,
                "status": 1,
                "remarks": "fdsaasdfasd",
                "createTime": "2018-11-04 10:24:16",
                "createEmpId": 10,
                "createEmp": "超级管理员",
                "modifyTime": null,
                "modifyEmpId": null,
                "modifyEmp": null
            }
        ],
        "totalPages": 0
    }
    ```
 

##  电表用量记录

### 新增电表用量记录

- 接口
  > http://127.0.0.1:8080/electricMeter/record/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | electricMeterId | 是 | Integer | 电表 ID
    | currentMark | 是 | Integer | 当前刻度
    | markDate | 是 | String | 抄表日期 

- 请求参数 JSON 示例
    ```JSON
    {
        "electricMeterId": 18,
        "currentMark": 122,
        "markDate": "2018-11-23 11:00:00"
    }
    ```

##  水表用量记录

### 新增水表用量记录

- 接口
  > http://127.0.0.1:8080/waterMeter/record/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | waterMeterId | 是 | Integer | 水表 ID
    | currentMark | 是 | Integer | 当前刻度
    | markDate | 是 | String | 抄表日期 

- 请求参数 JSON 示例
    ```JSON
    {
        "waterMeterId": 56453,
        "currentMark": 122,
        "markDate": "2018-11-23 11:00:00"
    }
    ```

## 水电表记录管理

### 水表记录导入

 -  接口
    > http://127.0.0.1:8080/waterMeter/record/upload   
    > file 参数名为 excel

 - 遗留问题，没有对导入的刻度于数据库的刻度比较大小

 - excel 模板说明
  - 编号单元格格式须为 文本
  - 抄表时间单元格须为 文本，且格式固定为 yyyy-MM-dd，例如：2018-08-04
  - 水表刻度单元格须为 数字，且不能有小数位

 - excel 如果为空，返回 JSON 如下
    ```JSON
    {
        "code": 180100001,
        "msg": "excel 为空，导入失败",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```
  - excel 中有问题数据，返回 JSON 如下
    ```JSON
    {
        "code": 100300001,
        "msg": "excel 数据有问题，导入失败",
        "success": false,
        "data":[
            {
                "lineNum": 3,
                "message": "存在空数据"
            },
            {
                "lineNum": 4,
                "message": "存在空数据"
            },
            {
                "lineNum": 2,
                "message": "日期不是 2018-10-31 这种格式 或者刻度值不为正整数"
            },
            {
                "lineNum": 4,
                "message": "日期不是 2018-10-31 这种格式 或者刻度值不为正整数"
            },
            {
                "lineNum": 5,
                "message": "在 excel 中存在多个此编号:#9-3"
            },
            {
                "lineNum": 6,
                "message": "在 excel 中存在多个此编号:#9-3"
            },
            {
                "lineNum": 1,
                "message": "这些列出来的表编号在系统中不存在：,#9-5,#9-8"
            }
        ],
        "totalPages": 0
    }
    ```

 - 导入成功，返回 JSON
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": null,
        "totalPages": 0
    }
    ```

### 电表记录导入

 -  接口
    > http://127.0.0.1:8080/electricMeter/record/upload   
    > file 参数名为 excel

 - 遗留问题，没有对导入的刻度于数据库的刻度比较大小

 - excel 模板说明
  - 编号单元格格式须为 文本
  - 抄表时间单元格须为 文本，且格式固定为 yyyy-MM-dd，例如：2018-08-04
  - 水表刻度单元格须为 数字，且不能有小数位

 - excel 如果为空，返回 JSON 如下
    ```JSON
    {
        "code": 180100001,
        "msg": "excel 为空，导入失败",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```
  - excel 中有问题数据，返回 JSON 如下
    ```JSON
    {
        "code": 100300001,
        "msg": "excel 数据有问题，导入失败",
        "success": false,
        "data":[
            {
                "lineNum": 3,
                "message": "存在空数据"
            },
            {
                "lineNum": 4,
                "message": "存在空数据"
            },
            {
                "lineNum": 2,
                "message": "日期不是 2018-10-31 这种格式 或者刻度值不为正整数"
            },
            {
                "lineNum": 4,
                "message": "日期不是 2018-10-31 这种格式 或者刻度值不为正整数"
            },
            {
                "lineNum": 5,
                "message": "在 excel 中存在多个此编号:#9-3"
            },
            {
                "lineNum": 6,
                "message": "在 excel 中存在多个此编号:#9-3"
            },
            {
                "lineNum": 1,
                "message": "这些列出来的表编号在系统中不存在：,#9-5,#9-8"
            }
        ],
        "totalPages": 0
    }
    ```

 - 导入成功，返回 JSON
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": null,
        "totalPages": 0
    }
    ```

### 水表管理列表
 
 - 水表列表接口
   - http://127.0.0.1:8080/waterMeter/manage/meter/list
   - 参数
     - keyWord: 合同编号或水表编号，选填
     - pageNum: 页码，选填

 - 水表记录列表接口
   - http://127.0.0.1:8080/waterMeter/manage/record/list?waterMeterId=9
   - 参数
     - waterMeterId 必填

### 电表管理列表
 
 - 电表列表接口
   - http://127.0.0.1:8080/electricMeter/manage/meter/list
   - 参数
     - keyWord: 合同编号或电表编号，选填
     - pageNum: 页码，选填

 - 电表记录列表接口
   - http://127.0.0.1:8080/electricMeter/manage/record/list?electricMeterId=9
   - 参数
     - electricMeterId 必填

##  收费

### 新增收费

- 接口
  > http://127.0.0.1:8080/charge/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | contractId | 是 | Integer | 合同 ID 
    | paidFee | 是 | Integer | 缴费金额，分
    | paidTime | 否 | String | 缴费时间
    | paidMethod | 是 | Integer | 缴费方式，0：现金；1：微信；2：支付宝；3：银行转账；4：刷卡
    | paidMan | 是 | String | 缴费人
    | feeType | 是 | Integer | 费用类型，0：租金；1： 物业：2： 水费; 3:电费
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "contractId": 39,
        "paidFee": 234,
        "paidTime": "2018-11-04 22:08:57",
        "paidMethod": 1,
        "paidMan": "dsfa",
        "feeType": 1,
        "remarks": "fdsafsadf"
    }
    ```



### 收费管理列表
- 接口
  > http://127.0.0.1:8080/charge/list

- 方式
  > GET

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | pageNum | 否 | Integer | 页码
    | keyWord | 否 | String | 关键字

    - keyWord 可包含的值
       > 合同编号/商户编号/公司名称/法人

- 请求参数 JSON 示例
    ```JS
    http://127.0.0.1:8080/charge/list?pageNum=1&keyWord=车
    ```    
- 返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "chargeMainInfo":{
                    "contractId": 39,
                    "merchantCode": "23234",
                    "company": "汽车之家",
                    "coporateBody": "李三",
                    "contractCode": "1",
                    "totalRentFee": 1468643000,
                    "paidRentFee": 500000000,
                    "restRentFee": 968643000,
                    "totalPropertyFee": 1352034000,
                    "paidPropertyFee": 35478117,
                    "restPropertyFee": 852034000,
                    "totalWaterFee": 150000,
                    "paidWaterFee": 18134,
                    "restWaterFee": 131866,
                    "paidElectricFee": 24000,
                    "usedElectricFee": 15400,
                    "restElectricFee": 8600
                },
                "houseFeeList":[
                    {
                        "contractId": 39,
                        "payDeadline": "2018-09-11 12:00:00",
                        "sortYear": 1,
                        "totalRentFee": 267026000,
                        "totalPropertyFee": 450678000,
                        "paidRentFee": 267026000,
                        "paidPropertyFee": 35478039,
                        "restRentFee": 0,
                        "restPropertyFee": 0
                    },
                    {
                        "contractId": 39,
                        "payDeadline": "2019-09-11 12:00:00",
                        "sortYear": 2,
                        "totalRentFee": 400539000,
                        "totalPropertyFee": 450678000,
                        "paidRentFee": 232974000,
                        "paidPropertyFee": 39,
                        "restRentFee": 167565000,
                        "restPropertyFee": 401356000
                    },
                    {
                        "contractId": 39,
                        "payDeadline": "2020-09-11 12:00:00",
                        "sortYear": 3,
                        "totalRentFee": 801078000,
                        "totalPropertyFee": 450678000,
                        "paidRentFee": 0,
                        "paidPropertyFee": 39,
                        "restRentFee": 801078000,
                        "restPropertyFee": 450678000
                    }
                ]
            }
        ],
        "totalPages": 1
    }
    ```   

### 收费记录日志

- 接口
    > http://127.0.0.1:8080/charge/log/list?contractId=39&feeType=2

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | contractId | 是 | Integer | 合同 ID
    | feeType | 否 | Integer | 费用类型，0：租金；1： 物业：2： 水费; 3:电费

- 返回结果 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 12,
                "contractCode": "1",
                "contractId": 39,
                "paidFee": 500000000,
                "paidTime": "2018-11-04 22:08:57",
                "paidMethod": 1,
                "electricMeterCode": null,
                "electric": null,
                "paidMan": "dsfa",
                "chargeMan": "sie",
                "remarks": "fdsafsadf",
                "feeType": 0,
                "status": 1,
                "createEmpId": 10,
                "createEmp": "超级管理员",
                "createTime": "2018-11-04 23:49:48",
                "modifyEmpId": null,
                "modifyEmp": null,
                "modifyTime": null
            }
        ],
        "totalPages": 0
    }
    ```

## 物资管理

### 物资新增

- 接口
    > http://127.0.0.1:8080/material/add
- 方式
    > POST
- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | type | 是 | String | 物资类型
    | name | 是 | String | 物资名称 
    | stockAddr | 是 | String | 存储地址
    | format | 否 | String | 规格，单位
    | reamrks | 否 | String | 备注

- 参数请求 JSON 示例
    ```JSON
    {
        "type": "计算机",
        "name": "台式电脑",
        "format": "台",
        "stockAddr": "仓库",
        "remarks": "办公电脑"
    }
    ```
- 新增成功返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": "SUCCESS",
        "totalPages": 0
    }
    ```
- 添加重复名称物资返回 JSON 示例
    ```JSON
    {
        "code": 180100001,
        "msg": "物资名已存在，新增失败!",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```
### 物资修改接口

- 接口
    > http://127.0.0.1:8080/material/update

- 方式
    > POST

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | type | 否 | String | 物资类型
    | name | 否 | String | 物资名称 
    | stockAddr | 否 | String | 存储地址
    | format | 否 | String | 规格，单位
    | reamrks | 否 | String | 备注

- 修改成功返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": "SUCCESS",
        "totalPages": 0
    }
    ```

- 如果新的物资名为数据库中已存在的其它物资的名称，则会如下 JSON 示例
    ```JSON
    {
        "code": 180100001,
        "msg": "物资名已存在，修改失败!",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```

### 物资列表接口

- 接口
    > http://127.0.0.1:8080/material/list?pageNum=1&keyWord=洗

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | pageNum | 否 | Integer | 页码
    | keyWord | 否 | String | 关键字，限物资类型名称和物资名称 

- 方式
    > GET

- 请求成功返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 7,
                "type": "清洁",
                "name": "洗洁精",
                "format": "瓶",
                "stockAddr": "仓库",
                "stockNum": 0,
                "remarks": "清洁工具",
                "createEmp": "超级管理员",
                "createEmpId": 10,
                "createTime": "2018-11-11 17:34:53",
                "modifyEmp": null,
                "modifyEmpId": null,
                "modifyTime": null
            },
            {
                "id": 8,
                "type": "清洁",
                "name": "洗衣粉",
                "format": "袋",
                "stockAddr": "仓库",
                "stockNum": 0,
                "remarks": "清洁工具",
                "createEmp": "超级管理员",
                "createEmpId": 10,
                "createTime": "2018-11-11 17:35:12",
                "modifyEmp": null,
                "modifyEmpId": null,
                "modifyTime": null
            }
        ],
        "totalPages": 1
    }
    ```
### 入库接口

- 接口
    > http://127.0.0.1:8080/stock/in

- 方式
    > POST

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | materialId | 是 | Integer | 物资的主键
    | num | 是 | Integer | 入库数量，正整数
    | price | 是 | Integer | 正整数，总价钱
    | purchaseMan | 是 | String | 采购人姓名
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "materialId": 2,
        "num":2,
        "price":30,
        "purchaseMan":"李四",
        "remarks": "test"
    }
    ```
- 入库成功返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": null,
        "totalPages": 0
    }
    ```

### 出库接口

- 接口
    > http://127.0.0.1:8080/stock/out

- 方式
    > POST

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | materialId | 是 | Integer | 物资的主键
    | num | 是 | Integer | 出库数量，正整数
    | depart | 是 | String | 使用部门
    | user | 是 | String | 领用人
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "materialId": 1,
        "num":2,
        "depart":"财务",
        "user":"不靠谱",
        "remarks": "test"
    }
    ```
- 入库成功返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": null,
        "totalPages": 0
    }
    ```
- 出库数量超过库存返回 JSON 示例
    ```JSON
    {
        "code": 1004000001,
        "msg": "出库数量超过库存，清刷新当前页面",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```
### 单个物资的入库列表接口

- 接口
    > http://127.0.0.1:8080/stock/list/material/in?materialId=2

- 方式
    > GET

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | materialId | 是 | Integer | 物资的主键

- 请求成功返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 1,
                "materialId": 2,
                "num": 2,
                "price": 30,
                "purchaseMan": "李四",
                "remarks": null,
                "createEmp": "超级管理员",
                "createEmpId": 10,
                "createTime": "2018-11-11 18:32:30",
                "modifyEmp": null,
                "modifyEmpId": null,
                "modifyTime": null
            },
            {
                "id": 2,
                "materialId": 2,
                "num": 5,
                "price": 75,
                "purchaseMan": "李四",
                "remarks": null,
                "createEmp": "超级管理员",
                "createEmpId": 10,
                "createTime": "2018-11-11 18:33:41",
                "modifyEmp": null,
                "modifyEmpId": null,
                "modifyTime": null
            }
        ],
        "totalPages": 0
    }
    ```

### 单个物资的出库列表接口

- 接口
    > http://127.0.0.1:8080/stock/list/material/out?materialId=4

- 方式
    > GET

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | materialId | 是 | Integer | 物资的主键

- 请求成功返回 JSON 示例
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data":[
            {
                "id": 1,
                "materialId": 4,
                "num": 2,
                "depart": "财务",
                "user": "不靠谱",
                "remarks": null,
                "createEmp": "超级管理员",
                "createEmpId": 10,
                "createTime": "2018-11-11 18:43:50",
                "modifyEmp": null,
                "modifyEmpId": null,
                "modifyTime": null
            }
        ],
        "totalPages": 0
    }
    ```

## 修改商户状态接口

- 接口
    > http://127.0.0.1:8080/merchant/update/status

- 方式
    > POST

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | id | 是 | Integer | 商户主键
    | status | 是 | Integer | 商户状态，0：下线； 1：在线

- 参数请求 JSON 示例
    ```JSON
    {
        "id":1,
        "status":0
    }
    ```
- 如果商户还存在有效合同，这时将其状态设置为 0，会返回如下 JSON
    ```JSON
    {
        "code": 1007000001,
        "msg": "该商户存在有效合同，不能修改状态，修改失败",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```
- 状态修改成功，返回如下 JSON
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": null,
        "totalPages": 0
    }
    ```

## 修改合同状态接口

- 接口
    > http://127.0.0.1:8080/contract/release

- 方式
    > POST

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | id | 是 | Integer | 合同主键
    | status | 是 | Integer | 合同状态，0：无效；2：终止合同； 只能将合同状态设置为无效或者是终止合同

- 参数请求 JSON 示例
    ```JSON
    {
        "id": 40,
        "status": 2
    }
    ```
- 修改成功，返回 JSON 如下
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": null,
        "totalPages": 0
    }
    ```
- 对已为无效或终止状态的合同进行修改，会返回如下 JSON
    ```JSON
    {
        "code": 1006000001,
        "msg": "合同已为无效或终止状态，不能再对其进行修改，修改失败",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```

## 修改门面状态接口

- 接口
    > http://127.0.0.1:8080/house/update/status

- 方式
    > POST

- 请求参数

     | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | id | 是 | Integer | 门面主键
    | status | 是 | Integer | 门面状态，0：不可出租；1：可出租; 调用此接口时，只能对当前状态为可出租或不可出租的门面进行修改

- 参数请求 JSON 示例
    ```JSON
    {
        "id": 18,
        "status": 1
    }
    ```
- 对状态为已出租的门面进行修改，会返回如下 JSON
    ```JSON
    {
        "code": 1005000001,
        "msg": "门面已出租，禁止修改状态，修改失败",
        "success": false,
        "data": null,
        "totalPages": 0
    }
    ```
- 修改成功，返回如下 JSON
    ```JSON
    {
        "code": 180100000,
        "msg": "操作成功",
        "success": true,
        "data": null,
        "totalPages": 0
    }
    ```