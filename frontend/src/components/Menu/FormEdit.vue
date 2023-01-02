<script setup>
import { ref } from '@vue/reactivity';
import { useQuasar } from 'quasar';
import { useRouter } from 'vue-router';
import { msg } from '../../util/Utils.js';
import { useGlobalStore } from '../../store/global.js';
import axios from 'axios';

const $q = useQuasar();
const global = useGlobalStore();
const $router = useRouter();
const closed = ref(false);
const props = defineProps(['menu', 'type', 'oldCD']);
const editMenu = () => {
  if (props.type) {
    const param = {
      menu: props.menu,
      oldCD: props.oldCD,
    };
    axios.post('/api/menu/update', param).then(res => {
      msg.alert({
        title: 'Update Success',
        message: res.data.message,
        onOK: () => {},
        onDismiss: () => {
          $router.push('/FormMaster');
          props.menu = null;
        },
      });
    });
  } else {
    const param = {
      menuName: props.menu.menuName,
      menuCode: props.menu.menuCode,
      menuIcon: props.menu.menuIcon,
      menuOrder: props.menu.menuOrder,
      menuPath: props.menu.menuPath,
      menuRouter: props.menu.menuRouter,
    };
    axios.post('/api/menu/addMenu', param).then(res => {
      msg.alert({
        title: 'Insert Success',
        message: res.data.message,
        onOK: () => {},
        onDismiss: () => {
          $router.push('/menuList');
          props.menu = null;
        },
      });
    });
  }
};
const deleteMenu = () => {
  msg.confirm({
    title: '알림',
    message: '삭제하겠습니까?',
    onOk: () => {
      axios.post('/api/menu/deletemenu', props.menu).then(res => {
        msg.alert({
          title: 'Delete Success',
          message: res.data.message,
          onOK: () => {
            $router.go();
            props.menu = null;
          },
          onDismiss: () => {
            $router.go();
            props.menu = null;
          },
        });
      });
    },
    onCancel: () => {
      msg.alert({
        title: '알림',
        message: '취소되었습니다.',
      });
    },
  });
};
const fixed = ref(false);
const text = ref('');
const ph = ref('');
const dense = ref(false);
</script>

<template>
  <q-dialog v-model="fixed" style="max-width: 500px; width: 100%">
    <q-card>
      <q-card-section>
        <div class="q-gutter-md" style="max-width: 500px">
          <div class="text-h6">메뉴(화면) 관리창</div>
        </div>
      </q-card-section>

      <q-separator />
      <q-form @submit="editMenu" class="joinForm q-gutter-sm">
        <q-card-section style="max-height: 100vh" class="scroll">
          <q-input
            clearable
            filled
            color="purple-12"
            v-model="menu.menuCode"
            label="메뉴아이디"
            class="input"
            :rules="[val => !!val || '필수 입력값 입니다.']"
            maxlength="10"
          />

          <q-input
            clearable
            filled
            color="purple-12"
            v-model="menu.menuName"
            label="메뉴명"
            class="input"
            :rules="[val => !!val || '필수 입력값 입니다.']"
          />

          <q-input
            clearable
            filled
            color="purple-12"
            v-model="menu.menuIcon"
            label="메뉴아이콘"
            class="input"
            :rules="[val => !!val || '필수 입력값 입니다.']"
          />

          <q-input
            clearable
            filled
            color="purple-12"
            v-model="menu.menuOrder"
            label="메뉴순서"
            class="input"
            maxlength="10"
            :rules="[val => !!val || '필수 입력값 입니다.']"
          />
          <q-input
            clearable
            filled
            color="purple-12"
            v-model="menu.menuPath"
            label="메뉴Path"
            class="input"
            :rules="[val => !!val || '필수 입력값 입니다.']"
          />
          <q-input
            clearable
            filled
            color="purple-12"
            v-model="menu.menuRouter"
            label="메뉴Router"
            class="input"
            :rules="[val => !!val || '필수 입력값 입니다.']"
          />
          <!--          <q-input-->
          <!--            clearable-->
          <!--            filled-->
          <!--            color="purple-12"-->
          <!--            v-model="menu.menu.nmInserter"-->
          <!--            label="작성자"-->
          <!--            class="input"-->
          <!--            disable="disable"-->
          <!--            :rules="[val => !!val || '필수 입력값 입니다.']"-->
          <!--          />-->
        </q-card-section>
        <q-separator />
        <q-card-actions align="right">
          <q-btn
            type="submit"
            flat
            label="확인"
            color="primary"
            v-close-popup
          />
          <q-btn
            flat
            label="삭제"
            color="primary"
            @click="deleteMenu()"
            v-close-popup
            v-if="menu.type"
          />
        </q-card-actions>
      </q-form>
    </q-card>
  </q-dialog>
</template>
<style scoped>
.input {
  width: 100vmin;
  max-width: 500px;
  margin: 10px;
}
</style>
