<template>
  <q-scroll-area class="fit">
    <q-list>
      <menu-item
        v-for="menuItem in boardList.board"
        :key="menuItem"
        v-bind="menuItem"
      />
    </q-list>
  </q-scroll-area>
</template>
<script setup>
import MenuItem from './MenuItem.vue';
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import { useGlobalStore } from '../../store/global';
import axios from 'axios';

const $router = useRouter();
const global = useGlobalStore();

const boardList = reactive({
  board: [],
});

function selectData() {
  axios.post('/api/menu/list').then(response => {
    const currList = {
      currPath: $router.currentRoute.value.path,
      currMenu: [],
    };
    boardList.board = response.data.result;
    currList.currMenu = appendRouter(boardList.board, currList.currPath);
    if (currList.currMenu != null) {
      global.currentMenu = currList.currMenu.menuCode;
      if (!$router.hasRoute(currList.currMenu.menuRouter)) {
        $router.addRoute({
          path: currList.currMenu.menuRouter,
          name: currList.currMenu.menuName,
          component: () => {
            return import(
              '../../views/' + currList.currMenu.menuPath + '.vue'
            ).then(m => {
              global.loadMenu = true;
              return m;
            });
          },
        });
      }
    } else {
      global.loadMenu = true;
    }
    $router.push(currList.currMenu.menuRouter);
  });
}

function appendRouter(menuList, path) {
  for (var i = 0; i < menuList.length; i++) {
    if (menuList[i].menuRouter === path) {
      return menuList[i];
    }
  }
  return null;
}

selectData();
</script>
