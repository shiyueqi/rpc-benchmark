namespace java com.unionpay.rpc.benchmark.thrift.api

struct UserDto {
    1: i64 userId
    2: string userName
    3: string phone
    4: string email
    5: string address
    6: i32 age
    7: i32 gender
    8: i32 userStatus
    9: i64 createdAt
    10:i64 lastModified
}

service UserService {

    UserDto getUser(1:i64 userId),

    string getUserName(2:i64 userId),
}