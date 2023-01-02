import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'DashBoard',
    component: () => import('../views/DashBoard.vue'),
  },
];

// create history
const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;
