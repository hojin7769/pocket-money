import { defineStore } from 'pinia';

export const useGlobalStore = defineStore({
  id: 'global',
  state: () => ({
    $ui: null,
    currentMenu: null,
    loadMenu: false,
    dynamicDialogLayout: false,
  }),
  actions: {},
});
