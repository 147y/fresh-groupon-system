import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import User from '../views/User.vue'

const routes = [
    {
        path: '/',
        redirect: '/home',
        children: [
            {
                path: '/home',
                component: Home
            },
            {
                path: '/user', // 这个路径要和你菜单里的 index 一致
                component: User
            }
        ]
    }
];

const router = createRouter({
  history: createWebHistory(),
  routes: routes
})

export default router;