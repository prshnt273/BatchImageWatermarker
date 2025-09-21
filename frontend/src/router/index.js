import { createRouter, createWebHistory } from 'vue-router'
import { useStore } from "@/stores";
import { _GET } from "@/net/index.js";
import {ElMessage} from "element-plus";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'welcome',
            component: () => import('@/views/common/Welcome.vue'),
            children: [
                {
                    path: '',
                    name: 'welcome-login',
                    component: () => import('@/components/welcome/LoginPage.vue')
                }, {
                    path: 'register',
                    name: 'welcome-register',
                    component: () => import('@/components/welcome/RegisterPage.vue')
                }, {
                    path: 'forget',
                    name: 'welcome-forget',
                    component: () => import('@/components/welcome/ForgetPage.vue')
                }
            ]
        }, {
            path: '/test',
            name: 'test',
            component: () => import('@/views/common/Test.vue'),
            meta: {
                title: 'Test',
                icon: '/icon/Test.png'
            }
        }, {
            path: '/batch-image-watermarker',
            name: 'batch-image-watermarker',
            component: () => import('@/views/batchImageWatermarker/BatchImageWatermarker.vue'),
            meta: {
                title: '批量图片水印处理',
                icon: '/icon/BatchImageWatermarker.png'
            }
        }
    ]
})

router.beforeEach(async (to, from, next) => {
    const store = useStore();
    if (store.auth.user && to.name.startsWith('welcome')) {
        next('/batch-image-watermarker');
    } else if (!store.auth.user && !to.name.startsWith('welcome-')) {
        ElMessage.warning('自动登录失效，请重新登录');
        next('/');
    } else {
        next();
    }
});

export default router
