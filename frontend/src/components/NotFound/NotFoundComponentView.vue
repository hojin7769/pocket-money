<template>
  <div v-if="global.loadMenu" class="q-pa-md">Not Found Page.</div>
</template>
<script setup>
import { useGlobalStore } from '../../store/global';
const global = useGlobalStore();
</script>
