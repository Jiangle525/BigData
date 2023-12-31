# 大事记接口文档-V1.0

## 1. 用户相关接口

### 1.1 注册

#### 1.1.1 基本信息

> 请求路径：/user/register
>
> 请求方式：POST
>
> 接口描述：注册新用户

#### 1.1.2 请求参数

- 请求参数格式：x-www-form-urlencoded

- 请求参数说明：

    | 参数名称 | 说明   | 类型   | 是否必须 | 备注            |
    | -------- | ------ | ------ | -------- | --------------- |
    | username | 用户名 | string | 是       | 4~20位非空字符  |
    | password | 密码   | string | 是       | 8~128位非空字符 |

- 请求参数样例：

    ```
    username=zhangsan&password=123456
    ```

#### 1.1.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |
  
- 响应数据样例：

  ```
  {"code":0,"message":"操作成功","data":null}
  ```

  


### 1.2 登录

#### 1.2.1 基本信息

> 请求路径：/user/login
>
> 请求方式：POST
>
> 接口描述：用户登录

#### 1.2.2 请求参数

- 请求参数格式：x-www-form-urlencoded

- 请求参数说明：

    | 参数名称 | 说明   | 类型   | 是否必须 | 备注            |
    | -------- | ------ | ------ | -------- | --------------- |
    | username | 用户名 | string | 是       | 4~20位非空字符  |
    | password | 密码   | string | 是       | 8~128位非空字符 |

- 请求参数样例：

    ```
    username=zhangsan&password=123456
    ```

#### 1.2.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | jwt令牌               |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjbGFpbXMiOnsiaWQiOjEwLCJ1c2VybmFtZSI6InpoYW4xMTExIn0sImV4cCI6MTcwMTY3MzQzOH0.38B5nkgUUc5btLqVb910Q7HKXHoUcikdSf-pLIcHeaY"
  }
  ```

#### 1.2.4 备注说明

> 用户登录成功后，系统会自动下发jwt令牌，在后续的每次请求中，浏览器都需要在请求头header中携带到服务端，请求头的名称为Authorization，值为登录时下发的jwt令牌。
> 如果检测到用户未登录，则http响应状态码为401



### 1.3 获取用户详细信息

#### 1.3.1 基本信息

> 请求路径：/user/userinfo
>
> 请求方式：GET
>
> 接口描述：获取当前已登录用户的详细信息

#### 1.3.2 请求参数

- 无

#### 1.3.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称           | 说明       | 类型   | 是否必须 | 备注                  |
  | -------------- | ---------- | ------ | -------- | --------------------- |
  | code           | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message        | 响应消息   | string | 否       | \                     |
  | data           | 返回的数据 | object | 是       | \                     |
  | \|--username   | 用户名     | string | 否       | \                     |
  | \|--nickname   | 昵称       | string | 否       | \                     |
  | \|--email      | 邮箱       | string | 否       | \                     |
  | \|--userPic    | 头像       | string | 否       | 头像链接              |
  | \|--createTime | 创建时间   | string | 否       | \                     |
  | \|--updateTime | 修改时间   | string | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": {
          "username": "zhangsan",
          "nickname": "",
          "email": "",
          "userPic": "",
          "createTime": "2023-12-03T02:22:37.000+00:00",
          "updateTime": "2023-12-03T02:22:37.000+00:00"
      }
  }
  ```



### 1.4 更新用户基本信息

#### 1.4.1 基本信息

> 请求路径：/user/update
>
> 请求方式：PUT
>
> 接口描述：更新已登录的用户基本信息（除头像和密码）

#### 1.4.2 请求参数

- 请求参数格式：application/json

- 请求参数说明：

  | 参数名称 | 说明   | 类型   | 是否必须 | 备注             |
  | -------- | ------ | ------ | -------- | ---------------- |
  | username | 用户名 | string | 否       | 用户名不允许修改 |
  | nickname | 昵称   | string | 否       | 2~20位非空字符   |
  | email    | 邮箱   | string | 否       | 满足邮箱格式     |

- 请求参数样例：

  ```
  {
      "username":"wangliu",
      "nickname":"王六",
      "email":"123@qq.com"
  }
  ```

#### 1.4.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



### 1.5 更新用户头像

#### 1.5.1 基本信息

> 请求路径：/user/updateAvatar
>
> 请求方式：PATCH
>
> 接口描述：更新已登录用户头像

#### 1.5.2 请求参数

- 请求参数格式：queryString

- 请求参数说明：

  | 参数名称  | 说明     | 类型   | 是否必须 | 备注          |
  | --------- | -------- | ------ | -------- | ------------- |
  | avatarUrl | 头像地址 | string | 是       | 合法的url地址 |

- 请求参数样例：

  ```
  avatarUrl=https://xxx.jpg
  ```

#### 1.5.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



### 1.6 更新用户密码

#### 1.6.1 基本信息

> 请求路径：/user/updatePwd
>
> 请求方式：PATCH
>
> 接口描述：更新已登录用户的密码

#### 1.6.2 请求参数

- 请求参数格式：application/json

- 请求参数说明：

  | 参数名称 | 说明       | 类型   | 是否必须 | 备注                           |
  | -------- | ---------- | ------ | -------- | ------------------------------ |
  | old_pwd  | 原密码     | string | 是       | \                              |
  | new_pwd  | 新密码     | string | 是       | 8~128位非空字符，且2次密码相同 |
  | re_pwd   | 重复新密码 | string | 是       | 8~128位非空字符，且2次密码相同 |

- 请求参数样例：

  ```
  {
      "old_pwd":"121213123",
      "new_pwd":"121213123",
      "re_pwd":"121213123"
  }
  ```

#### 1.6.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



## 2. 文章分类相关接口

### 2.1 新增文章分类

#### 2.1.1 基本信息

> 请求路径：/category
>
> 请求方式：POST
>
> 接口描述：新增文章分类

#### 2.1.2 请求参数

- 请求参数格式：applicatioin/json

- 请求参数说明：

  | 参数名称      | 说明     | 类型   | 是否必须 | 备注 |
  | ------------- | -------- | ------ | -------- | ---- |
  | categoryName  | 分类名称 | string | 是       | \    |
  | categoryAlias | 分类别名 | string | 否       | \    |

- 请求参数样例：

  ```
  {
      "categoryName": "news",
      "categoryAlias": "新闻"
  }
  ```

#### 2.1.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



### 2.2 文章分类列表

#### 2.2.1 基本信息

> 请求路径：/category/list
>
> 请求方式：GET
>
> 接口描述：获取文章分类列表

#### 2.2.2 请求参数

- 无


#### 2.2.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称              | 说明       | 类型   | 是否必须 | 备注                  |
  | ----------------- | ---------- | ------ | -------- | --------------------- |
  | code              | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message           | 响应消息   | string | 否       | \                     |
  | data              | 返回的数据 | array  | 是       | 查询不到返回[]        |
  | \|--categoryName  | 分类名称   | string | 否       | \                     |
  | \|--categoryAlias | 分类别名   | string | 否       | \                     |
  | \|--createTime    | 创建时间   | string | 否       | \                     |
  | \|--updateTime    | 修改时间   | string | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": [
          {
              "categoryName": "人文",
              "categoryAlias": "rw",
              "createTime": "2023-12-04 17:52:14",
              "updateTime": "2023-12-04 17:52:14"
          },
          {
              "categoryName": "news",
              "categoryAlias": "新闻",
              "createTime": "2023-12-04 18:23:27",
              "updateTime": "2023-12-04 18:23:27"
          }
      ]
  }
  ```



### 2.3 获取文章分类详情

#### 2.3.1 基本信息

> 请求路径：/category/details
>
> 请求方式：GET
>
> 接口描述：获取指定文章分类的详情

#### 2.3.2 请求参数

- 请求参数格式：queryString

- 请求参数说明：

  | 参数名称     | 说明     | 类型   | 是否必须 | 备注 |
  | ------------ | -------- | ------ | -------- | ---- |
  | categoryName | 分类名称 | string | 是       | \    |
  
- 请求参数样例：

  ```
  categoryName=news
  ```

#### 2.3.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称              | 说明       | 类型   | 是否必须 | 备注                  |
  | ----------------- | ---------- | ------ | -------- | --------------------- |
  | code              | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message           | 响应消息   | string | 否       | \                     |
  | data              | 返回的数据 | object | 否       | 查询不到返回null      |
  | \|--categoryName  | 分类名称   | string | 否       | \                     |
  | \|--categoryAlias | 分类别名   | string | 否       | \                     |
  | \|--createTime    | 创建时间   | string | 否       | \                     |
  | \|--updateTime    | 修改时间   | string | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": {
          "categoryName": "news",
          "categoryAlias": "新闻",
          "createTime": "2023-12-04 18:23:27",
          "updateTime": "2023-12-04 18:23:27"
      }
  }
  ```



### 2.4 更新文章分类

#### 2.4.1 基本信息

> 请求路径：/category/updateCategory
>
> 请求方式：PUT
>
> 接口描述：更新某个分类的信息

#### 2.4.2 请求参数

- 请求参数格式：application/json

- 请求参数说明：

  | 参数名称      | 说明     | 类型   | 是否必须 | 备注 |
  | ------------- | -------- | ------ | -------- | ---- |
  | categoryName  | 分类名称 | string | 是       | \    |
  | categoryAlias | 分类别名 | string | 否       | \    |

- 请求参数样例：

  ```
  {
      "categoryName": "news",
      "categoryAlias": "ns"
  }
  ```

#### 2.4.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



### 2.5 删除文章分类

#### 2.5.1 基本信息

> 请求路径：/category/deleteCategory
>
> 请求方式：DELETE
>
> 接口描述：删除某个分类

#### 2.5.2 请求参数

- 请求参数格式：queryParams

- 请求参数说明：

  | 参数名称     | 说明     | 类型   | 是否必须 | 备注 |
  | ------------ | -------- | ------ | -------- | ---- |
  | categoryName | 分类名称 | string | 是       | \    |
  
- 请求参数样例：

  ```
  categoryName=news
  ```

#### 2.5.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



## 3. 文章相关接口

### 3.1 新增文章

#### 3.1.1 基本信息

> 请求路径：/article/addArticle
>
> 请求方式：POST
>
> 接口描述：新增文章 

#### 3.1.2 请求参数

- 请求参数格式：application/json

- 请求参数说明：

  | 参数名称     | 说明     | 类型   | 是否必须 | 备注              |
  | ------------ | -------- | ------ | -------- | ----------------- |
  | title        | 标题     | string | 是       | 1~32个非空字符    |
  | content      | 正文     | string | 是       | 0~10000个非空字符 |
  | coverImg     | 封面     | string | 是       | 合法的URL链接     |
  | state        | 文章状态 | string | 是       | 草稿 \| 已发布    |
  | categoryName | 分类名   | string | 是       | 所属分类的分类名  |

- 请求参数样例：

  ```
  {
      "title":"旅游攻略",
      "content":"..这是一篇关于xxx的旅游攻略..",
      "coverImg":"http:www.baidu.com",
      "state":"草稿",
      "categoryName": "旅游"
  }
  ```

#### 3.1.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



### 3.2 文章列表查询

#### 3.2.1 基本信息

> 请求路径：/article/listArticle
>
> 请求方式：GET
>
> 接口描述：查询指定条件的文章，分页显示

#### 3.2.2 请求参数

- 请求参数格式：queryString

- 请求参数说明：

  | 参数名称     | 说明       | 类型   | 是否必须 | 备注                 |
  | ------------ | ---------- | ------ | -------- | -------------------- |
  | pageNum      | 当前页码   | number | 是       | \                    |
  | pageSize     | 每页条数   | number | 是       | \                    |
  | categoryName | 文章分类名 | string | 否       | 文章所属分类的分类名 |
  | state        | 发布状态   | string | 否       | 已发布 \| 草稿       |

- 请求参数样例：

  ```
  pageNum=1&pageSize=3&categoryName=旅游
  ```

#### 3.2.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称             | 说明         | 类型   | 是否必须 | 备注                  |
  | ---------------- | ------------ | ------ | -------- | --------------------- |
  | code             | 响应码       | number | 是       | 0表示成功，-1表示失败 |
  | message          | 响应消息     | string | 否       | \                     |
  | data             | 返回的数据   | object | 否       | \                     |
  | \|--total        | 总记录数     | number | 否       | 总记录数              |
  | \|--items        | 数据列表     | array  | 否       | \                     |
  | \|--id           | 文章ID       | number | 否       | \                     |
  | \|--title        | 文章标题     | string | 否       | \                     |
  | \|--content      | 文章正文     | string | 否       | \                     |
  | \|--coverImg     | 文章封面     | string | 否       | 合法的URL             |
  | \|--state        | 文章状态     | string | 否       | 草稿 \| 已发布        |
  | \|--categoryName | 分类名       | string | 否       | \                     |
  | \|--createTime   | 创建时间     | string | 否       | \                     |
  | \|--updateTime   | 最后修改时间 | string | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": {
          "total": 2,
          "items": [
              {
                  "id": 6,
                  "title": "旅游攻略",
                  "content": "阿巴阿巴1",
                  "coverImg": "http:123123",
                  "state": "草稿",
                  "categoryName": "旅游",
                  "createUsername": "Bakar222",
                  "createTime": "2023-12-11 14:16:40",
                  "updateTime": "2023-12-11 14:16:40"
              },
              {
                  "id": 7,
                  "title": "旅游攻略",
                  "content": "..这是一篇关于xxx的旅游攻略..",
                  "coverImg": "http:www.baidu.com",
                  "state": "草稿",
                  "categoryName": "旅游",
                  "createUsername": "Bakar222",
                  "createTime": "2023-12-11 14:25:00",
                  "updateTime": "2023-12-11 14:25:00"
              }
          ]
      }
  }
  ```



### 3.3 获取文章详情

#### 3.3.1 基本信息

> 请求路径：/article/details
>
> 请求方式：GET
>
> 接口描述：获取指定文章详情

#### 3.3.2 请求参数

- 请求参数格式：queryParams

- 请求参数说明：

  | 参数名称 | 说明   | 类型   | 是否必须 | 备注 |
  | -------- | ------ | ------ | -------- | ---- |
  | id       | 文章id | number | 是       | \    |
  
- 请求参数样例：

  ```
  id=7
  ```

#### 3.3.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": {
          "id": 7,
          "title": "旅游攻略",
          "content": "..这是一篇关于xxx的旅游攻略..",
          "coverImg": "http:www.baidu.com",
          "state": "草稿",
          "categoryName": "旅游",
          "createUsername": "Bakar222",
          "createTime": "2023-12-11 14:25:00",
          "updateTime": "2023-12-11 14:25:00"
      }
  }
  ```



### 3.4 更新文章

#### 3.4.1 基本信息

> 请求路径：/article/updateArticle
>
> 请求方式：POST
>
> 接口描述：更新文章信息

#### 3.4.2 请求参数

- 请求参数格式：application/json

- 请求参数说明：

  | 参数名称     | 说明     | 类型   | 是否必须 | 备注              |
  | ------------ | -------- | ------ | -------- | ----------------- |
  | id           | 文章id   | number | 是       | \                 |
  | title        | 标题     | string | 否       | 1~32个非空字符    |
  | content      | 正文     | string | 否       | 0~10000个非空字符 |
  | coverImg     | 封面     | string | 否       | 合法的URL链接     |
  | state        | 文章状态 | string | 否       | 草稿 \| 已发布    |
  | categoryName | 分类名   | string | 否       | 所属分类的分类名  |

- 请求参数样例：

  ```
  {
      "id":4,
      "title":"旅游攻略-成都",
      "content":"..这是一篇关于成都的旅游攻略..",
      "coverImg":"http:www.chengdu.com",
      "state":"已发布",
      "categoryName": "旅游"
  }
  ```

#### 3.4.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



### 3.5 删除文章

#### 3.5.1 基本信息

> 请求路径：/article/deleteArticle
>
> 请求方式：DELETE
>
> 接口描述：删除指定文章

#### 3.5.2 请求参数

- 请求参数格式：queryParams

- 请求参数说明：

  | 参数名称 | 说明   | 类型   | 是否必须 | 备注 |
  | -------- | ------ | ------ | -------- | ---- |
  | id       | 文章id | number | 是       | \    |
  
- 请求参数样例：

  ```
  id=2
  ```

#### 3.5.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```



## 4. 其他接口

### 4.1 文件上传

#### 4.1.1 基本信息

> 请求路径：/upload
>
> 请求方式：POST
>
> 接口描述：上传文件（单个）

#### 4.1.2 请求参数

- 请求参数格式：multipart/form-data

- 请求参数说明：

  | 参数名称 | 说明 | 类型 | 是否必须 | 备注 |
  | -------- | ---- | ---- | -------- | ---- |
  | file     | 文件 | file | 是       | \    |

- 请求参数样例：

  ```
  
  ```

#### 4.1.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```















-------------



### 3.1 更新文章

#### 3.1.1 基本信息

> 请求路径：
>
> 请求方式：
>
> 接口描述：

#### 3.1.2 请求参数

- 请求参数格式：x-www-form-urlencoded

- 请求参数说明：

  | 参数名称 | 说明 | 类型 | 是否必须 | 备注 |
  | -------- | ---- | ---- | -------- | ---- |
  |          |      |      |          |      |
  |          |      |      |          |      |

- 请求参数样例：

  ```
  
  ```

#### 3.1.3 响应数据

- 响应数据类型：application/json

- 响应参数说明：

  | 名称    | 说明       | 类型   | 是否必须 | 备注                  |
  | ------- | ---------- | ------ | -------- | --------------------- |
  | code    | 响应码     | number | 是       | 0表示成功，-1表示失败 |
  | message | 响应消息   | string | 否       | \                     |
  | data    | 返回的数据 | object | 否       | \                     |

- 响应数据样例：

  ```
  {
      "code": 0,
      "message": "操作成功",
      "data": null
  }
  ```

