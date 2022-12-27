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

    <q-drawer show-if-above v-model="leftDrawerOpen" side="left" elevated>
      <menu-list />
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script setup>
// import LoginComp from "@/components/LoginComp.vue";
import MenuList from './components/Menu/MenuList.vue';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useGlobalStore } from './store/global';
import { useQuasar } from 'quasar';

const $q = useQuasar();
const $router = useRouter();
const global = useGlobalStore();

const leftDrawerOpen = ref(false);
const dark = ref(false);

global.$ui = $q;

const toggleLeftDrawer = () => {
  leftDrawerOpen.value = !leftDrawerOpen.value;
};

const onDarkMode = value => {
  localStorage.setItem('darkMode', value);
  $q.dark.set(value);
};

if (localStorage.getItem('darkMode') != null) {
  dark.value = JSON.parse(localStorage.getItem('darkMode'));
  $q.dark.set(dark.value);
}
</script>
