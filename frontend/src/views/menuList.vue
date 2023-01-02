<script setup>
import { reactive, ref } from '@vue/reactivity';
import { useQuasar } from 'quasar';
import FormEditVue from '../components/Menu/FormEdit.vue';
import { useGlobalStore } from '../store/global.js';
import DynamicDialog from '../components/Dialogs/DynamicDialog.vue';
import axios from 'axios';
import menuTable from '../util/TableList/MenuEditTable';
import { msg } from '../util/Utils';
//사용할 변수 선언
const $q = useQuasar();
const global = useGlobalStore();
global.$ui = $q;
const search = ref(null);
const model = ref(null);
const menuList = reactive({
  rows: [],
});
const options = menuTable.options;
const columns = menuTable.columns;

const visibleColumnsSm = ref(['snSeq', 'menuName']);
const visibleColumnsMd = ref(['snSeq', 'menuName', 'menuCode', 'menuIcon']);
const visibleColumnsLg = ref([
  'snSeq',
  'menuName',
  'menuCode',
  'menuIcon',
  'menuOrder',
  'menuPath',
  'menuRouter',
]);
const menu = reactive({
  menu: {
    menuName: '',
    menuCode: '',
    menuIcon: '',
    menuOrder: '',
    menuPath: '',
    menuRouter: '',
  },
});

model.value = options[0];
const formName = ref(['']);

const init = () => {
  menu.menu.menuName = '';
  menu.menu.menuCode = '';
  menu.menu.menuIcon = '';
  menu.menu.menuOrder = '';
  menu.menu.menuPath = '';
  menu.menu.menuRouter = '';
};

const fullList = () => {
  const param = {
    model: model.value.value,
    search: search.value,
  };
  axios.post('/api/menu/list', param).then(res => {
    menuList.rows = res.data.result;
  });
};
fullList();

const updateRow = (evt, row, index) => {
  // formName.value = "FormEdit";
  // global.dynamicDialogLayout = true;
  // global.targetRow = {
  //   menu: row,
  //   type: true,
  //   oldCD: row.codeMenu,
  // };
  // console.log(global.targetRow);
  // msg.dialog(opt);
  console.log(row);
  $q.dialog({
    component: FormEditVue,
    componentProps: {
      menu: row,
      type: true,
      oldCD: row.menuCode,
    },
    close: true,
    persistent: true,
  })
    .onOk(() => {
      console.log('OK');
    })
    .onCancel(() => {})
    .onDismiss(() => {
      fullList();
    });
};
const addMenu = () => {
  $q.dialog({
    component: FormEditVue,
    componentProps: {
      menu: menu.menu,
      type: false,
    },
    cancel: true,
    persistent: true,
    emit: reload,
  })
    .onOk(() => {
      console.log('OK');
    })
    .onCancel(() => {})
    .onDismiss(() => {
      fullList();
      init();
    });
};

const reload = () => {
  model.value = options[0];
  search.value = null;
  fullList();
};

const searchMenu = () => {
  fullList();
};
const fabRight = ref(false);
</script>
<!-- <template>
  <div> -->
<!-- <q-splitter v-model="splitterModel" unit="px" style="height: 100vh">
      <template v-slot:before>
        <div class="q-pa-md">
          <div class="text-h4 q-mb-md">Before</div>
           <div v-for="n in 20" :key="n" class="q-my-md">
            {{ n }}. Lorem ipsum dolor sit, amet consectetur adipisicing elit.
            Quis praesentium cumque magnam odio iure quidem, quod illum numquam
            possimus obcaecati commodi minima assumenda consectetur culpa fuga
            nulla ullam. In, libero.
          </div>
        </div>
      </template> -->

<!-- <template v-slot:after> -->
<template>
  <q-page padding>
    <div class="board-page q-pa-md">
      <q-table
        class="board-table"
        title-class="text-bold text-black-8"
        :rows="menuList.rows"
        :columns="columns"
        title="화면등록"
        table-header-style="text-bold"
        table-header-class="text-blue-8"
        row-key="name"
        @row-click="updateRow"
        separator="horizontal"
        card-container-style="background-color: black"
        :rows-per-page-options="[0]"
        virtual-scroll
        :visible-columns="
          global.$ui.screen.width < 1000
            ? global.$ui.screen.width < 500
              ? visibleColumnsSm
              : visibleColumnsMd
            : visibleColumnsLg
        "
      />
      <div class="row justify-between">
        <q-page-sticky position="bottom-right" :offset="[18, 18]">
          <q-fab
            v-model="fabRight"
            vertical-actions-align="right"
            color="primary"
            glossy
            icon="add"
            direction="up"
          >
            <q-fab-action
              label-position="left"
              color="primary"
              @click="addMenu"
              icon="edit"
              label="메뉴추가"
            />
            <q-fab-action
              label-position="left"
              color="orange"
              @click="reload()"
              icon="refresh"
              label="새로고침"
            />
          </q-fab>
        </q-page-sticky>
        <dynamic-dialog
          v-if="global.dynamicDialogLayout"
          :formName="formName"
          @updated="fullList"
        />
      </div>
    </div>
  </q-page>
</template>
<!-- </q-splitter>
  </div>
</template> -->

<style scoped>
.board-page {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.board-table {
  width: 80%;
  /* margin-top: 4%; */
  height: 500px;
}
/* @media (max-width: 500px) {
  .board-table {
    width: 90%;
    height: 90%;
  }
}

@media (max-width: 700px) {
  .board-table {
    width: 90%;
    height: 250px;
  }
} */
</style>
