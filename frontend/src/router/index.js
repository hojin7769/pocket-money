import { createApp } from 'vue';
import {
  createRouter,
  createWebHashHistory,
  createWebHistory,
} from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/HomeView.vue'),
  },
];

// create history
const router = createRouter({
  history: createWebHashHistory(),
  routes,
});
export default router;
