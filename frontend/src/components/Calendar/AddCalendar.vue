<script setup>
import { ref } from 'vue';

const props = defineProps(['dialog']);
defineEmits(['closePopup']);

const dialog = ref(props.dialog);

const title = ref();
const val = ref(false);
const date = ref();

const editEvent = value => {
  console.log(value);
};
</script>

<template>
  <q-dialog v-model="dialog" persistent style="max-width: 500px; width: 100%">
    <q-card>
      <q-card-section class="bg-primary text-white">
        <div class="row items-center justify-between">
          <div style="font-weight: 700; font-size: 25px; text-align: center">
            Role 화면관리
          </div>
          <q-btn
            padding="0"
            round
            flat
            icon="close"
            v-close-popup
            @click="$emit('closePopup')"
          />
        </div>
      </q-card-section>
      <q-form @submit="editEvent" class="joinForm q-gutter-sm">
        <q-card-section style="max-height: 100vh" class="scroll">
          <q-input
            clearable
            filled
            color="purple-12"
            v-model="title"
            label="Title"
            class="input"
            :rules="[val => !!val || '필수 입력값 입니다.']"
          />
          <q-input
            clearable
            filled
            color="purple-12"
            v-model="title"
            label="Details"
            class="input"
            :rules="[val => !!val || '필수 입력값 입니다.']"
          />
          <q-separator />
          <div class="q-pa-md">
            <q-checkbox v-model="val" label="All-Day event" />
          </div>
          <q-separator />
          <div class="q-pa-md" style="max-width: 300px">
            <q-input filled v-model="date">
              <template v-slot:prepend>
                <q-icon name="event" class="cursor-pointer">
                  <q-popup-proxy
                    cover
                    transition-show="scale"
                    transition-hide="scale"
                  >
                    <q-date v-model="date" mask="YYYY-MM-DD HH:mm">
                      <div class="row items-center justify-end">
                        <q-btn
                          v-close-popup
                          label="Close"
                          color="primary"
                          flat
                        />
                      </div>
                    </q-date>
                  </q-popup-proxy>
                </q-icon>
              </template>

              <template v-slot:append>
                <q-icon name="access_time" class="cursor-pointer">
                  <q-popup-proxy
                    cover
                    transition-show="scale"
                    transition-hide="scale"
                  >
                    <q-time v-model="date" mask="YYYY-MM-DD HH:mm" format24h>
                      <div class="row items-center justify-end">
                        <q-btn
                          v-close-popup
                          label="Close"
                          color="primary"
                          flat
                        />
                      </div>
                    </q-time>
                  </q-popup-proxy>
                </q-icon>
              </template>
            </q-input>
          </div>
        </q-card-section>
      </q-form>
    </q-card>
  </q-dialog>
</template>
