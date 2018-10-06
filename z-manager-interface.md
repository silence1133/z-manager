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

##  商户

### 新增商户

- 接口
  >http://127.0.0.1:8080/merchant/add

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
        "enteringTime": "2018-09-09 12:00:000"
    }
    ```

### 查询商户列表

- 接口
  >http://127.0.0.1:8080/merchant/list

- 方式
  > get

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | merchantCode | 是 | String | 商户编号 
    | company | 是 | String |公司名称 
    | page | 是 | int |页码

- 请求参数 JSON 示例
    ```JSON
    {
        "merchantCode": "23234",
        "company": "汽车之家",
	"page":1
    }
    ```
- 返回 JSON 示例
 ```JSON
 {
    "code": 180100000,
    "msg": "操作成功",
    "success": true,
    "data":[{
        "id": 1,
	    "merchantCode": 23234,
	    "company": "汽车之家",
	    "corporateBody": "李三",
	    "idCard": 4216826866886868,
	    "linkMan": "张孝勇",
	    "linkPhone": 352324233,
	    "brand": "宝马奔驰",
	    "address": "范德萨发生大发生的",
	    "remarks": "dfsasdfasd",
	    "enteringTime": "2018-09-09 12:00:000",
		"createTime": "2018-09-22 17:06:07",
		"createEmp": "zxy",
		"modifyTime": "2018-09-22 17:06:07",
		"modifyEmp": "zxy",
		"status": 2
    }],
    "totalPages":5
}
 ```

##  门面

### 新增门面

- 接口
  >http://127.0.0.1:8080/house/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | houseCode | 是 | String | 门面编号 
    | address | 是 | String | 门面地址
    | area | 是 | Double | 面积
    | rentFee | 是 | Integer | 租金单价，分/平/月
    | propertyFee | 是 | Integer | 物业费单，分/平/月
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "houseCode": "3#2-32",
        "address": "湖北省监利县的发生",
        "area": 1000,
        "rentFee": 100000,
        "propertyFee": 10000,
        "remarks": "都会发生点话费哈收到反馈合适的"
    }
    ```
### 查询门面列表

- 接口
  >http://127.0.0.1:8080/house/list

- 方式
  > get

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | houseCode | 是 | String | 门面编号
    | page | 是 | int |页码

- 请求参数 JSON 示例
    ```JSON
    {
        "houseCode": "3#2-32",
	"page":1
    }
    ```
- 返回结果 JSON 示例
    ```JSON
	{
	    "code": 180100000,
	    "msg": "操作成功",
	    "success": true,
	    "data":[{
		"id": 1,
		"houseCode": "3#2-32",
		"address": "湖北省监利县的发生",
		"area": 1000,
		"rentFee": 100000,
		"propertyFee": "10000",
		"remarks": "都会发生点话费哈收到反馈合适的",
		"status":1,
		"createTime":"2018-09-22 17:06:07",
		"createEmp":"zxy",
		"modifyTime":"2018-09-22 17:06:07",
		"modifyEmp":"zxy",
		"status": 2
	    }],
	    "totalPages":5
	}
    ```

##  合同

### 新增合同

- 接口
  >http://127.0.0.1:8080/contract/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | contractCode | 是 | String | 合同编号 
    | business | 是 | String | 经营业务
    | cashBledge | 是 | Integer | 履约保证金，分
    | startDate | 是 | String | 起始日期
    | endDate | 是 | String | 终止日期
    | electricFee | 是 | Integer | 电费单价，分/度
    | waterFee | 是 | Integer | 水费单价，分/吨
    | contractTime | 是 | String | 合同签订时间
    | remarks | 否 | String | 备注
    | rentYear | 是 | Integer | 租用年限
    | house | 是 | List | 租用门面信息
    | rentMonth | 是 | String | 租金缴纳比例分配
    | propertyMonth | 是 | String | 物业费缴纳比例分配

- house 包含的字段

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:     
    | houseId | 是 | Integer | 门面 ID
    | houseCode | 是 | String | 门面编号
    | rentFee | 是 | Integer | 租金单价，分/平/月
    | propertyFee | 是 | Integer | 物业管理费单价，分/平/月

- 请求参数 JSON 示例
    ```JSON
    {
        "contractCode": 5453243,
        "business": "经营业务",
        "cashBledge": 100000,
        "startDate": "2018-09-11 12:00:00",
        "endDate": "2019-09-11 12:00:00",
        "electricFee": 20000,
        "waterFee": 10000,
        "contractTime": "2019-09-11 11:00:00",
        "remarks": "dfsasdfasd",
        "rentYear": 2,
        "house": [
            {
                "houseId": 2342423,
                "houseCode": "3#342-1",
                "rentFee": 10000,
                "propertyFee": 20000
            }
        ],
        "rentMonth": "6,4",
        "propertyMonth": "12,12"
    }
    ```
### 查询合同列表
- 接口
  >http://127.0.0.1:8080/contract/list

- 方式
  > get

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | contractCode | 是 | String | 合同编号 
    | merchantCode | 是 | String | 商户编号
    | company | 是 | Integer | 公司
    | page | 是 | int |页码

- 请求参数 JSON 示例
    ```JSON
    {
        "contractCode": 5453243,
        "contractCode": "3ds222",
        "company": "汽车之家",
	"page":1
    }
    ```    
- 返回 JSON 示例
    ```JSON
	{
	    "code": 180100000,
	    "msg": "操作成功",
	    "success": true,
	    "data":[{
		    "id": 1,
		    "merchantCode": "23234",
		    "contractCode": "5453243",
		    "company": "汽车之家",
		    "corporateBody": "李三",
		    "linkMan": "张孝勇",
		    "linkPhone": "352324233",
		    "business": "经营业务",
		    "cashBledge": 100000,
		    "startDate": "2018-09-11 12:00:00",
		    "endDate": "2019-09-11 12:00:00",
		    "electricFee": 20000,
		    "waterFee": 10000,
		    "contractTime": "2019-09-11 11:00:00",
		    "rentYear": 2,
		    "house": [
			{
			    "houseId": 2342423,
			    "houseCode": "3#342-1",
			    "rentFee": 10000,
			    "propertyFee": 20000
			}
		    ],
		    "remarks": "dfsasdfasd",
		    "enteringTime": "2018-09-09 12:00:000",
			"createTime": "2018-09-22 17:06:07",
			"createEmp": "zxy",
			"status": 1
	    }],
	    "totalPages":5
	}
    ```   

##  水表

### 新增水表

- 接口
  >http://127.0.0.1:8080/waterMeter/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | waterMeterCode | 是 | String | 水表编号 
    | initMark | 是 | String | 水表初始刻度
    | contractId | 是 | Integer | 合同 ID
    | contractCode | 是 | String | 合同编号
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "waterMeterCode": 3425342,
        "initMark": 100,
        "remarks": "fdsaasdfasd",
        "contractId": 4235234,
        "contractCode": 32364545
    }
    ```

##  电表

### 新增电表

- 接口
  >http://127.0.0.1:8080/electricMeter/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | electircMeterCode | 是 | String | 电表编号 
    | initMark | 是 | String | 电表初始刻度
    | contractId | 是 | Integer | 合同 ID
    | contractCode | 是 | String | 合同编号
    | voltage | 是 | Integer | 电压，V
    | electricCurrent | 是 | Integer | 电流，A
    | magnification | 是 | Integer | 倍率 
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "electircMeterCode": 3425342,
        "initMark": 100,
        "remarks": "fdsaasdfasd",
        "contractId": 4235234,
        "contractCode": 32364545,
        "voltage": 220,
        "electricCurrent": 12,
        "magnification": 22
    }
    ```

##  电表用量记录

### 新增电表用量记录

- 接口
  >http://127.0.0.1:8080/electricRecord/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | electircMeterCode | 是 | String | 电表编号 
    | endMark | 是 | Integer | 止码
    | markDate | 是 | String | 抄表日期 
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "electircMeterCode": 56453,
        "remarks": "fdsaasdfasd",
        "endMark": 122,
        "markDate": "2018-09-09"
    }
    ```

##  水表用量记录

### 新增水表用量记录

- 接口
  >http://127.0.0.1:8080/waterRecord/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | electircMeterCode | 是 | String | 水表编号 
    | endMark | 是 | Integer | 止码
    | markDate | 是 | String | 抄表日期 
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "waterMeterCode": 56453,
        "remarks": "fdsaasdfasd",
        "endMark": 122,
        "markDate": "2018-09-09"
    }
    ```

##  收费

### 新增收费

- 接口
  >http://127.0.0.1:8080/charge/add

- 方式
  > POST

- 请求参数

    | 字段 | 是否必填 | 类型 |描述
    |:--:|:--:|:--:|:--:
    | contractId | 是 | Integer | 合同 ID 
    | contractCode | 是 | String | 合同编号
    | paidFee | 是 | Integer | 缴费金额，分
    | paidTime | 否 | String | 缴费时间
    | paidMethod | 是 | Integer | 缴费方式，0：现金；1：微信；2：支付宝；3：银行转账；4：刷卡
    | paidMan | 是 | String | 缴费人
    | feeType | 是 | Integer | 费用类型，0：租金；1： 物业：2： 水费; 3:电费
    | chargeMan | 是 | String | 收费人
    | remarks | 否 | String | 备注

- 请求参数 JSON 示例
    ```JSON
    {
        "contractId": 56453,
        "contractCode": 1,
        "paidFee": 234,
        "paidTime": "2018-09-09 13:33",
        "paidMethod": 1,
        "paidMan": "dsfa",
        "feeType": 1,
        "remarks": "fdsafsadf",
        "chargeMan": "sie"
    }
    ```
