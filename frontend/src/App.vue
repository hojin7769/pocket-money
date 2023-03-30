<template>
  <q-layout view="hHh lpR fFf">
    <q-header reveal elevated class="bg-primary text-white">
      <q-toolbar>
        <q-btn dense flat round icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          <q-avatar>
            <img src="https://cdn.quasar.dev/logo-v2/svg/logo-mono-white.svg" />
          </q-avatar>
          Title
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      class="drawer"
      :width="250"
      side="left"
      behavior="default"
      show-if-above
      elevated
    >
      <menu-list></menu-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script setup>
import MenuList from './components/Menu/MenuList.vue';
import { ref } from 'vue';
import { useGlobalStore } from './store/global';
import { useQuasar } from 'quasar';

const $q = useQuasar();
const global = useGlobalStore();

const leftDrawerOpen = ref(false);

global.$ui = $q;

const toggleLeftDrawer = () => {
  leftDrawerOpen.value = !leftDrawerOpen.value;
};
</script>
