# redisexample
## Getting Started
### Setup Redis Server
- Start server
```bash
redis-server
```
- Setup password
```bash
redis-cli -h localhost -p 6379
CONFIG SET requirepass "password"
```

