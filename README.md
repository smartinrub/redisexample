# redisexample
## Getting Started
### Setup Redis Server
- Install Redis
Mac OS:
```bash
brew install redis
```
- Start server
```bash
redis-server
```
- Setup password
```bash
redis-cli -h localhost -p 6379
CONFIG SET requirepass "password"
```

