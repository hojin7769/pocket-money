import { createApp } from 'vue';
import './style.css';
import App from './App.vue';
import router from './router/index.js';
import { Quasar, Dialog } from 'quasar';
import Plugin from '@quasar/quasar-ui-qcalendar/src/QCalendarDay.js';
import '@quasar/quasar-ui-qcalendar/src/css/calendar-day.sass';

// Import icon libraries
import '@quasar/extras/material-icons/material-icons.css';
// Import Quasar css
import 'quasar/src/css/index.sass';

import { createPinia } from 'pinia';

const Vue = createApp(App);
const pinia = createPinia();
Vue.use(pinia)
  .use(Plugin)
  .use(router)
  .use(Quasar, {
    plugins: { Dialog }, // import Quasar plugins and add here
  })
  .mount('#app');
