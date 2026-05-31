# HouDuan1

## 功能概览
- Spring Boot REST API，提供用户注册/登录、风险评估、诈骗场景查询、举报信息提交与列表。
- 用户与举报数据目前用内存 `ConcurrentHashMap` 保存，服务重启会丢失；未使用数据库持久化。
- `SecurityConfig` 已开启 CORS（允许任意来源），CSRF 关闭，接口对外开放。

## 前端对接要点
- 先运行后端并确认 Base URL（默认 `http://localhost:8080`）。
- 前端使用 JSON 请求（`Content-Type: application/json`）。
- 若前端有跨域，当前已放开 CORS；如需限制来源再调整后端允许的 origin。
- 开发时可在前端配置代理指向后端 Base URL，生产环境用同域或网关转发。

## 接口列表

### 用户
- `POST /api/user/register`
  - 请求体：`{ "username": "...", "password": "..." }`
  - 响应：`"注册成功"` 或 `"用户名已存在"`
- `POST /api/user/login`
  - 请求体：`{ "username": "...", "password": "..." }`
  - 响应：`"登录成功"` 或 `"用户名或密码错误"`

### 场景
- `GET /api/scenarios`：返回场景列表
- `GET /api/scenarios/{code}`：返回单个场景，不存在返回 404

### 风险评估
- `POST /api/risk/evaluate`
  - 请求体：`{ "url": "...", "content": "..." }`
  - 响应：`level`、`score`、`hitRules`、`suggestion`

### 举报
- `POST /api/reports`
  - 请求体：`{ "type": "...", "evidence": "...", "reporter": "..." }`
  - 成功响应：举报对象（含 `id`、`createdAt`）
  - 参数缺失：返回 400，`{ "error": "..." }`
- `GET /api/reports`：返回举报列表