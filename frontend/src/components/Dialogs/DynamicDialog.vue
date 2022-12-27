<script setup>
import { defineAsyncComponent } from 'vue';
import { useGlobalStore } from '../../store/global.js';

const global = useGlobalStore();

const props = defineProps(['formName', 'position', 'maximized']);
const dynamicForm = defineAsyncComponent(() =>
  import(`../components/forms/${props.formName}.vue`),
);
</script>

<template>
  <q-dialog
    v-model="global.dynamicDialogLayout"
    persistent
    :maximized="props.maximized"
    :position="props.position"
  >
    <component
      :is="dynamicForm"
      @updated="$emit('updated')"
      @inserted="$emit('inserted')"
    ></component>
  </q-dialog>
</template>

<style scoped></style>
