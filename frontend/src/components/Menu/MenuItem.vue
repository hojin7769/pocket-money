<template>
  <div>
    <q-item
      clickable
      v-ripple
      :inset-level="level == 0 ? -1 : level / 9"
      :active="menuRouter === global.currentMenu"
      @click="addrouting(props)"
    >
      <q-item-section avatar class="item_avatar">
        <q-icon :name="menuIcon" />
      </q-item-section>
      <q-item-section>
        {{ level > 0 ? menuName : menuName }}
      </q-item-section>
    </q-item>
  </div>
</template>
<style scoped>
.item_avatar {
  min-width: inherit;
}
.item_avatar :deep(.q-item__section--avatar) {
  min-width: inherit;
}
</style>
<script setup>
import { toRefs } from 'vue';
import { useGlobalStore } from '../../store/global';

import { useRouter } from 'vue-router';
import { msg } from '../../util/Utils';

const $router = useRouter();
const global = useGlobalStore();

const props = defineProps({
  menuName: {
    type: String,
    required: true,
  },

  menuIcon: {
    type: String,
    default: '',
  },

  menuRouter: {
    type: String,
    default: '',
  },

  menuPath: {
    type: String,
    default: '',
  },

  level: {
    type: Number,
  },

  menuOpened: {
    type: Boolean,
  },
});

const { menuName, menuIcon, menuRouter, level, menuOpened } = toRefs(props);

function addrouting(item) {
  global.currentMenu = item.menuCode;
  $router.addRoute({
    path: item.menuRouter,
    name: item.menuName,
    component: () => import('../../views/' + item.menuPath + '.vue'),
  });
  $router.push(item.menuRouter);
}
</script>
