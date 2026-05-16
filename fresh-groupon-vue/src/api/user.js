import axios from 'axios'

// 创建 axios 实例
const api = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 5000
})

// ====================== 用户管理接口 ======================

// 1. 查询所有用户
export function getAllUsers() {
    return api.get('/user')
}

// 2. 根据 ID 查询用户
export function getUserById(id) {
    return api.get(`/user/${id}`)
}

// 3. 按用户名搜索
export function getUsersByName(username) {
    return api.get('/user/search', {
        params: { username }
    })
}

// 4. 分页查询用户
export function getUserPage(pageNum, pageSize = 10) {
    return api.get('/user/page', {
        params: { pageNum, pageSize }
    })
}

// 5. 新增用户
export function addUser(user) {
    return api.post('/user', user)
}

// 6. 修改用户
export function updateUser(user) {
    return api.put('/user', user)
}

// 7. 删除用户
export function deleteUser(id) {
    return api.delete(`/user/${id}`)
}